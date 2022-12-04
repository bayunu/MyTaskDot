package android
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import java.util.Random

class MyTask {

	Random r = new Random()

	def title = ["",
		"Pagi",
		"Siang",
		"Sore",
		"Malam"
	]

	def content = ["",
		"Bekerja",
		"Istirahat",
		"Bermain",
		"Berdoa"
	]

	@Keyword
	def openMyTask() {

		//Mobile.startApplication('com.yoesuv.androidroom',false)
		Mobile.startExistingApplication('com.yoesuv.androidroom')
	}

	def addMyTask() {
		try {
			Mobile.tap(findTestObject('Object Repository/My Task/android.widget.ImageButton - Tambah'), 5)
			
			Mobile.setText(findTestObject('Object Repository/My Task/android.widget.EditText - Task Title'),title[r.nextInt(title.size())], 5)
			
			Mobile.setText(findTestObject('Object Repository/My Task/android.widget.EditText - Task Content'),content[r.nextInt(content.size())], 5)
			
			Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - SAVE'), 5)
					
			if(Mobile.verifyElementExist(findTestObject('Object Repository/My Task/android.widget.TextView - Title is Empty'), 1, FailureHandling.OPTIONAL) || Mobile.verifyElementExist(findTestObject('Object Repository/My Task/android.widget.TextView - Content is Empty'), 1, FailureHandling.OPTIONAL) ) {
						
				Mobile.comment('Ada Yang Kosong')
				
				Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - CANCEL SAVE'), 5)
					
				} else {
					
						Mobile.comment('Aman')
					}
		} catch (Exception e) {
			
			Mobile.comment('Kena Try Catch')
			
			Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - CANCEL SAVE'), 5)
		}
		
	}

	def deleteAllMyTask() {

		Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - Delete All'), 5)

		Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - OK DELETE ALL'), 5)
	}

	def editMytask() {
		
		try {
			Mobile.tap(findTestObject('Object Repository/My Task/android.widget.ImageView - Elipsis'), 5)
			
			Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - EDIT'), 5)
		
			Mobile.setText(findTestObject('Object Repository/My Task/android.widget.EditText - Edit Title'),title[r.nextInt(title.size())], 3)
		
			Mobile.setText(findTestObject('Object Repository/My Task/android.widget.EditText - Edit Content'),content[r.nextInt(content.size())], 3)
			
			Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - UPDATE'), 5)
					
			if(Mobile.verifyElementExist(findTestObject('Object Repository/My Task/android.widget.TextView - Title is Empty'), 1, FailureHandling.OPTIONAL) || Mobile.verifyElementExist(findTestObject('Object Repository/My Task/android.widget.TextView - Content is Empty'), 1, FailureHandling.OPTIONAL) ) {
						
				Mobile.comment('Ada Yang Kosong')
						
				Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - CANCEL SAVE'), 5)
					
				} else {
						
						Mobile.comment('Aman')
					}
		} catch (Exception e) {
			
			Mobile.comment('Kena Try Catch')
			
			Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - CANCEL SAVE'), 5)
		}

		
	}

	def deleteMyTask() {

		Mobile.tap(findTestObject('Object Repository/My Task/android.widget.ImageView - Elipsis'), 5)

		Mobile.tap(findTestObject('Object Repository/My Task/android.widget.Button - DELETE'), 5)
	}
}