
/* First created by JCasGen Wed Feb 20 04:59:42 EST 2013 */
package edu.cmu.lti.qalab.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Dec 05 14:35:26 EST 2013
 * @generated */
public class Question_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Question_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Question_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Question(addr, Question_Type.this);
  			   Question_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Question(addr, Question_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Question.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.lti.qalab.types.Question");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated */ 
  public String getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_id);
  }
  /** @generated */    
  public void setId(int addr, String v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_text;
  /** @generated */
  final int     casFeatCode_text;
  /** @generated */ 
  public String getText(int addr) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_text);
  }
  /** @generated */    
  public void setText(int addr, String v) {
        if (featOkTst && casFeat_text == null)
      jcas.throwFeatMissing("text", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_text, v);}
    
  
 
  /** @generated */
  final Feature casFeat_dependencies;
  /** @generated */
  final int     casFeatCode_dependencies;
  /** @generated */ 
  public int getDependencies(int addr) {
        if (featOkTst && casFeat_dependencies == null)
      jcas.throwFeatMissing("dependencies", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getRefValue(addr, casFeatCode_dependencies);
  }
  /** @generated */    
  public void setDependencies(int addr, int v) {
        if (featOkTst && casFeat_dependencies == null)
      jcas.throwFeatMissing("dependencies", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setRefValue(addr, casFeatCode_dependencies, v);}
    
  
 
  /** @generated */
  final Feature casFeat_nerList;
  /** @generated */
  final int     casFeatCode_nerList;
  /** @generated */ 
  public int getNerList(int addr) {
        if (featOkTst && casFeat_nerList == null)
      jcas.throwFeatMissing("nerList", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getRefValue(addr, casFeatCode_nerList);
  }
  /** @generated */    
  public void setNerList(int addr, int v) {
        if (featOkTst && casFeat_nerList == null)
      jcas.throwFeatMissing("nerList", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setRefValue(addr, casFeatCode_nerList, v);}
    
  
 
  /** @generated */
  final Feature casFeat_nounList;
  /** @generated */
  final int     casFeatCode_nounList;
  /** @generated */ 
  public int getNounList(int addr) {
        if (featOkTst && casFeat_nounList == null)
      jcas.throwFeatMissing("nounList", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getRefValue(addr, casFeatCode_nounList);
  }
  /** @generated */    
  public void setNounList(int addr, int v) {
        if (featOkTst && casFeat_nounList == null)
      jcas.throwFeatMissing("nounList", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setRefValue(addr, casFeatCode_nounList, v);}
    
  
 
  /** @generated */
  final Feature casFeat_tokenList;
  /** @generated */
  final int     casFeatCode_tokenList;
  /** @generated */ 
  public int getTokenList(int addr) {
        if (featOkTst && casFeat_tokenList == null)
      jcas.throwFeatMissing("tokenList", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getRefValue(addr, casFeatCode_tokenList);
  }
  /** @generated */    
  public void setTokenList(int addr, int v) {
        if (featOkTst && casFeat_tokenList == null)
      jcas.throwFeatMissing("tokenList", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setRefValue(addr, casFeatCode_tokenList, v);}
    
  
 
  /** @generated */
  final Feature casFeat_questionType;
  /** @generated */
  final int     casFeatCode_questionType;
  /** @generated */ 
  public int getQuestionType(int addr) {
        if (featOkTst && casFeat_questionType == null)
      jcas.throwFeatMissing("questionType", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getIntValue(addr, casFeatCode_questionType);
  }
  /** @generated */    
  public void setQuestionType(int addr, int v) {
        if (featOkTst && casFeat_questionType == null)
      jcas.throwFeatMissing("questionType", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setIntValue(addr, casFeatCode_questionType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_hasNoneOfTheAbove;
  /** @generated */
  final int     casFeatCode_hasNoneOfTheAbove;
  /** @generated */ 
  public boolean getHasNoneOfTheAbove(int addr) {
        if (featOkTst && casFeat_hasNoneOfTheAbove == null)
      jcas.throwFeatMissing("hasNoneOfTheAbove", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_hasNoneOfTheAbove);
  }
  /** @generated */    
  public void setHasNoneOfTheAbove(int addr, boolean v) {
        if (featOkTst && casFeat_hasNoneOfTheAbove == null)
      jcas.throwFeatMissing("hasNoneOfTheAbove", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_hasNoneOfTheAbove, v);}
    
  
 
  /** @generated */
  final Feature casFeat_answerClass;
  /** @generated */
  final int     casFeatCode_answerClass;
  /** @generated */ 
  public String getAnswerClass(int addr) {
        if (featOkTst && casFeat_answerClass == null)
      jcas.throwFeatMissing("answerClass", "edu.cmu.lti.qalab.types.Question");
    return ll_cas.ll_getStringValue(addr, casFeatCode_answerClass);
  }
  /** @generated */    
  public void setAnswerClass(int addr, String v) {
        if (featOkTst && casFeat_answerClass == null)
      jcas.throwFeatMissing("answerClass", "edu.cmu.lti.qalab.types.Question");
    ll_cas.ll_setStringValue(addr, casFeatCode_answerClass, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Question_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.String", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_text = jcas.getRequiredFeatureDE(casType, "text", "uima.cas.String", featOkTst);
    casFeatCode_text  = (null == casFeat_text) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_text).getCode();

 
    casFeat_dependencies = jcas.getRequiredFeatureDE(casType, "dependencies", "uima.cas.FSList", featOkTst);
    casFeatCode_dependencies  = (null == casFeat_dependencies) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_dependencies).getCode();

 
    casFeat_nerList = jcas.getRequiredFeatureDE(casType, "nerList", "uima.cas.FSList", featOkTst);
    casFeatCode_nerList  = (null == casFeat_nerList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_nerList).getCode();

 
    casFeat_nounList = jcas.getRequiredFeatureDE(casType, "nounList", "uima.cas.FSList", featOkTst);
    casFeatCode_nounList  = (null == casFeat_nounList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_nounList).getCode();

 
    casFeat_tokenList = jcas.getRequiredFeatureDE(casType, "tokenList", "uima.cas.FSList", featOkTst);
    casFeatCode_tokenList  = (null == casFeat_tokenList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenList).getCode();

 
    casFeat_questionType = jcas.getRequiredFeatureDE(casType, "questionType", "uima.cas.Integer", featOkTst);
    casFeatCode_questionType  = (null == casFeat_questionType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_questionType).getCode();

 
    casFeat_hasNoneOfTheAbove = jcas.getRequiredFeatureDE(casType, "hasNoneOfTheAbove", "uima.cas.Boolean", featOkTst);
    casFeatCode_hasNoneOfTheAbove  = (null == casFeat_hasNoneOfTheAbove) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_hasNoneOfTheAbove).getCode();

 
    casFeat_answerClass = jcas.getRequiredFeatureDE(casType, "answerClass", "uima.cas.String", featOkTst);
    casFeatCode_answerClass  = (null == casFeat_answerClass) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answerClass).getCode();

  }
}



    