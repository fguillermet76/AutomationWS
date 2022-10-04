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
msgUsuarioIncorrecto = findTestObject('Object Repository/01-Login/msgUsuarioIncorrecto')

//-----------------------------------------------------------------------------------------
WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()
 
WebUI.waitForElementPresent(txtMail, 10, FailureHandling.STOP_ON_FAILURE)

//--- VALIDACION DE USUARIO INCORRECTO ----
//Se ingresa Usuario incorrecto
WebUI.setText(txtMail, GlobalVariable.LoginBadUser)

//Se ingresa Pswd
WebUI.setText(txtPassword, GlobalVariable.LoginPswd)
 
//Se accede a PayWay
WebUI.click(btnIngresar)

//Se valida mensaje de credenciales incorrectas
WebUI.verifyElementVisible(msgUsuarioIncorrecto)

//--- VALIDACION DE PASSWORD INCORRECTO ----
WebUI.clearText(txtMail)
WebUI.clearText(txtPassword)

WebUI.setText(txtMail, GlobalVariable.LoginUser)

WebUI.setText(txtPassword, GlobalVariable.LoginBadPswd)

//Se valida mensaje de credenciales incorrectas
WebUI.verifyElementVisible(msgUsuarioIncorrecto)

//---------------------------------------------------------------------------------------------------------------------
//Fail/Pass control
@com.kms.katalon.core.annotation.TearDownIfFailed
void fTakeFailScreenshot() {
	CustomKeywords.'pkgPawWay.kywUtility.fFailStatus'('Screenshot/Fails/PayWay-LGN02-Error.png')
}

@com.kms.katalon.core.annotation.TearDownIfPassed
void fPassScript() {
	WebUI.closeBrowser()	
}
