package com.massmutual.Cucumber.pages;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.massmutual.Cucumber.utils.CommonUtil;

public class ValuesPage {
	WebDriver driver;

	@FindBy(xpath = "//*[@id='username']")
	WebElement txtUsername;
	@FindBy(xpath = "//*[@id='password']")
	WebElement txtPassword;
	@FindBy(xpath = "//*[@id='SignIn']")
	WebElement buttonSignIn;
	
	@FindBy(xpath = "//*[starts-with(@id,'lbl_val')]")
	List<WebElement> labelValues;

	@FindBy(xpath = "//*[starts-with(@id,'txt_val')]")
	List<WebElement> textValues;

	@FindBy(xpath = "//*[@id='lbl_ttl_val')]")
	List<WebElement> labelTotalBal;

	@FindBy(xpath = "//*[@id='txt_ttl_val')]")
	List<WebElement> textTotalBal;

	public ValuesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterLoginCredentials(String Username,String Password) {
		txtUsername.clear();
		txtUsername.sendKeys(Username);
		txtPassword.clear();
		txtPassword.sendKeys(Password);
		buttonSignIn.click();
	}

	// Tc#1 Need to verify the right count of values appear on the screen

	public void verifyLabelSizetextValues() {
		Assert.assertTrue("Lable size is not 5 ", labelValues.size() == 5);
		Assert.assertTrue("Total Lable size is not 1 ", labelTotalBal.size() == 1);
	}

	public void verifyTextBoxSize() {
		Assert.assertTrue("Text box size is not 5 ", textValues.size() == 5);
		Assert.assertTrue("Total Text box size is not 1 ", textTotalBal.size() == 1);
	}

	public void verifyValuesDisplay() {
		for (int i = 0; i < textValues.size(); i++) {
			boolean Display = textValues.get(i).isDisplayed();
			System.out.println("Element displayed is :" + Display);

			Assert.assertEquals(true, textValues.get(i).isDisplayed());
		}
		if (textValues.size() != 0) {
			// If list size is non-zero, element is present
			System.out.println("Element present");
		} else {
			// Else if size is 0, then element is not present
			System.out.println("Element not present");
		}

	}

	// Tc#2 Need to verify the values on the screen are greater than 0

	public void verifyTextBoxContentGreatThanZero() {
		for (int i = 0; i < textValues.size(); i++) {
			String tempValue = textValues.get(i).getText();
			Assert.assertTrue(i + " th Text box content is < 0 ", CommonUtil.getDouble(tempValue) > 0);
		}

		String tempValue = textTotalBal.get(0).getText();
		Assert.assertTrue("Total Text box content is < 0 ", CommonUtil.getDouble(tempValue) > 0);

	}

	// Tc#3 Need to verify the total balance is correct based on the values listed on the screen

	public void verifyvalueslistedonthescreen() {
		String strActualSum = textTotalBal.get(0).getText();
		double expected = 0d;

		for (int i = 0; i < textValues.size(); i++) {
			String tempValue = textTotalBal.get(0).getText();
			expected = expected + CommonUtil.getDouble(tempValue);
		}
		String expectedValue = CommonUtil.stringToCurrency(expected);
		Assert.assertTrue("Error in Sum Caliculation", expectedValue.contentEquals(strActualSum));
	}

	// TC#4 Need to verify the values are formatted as currencies

	public void verifyTextBoxFormat() {
		String regex = "^\\$(0|[1-9][0-9]{0,2})(,\\d{3})*(\\.\\d{1,2})?$";

		for (int i = 0; i < textValues.size(); i++) {
			String tempValue = textValues.get(i).getText();
			boolean booleanCurrencyValidation = Pattern.matches(regex, tempValue);
			Assert.assertTrue(i + " th Text box content not formated correctly ", booleanCurrencyValidation);
		}

		String tempValue = textTotalBal.get(0).getText();
		boolean booleanCurrencyValidation = Pattern.matches(regex, tempValue);
		Assert.assertTrue("Toatal Text box content not formated correctly ", booleanCurrencyValidation);

	}

	// Tc#5 Need to verify the total balance matches the sum of the values

	public void verifySumOfValues() {
		String strActualSum = textTotalBal.get(0).getText();
		double expetedSum = CommonUtil.getDouble(strActualSum);
		double actualSum = 0f;

		for (int i = 0; i < textValues.size(); i++) {
			String tempValue = textTotalBal.get(0).getText();
			actualSum = actualSum + CommonUtil.getDouble(tempValue);
		}
		Assert.assertTrue("Error in Sum Caliculation", expetedSum == actualSum);
	}

}