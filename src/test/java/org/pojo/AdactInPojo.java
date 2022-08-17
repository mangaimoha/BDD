package org.pojo;

import org.lib.global.LibGlobalClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactInPojo extends LibGlobalClass {
	
	public AdactInPojo() {
		PageFactory.initElements(driver, this);
		System.out.println("mm added");
	}
	
	@FindBy(id="username")
	private WebElement uName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement loginBtn;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy(id="emailadd_recovery")
	private WebElement email;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	private WebElement forgotPass;

	public WebElement getuName() {
		return uName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getForgotPass() {
		return forgotPass;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getEmail() {
		return email;
	}
	
	

}
