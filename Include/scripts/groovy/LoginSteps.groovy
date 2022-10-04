import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class LoginSteps {

	@Given("El usuario accede a Login page")
	def navigateToLoginPage() {
		println ("\n Esto es navigateToLoginPage")
		WebUI.openBrowser(findTestData('00-Sistema/PWY-Sistema').getValue(2,1))
		WebUI.maximizeWindow()
		WebUI.waitForElementPresent(findTestObject('Object Repository/01-Login/txtMail'), 10, FailureHandling.STOP_ON_FAILURE)
	}

	@When("El usuario ingresa User and Pswd")
	def enterUserAndPswd(String username, String password) {
		println ("\n Esto es enterUserAndPswd")
		//Se ingresa Usuario
		WebUI.click(findTestObject('Object Repository/01-Login/txtMail'))
		WebUI.setText(findTestObject('Object Repository/01-Login/txtMail'), findTestData('01-Login/LGNData-Usuarios').getValue(1,1))
		//Se ingresa Pswd
		WebUI.setText(findTestObject('Object Repository/01-Login/txtPassword'), findTestData('01-Login/LGNData-Usuarios').getValue(2,1))
	}

	@And("Click en boton login")
	def clickBtnLogin() {
		println ("\n Esto es clickBtnLogin")
		//Se accede a PayWay
		WebUI.click(findTestObject('Object Repository/01-Login/btnIngresar'))
	}

	@Then("El usuario accede al dashboard")
	def verifyDashboardPage() {
		println ("\n Esto es el Dashboard")
		//Se valida el acceso al sitio
		WebUI.verifyElementPresent(findTestObject('Object Repository/02-Dashboard/btnCerrarSesion'),10)
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