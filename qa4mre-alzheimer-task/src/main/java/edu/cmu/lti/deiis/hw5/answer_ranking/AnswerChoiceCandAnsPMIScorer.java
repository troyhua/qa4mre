package edu.cmu.lti.deiis.hw5.answer_ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.core.provider.solr.SolrWrapper;
import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.CandidateAnswer;
import edu.cmu.lti.qalab.types.CandidateSentence;
import edu.cmu.lti.qalab.types.CandidateSentenceAnswerSet;
import edu.cmu.lti.qalab.types.NER;
import edu.cmu.lti.qalab.types.NounPhrase;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;

public class AnswerChoiceCandAnsPMIScorer extends AnswerScoreBaseClass {

  private SolrWrapper solrWrapper;

  HashSet<String> hshStopWords = new HashSet<String>();

  int K_CANDIDATES = 5;

  @Override
  public void initialize(UimaContext context) throws ResourceInitializationException {
    super.initialize(context);
    String serverUrl = (String) context.getConfigParameterValue("SOLR_SERVER_URL");
    K_CANDIDATES = (Integer) context.getConfigParameterValue("K_CANDIDATES");

    try {
      System.out.println(serverUrl);
      this.solrWrapper = new SolrWrapper(serverUrl);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public double computScore(Answer answer, CandidateSentence sentence) {
    double score1 = 0.0;
    double score2 = 0.0;
    ArrayList<NounPhrase> candSentNouns = Utils.fromFSListToCollection(sentence.getSentence()
            .getPhraseList(), NounPhrase.class);
    ArrayList<NER> candSentNers = Utils.fromFSListToCollection(sentence.getSentence().getNerList(),
            NER.class);

    for (int k = 0; k < candSentNouns.size(); k++) {
      try {
        score1 += scoreCoOccurInSameDoc(candSentNouns.get(k).getText(), answer);

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    if (candSentNouns.size() != 0)
      score1 = score1 / Math.sqrt(candSentNouns.size()); 

    for (int k = 0; k < candSentNers.size(); k++) {
      try {
        score2 += scoreCoOccurInSameDoc(candSentNers.get(k).getText(), answer);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    if (candSentNers.size() != 0)
      score2 = score2 / Math.sqrt(candSentNers.size());
    double score = 0.0;
    if (candSentNers.size() == 0 || candSentNouns.size() == 0)
      score = score1  + score2;
    else
      score = (score1 + score2) / 2;
    return score;
  }

  @Override
  public void processCandidateAnswerScore(CandidateAnswer candidateAnswer,
          CandidateSentence sentence, Answer answer) {
    candidateAnswer.setPMIScore(computScore(answer, sentence));
  }

  public double scoreCoOccurInSameDoc(String question, Answer choice) throws Exception {
    ArrayList<NounPhrase> choiceNounPhrases = Utils.fromFSListToCollection(
            choice.getNounPhraseList(), NounPhrase.class);
    ArrayList<Token> choiceUnigram = Utils.fromFSListToCollection(choice.getTokenList(), Token.class);
    double score = 0.0;
    ArrayList<String> answerTokens = new ArrayList<String>();
    if (choiceNounPhrases.size() != 0){
      for (NounPhrase np : choiceNounPhrases)
        answerTokens.add(np.getText());
    }else{
      for (Token token : choiceUnigram)
        answerTokens.add(token.getText());
    }
    for (String choiceNounPhrase : answerTokens) {
      if (question.split("[ ]").length > 1) {
        question = "\"" + question + "\"";
      }
      if (choiceNounPhrase.split("[ ]").length > 1) {
        choiceNounPhrase = "\"" + choiceNounPhrase + "\"";
      }

      String query = question + " AND " + choiceNounPhrase;
      HashMap<String, String> params = new HashMap<String, String>();
      params.put("q", query);
      params.put("rows", "1");
      SolrParams solrParams = new MapSolrParams(params);
      QueryResponse rsp = null;
      long combinedHits = 0;
      try {
        rsp = solrWrapper.getServer().query(solrParams);
        combinedHits = rsp.getResults().getNumFound();
      } catch (Exception e) {
        System.out.println(e);
      }

      query = choiceNounPhrase;
      params = new HashMap<String, String>();
      params.put("q", query);
      params.put("rows", "1");
      solrParams = new MapSolrParams(params);

      long nHits1 = 0;
      try {
        rsp = solrWrapper.getServer().query(solrParams);
        nHits1 = rsp.getResults().getNumFound();
      } catch (Exception e) {
        System.out.println(e);
      }

      if (nHits1 != 0) {
        score += (double) combinedHits / nHits1;
      }
    }
//    if (choiceNounPhrases.size() == 0) {
       score = score / answerTokens.size();
//    }
    return score;
  }

  public double myLog(long combined, long nHits1, long nHits2) {
    if (combined == 0 || nHits1 == 0 || nHits2 == 0) {
      return 0;
    }
    double logValue = Math.log(combined) - Math.log(nHits1) - Math.log(nHits2);
    return logValue;
  }

}
