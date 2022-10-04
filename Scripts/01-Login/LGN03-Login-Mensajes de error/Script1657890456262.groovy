import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Objetos
txtMail = findTestObject('Object Repository/01-Login/txtMail')
txtPassword = findTestObject('Object Repository/01-Login/txtPassword')
btnIngresar = findTestObject('Object Repository/01-Login/btnIngresar')
//msgUsuarioIncorrecto = findTestObject('Object Repository/01-Login/msgUsuarioIncorrecto')
lblCampoRequerido = findTestObject('Object Repository/01-Login/msgCampoRequerido')
lblUsuarioIncorrecto = findTestObject('Object Repository/01-Login/msgUsuarioIncorrecto')
lblMailMalEscrito = findTestObject('Object Repository/01-Login/msgMailMalEscrito')

//-----------------------------------------------------------------------------------------
WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()
 
WebUI.waitForElementPresent(txtMail, 10, FailureHandling.STOP_ON_FAILURE)

//--- VALIDACION DE USUARIO INCORRECTO ----
//Se ingresa Usuario mal escrito
WebUI.setText(txtMail, GlobalVariable.LoginMalMalEscrito)

//Se clickea txtPassword
WebUI.click(txtPassword)

//Se valida el mesaje de error
WebUI.verifyElementVisible(lblMailMalEscrito)

//Se clickea password sin password
WebUI.click(txtPassword)

//Se clickea ingresar
WebUI.click(btnIngresar)

//Se valida el mesaje de error
WebUI.verifyElementVisible(lblCampoRequerido)


//---------------------------------------------------------------------------------------------------------------------
//Fail/Pass control
@com.kms.katalon.core.annotation.TearDownIfFailed
void fTakeFailScreenshot() {
	CustomKeywords.'pkgPawWay.kywUtility.fFailStatus'('Screenshot/Fails/PayWay-LGN03-Error.png')
}

@com.kms.katalon.core.annotation.TearDownIfPassed
void fPassScript() {
	WebUI.closeBrowser()	
}
