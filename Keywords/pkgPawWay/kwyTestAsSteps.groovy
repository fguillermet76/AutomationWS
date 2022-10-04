package pkgPawWay

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class kwyTestAsSteps {

	/*----------------------------------------------------------------------------------------------*
	 *DEFAULT LOGIN																			*
	 *																								*
	 *vImgPath: Ubicacion de la imagen capturada con el error.										*
	 *----------------------------------------------------------------------------------------------*/
	@Keyword
	def fDefaultLogin(){
		WebUI.openBrowser(findTestData('00-Sistema/PWY-Sistema').getValue(2,1))
		WebUI.maximizeWindow()
		WebUI.waitForElementPresent(findTestObject('Object Repository/01-Login/txtMail'), 10, FailureHandling.STOP_ON_FAILURE)		
		//Se ingresa Usuario
		WebUI.click(findTestObject('Object Repository/01-Login/txtMail'))
		WebUI.setText(findTestObject('Object Repository/01-Login/txtMail'), findTestData('01-Login/LGNData-Usuarios').getValue(1,1))		
		//Se ingresa Pswd
		WebUI.setText(findTestObject('Object Repository/01-Login/txtPassword'), findTestData('01-Login/LGNData-Usuarios').getValue(2,1))		
		//Se accede a PayWay
		WebUI.click(findTestObject('Object Repository/01-Login/btnIngresar'))		
		//Se procesa la Intro
		WebUI.click(findTestObject('Object Repository/01-Login/01-1-Tutorial/btnIniciarTutorial'))
		
		for (int i = 0; i<=4; i++) {
			if (WebUI.verifyElementPresent(findTestObject('Object Repository/01-Login/01-1-Tutorial/btnSiguiente'), 1, FailureHandling.CONTINUE_ON_FAILURE)){
				WebUI.click(findTestObject('Object Repository/01-Login/01-1-Tutorial/btnSiguiente'))
			}
		}
		
		WebUI.click(findTestObject('Object Repository/01-Login/01-1-Tutorial/btnComenzar'))

	}
}
