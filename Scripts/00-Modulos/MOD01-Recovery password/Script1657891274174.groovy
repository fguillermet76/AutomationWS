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

txtMail = findTestObject('Object Repository/03-YopMail/txtMail')
btnLogin = findTestObject('Object Repository/03-YopMail/btnLogin')
txtMailSubject = findTestObject('Object Repository/03-YopMail/03-1-YopMail-MailList/txtMailSubject')
txtMailMessage = findTestObject('Object Repository/03-YopMail/03-2-YopMail-MailMessage/txtMailMessage')

//-----------------------------------------------------------------------------------------
WebUI.openBrowser(GlobalVariable.URLYopMail)

WebUI.maximizeWindow()

//Se accede a la cuenta de mail
WebUI.setText(txtMail, GlobalVariable.LoginUser)

WebUI.click(btnLogin)

//Se selecciona el mensaje y se captra la URL de recovery
WebUI.click(findTestObject('Object Repository/03-YopMail/03-1-YopMail-MailList/txtMailSubject'))

def MsgAnalyze = WebUI.getText(txtMailMessage)


//---------------------------------------------------------------------------------------------------------------------
//Control de Fallos
@com.kms.katalon.core.annotation.TearDownIfFailed
void fTakeFailScreenshot() {
	CustomKeywords.'pkgPawWay.kywUtility.fFailStatus'('Screenshot/Fails/PayWay-LGN01-Error.png')
}

@com.kms.katalon.core.annotation.TearDownIfPassed
void fPassScript() {
	CustomKeywords.'pkgPawWay.kywUtility.fPassStatus'()
}
