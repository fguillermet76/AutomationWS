package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile PayWay : URL</p>
     */
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object URLYopMail
     
    /**
     * <p>Profile PayWay : Usuario login</p>
     */
    public static Object LoginUser
     
    /**
     * <p>Profile PayWay : Password usuario</p>
     */
    public static Object LoginPswd
     
    /**
     * <p>Profile PayWay : Usuario incorrecto</p>
     */
    public static Object LoginBadUser
     
    /**
     * <p>Profile PayWay : Password incorrecto</p>
     */
    public static Object LoginBadPswd
     
    /**
     * <p>Profile PayWay : Mail mal escrito</p>
     */
    public static Object LoginMalMalEscrito
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters())
    
            URL = selectedVariables['URL']
            URLYopMail = selectedVariables['URLYopMail']
            LoginUser = selectedVariables['LoginUser']
            LoginPswd = selectedVariables['LoginPswd']
            LoginBadUser = selectedVariables['LoginBadUser']
            LoginBadPswd = selectedVariables['LoginBadPswd']
            LoginMalMalEscrito = selectedVariables['LoginMalMalEscrito']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
