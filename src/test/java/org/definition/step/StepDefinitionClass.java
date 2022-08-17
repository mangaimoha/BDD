package org.definition.step;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.lib.global.LibGlobalClass;
import org.pojo.AdactInPojo;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionClass extends LibGlobalClass{
	@Given("^User enters Adactin Page$")
	public void user_enters_Adactin_Page() {
	
	}

	@Given("^Maximize the window$")
	public void maximize_the_window()  {
		
	}

	//one dimensional Map
	@When("^User to provide valid username and valid password$")
	public void user_to_provide_valid_username_and_valid_password(DataTable d) throws InterruptedException  {
		AdactInPojo hotel = new AdactInPojo();
		Map<String, String> map=d.asMap(String.class, String.class);
		toFillTextBox(hotel.getuName(),map.get("username3"));
		toFillTextBox(hotel.getPassword(),map.get("password1"));
		hotel.getLoginBtn().click();
		Thread.sleep(3000);
	}
	
	//two dimensional map
	@When("^User to provide invalid username and invalid password$")
	public void user_to_provide_invalid_username_and_invalid_password(DataTable d) throws InterruptedException  {
		AdactInPojo hotel = new AdactInPojo();
		List<Map<String, String>> maps = d.asMaps(String.class, String.class);
		toFillTextBox(hotel.getuName(),maps.get(2).get("username"));
		toFillTextBox(hotel.getPassword(),maps.get(1).get("phonenumber"));
		hotel.getLoginBtn().click();
		Thread.sleep(3000);	  
	}
	@When("^User to provide valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void user_to_provide_valid_and_valid(String arg1, String arg2) throws InterruptedException  {
		AdactInPojo hotel = new AdactInPojo();
		toFillTextBox(hotel.getuName(),arg1);
		toFillTextBox(hotel.getPassword(),arg2);
		String uname = hotel.getuName().getAttribute("value");
		String pass= hotel.getPassword().getAttribute("value");
		System.out.print("Username "+uname+" and Password "+pass);
		hotel.getLoginBtn().click();
		Thread.sleep(3000);   
	}

	@When("^Print Current Date$")
	public static void print_Current_Date() {
		Date date = new Date();
		System.out.println(date);
	}

	@Then("^User to validate the output$")
	public void user_to_validate_the_output()  {
		String url=toFetchCurrentUrl();
		if(url.equals("https://adactinhotelapp.com/")) {
			System.out.println(" is Invalid");
			System.out.println("Validation Not Successfull");
		}
		else {
			System.out.println(" is Valid");
			System.out.println("Validation successfull");
		}
	}
	
	@When("^User go to forgot password page and enter valid email ID$")
	public void user_go_to_forgot_password_page_and_enter_valid_email_ID(DataTable d)  {
		AdactInPojo hotel = new AdactInPojo();
		List<String> l = d.asList(String.class);
		hotel.getForgotPass().click();
		toFillTextBox(hotel.getEmail(),l.get(1));
		hotel.getSubmitBtn().click();
		
	}

	@When("^User go to forgot password page and enter Invalid email ID$")
	public void user_go_to_forgot_password_page_and_enter_Invalid_email_ID(String email){
		AdactInPojo hotel = new AdactInPojo();
		//List<List<String>> l = d.asLists(String.class);
		hotel.getForgotPass().click();
		toFillTextBox(hotel.getEmail(),email);
		hotel.getSubmitBtn().click();	}
	
	@When("^User go to forgot password page and enter Invalid \"([^\"]*)\" ID$")
	public void user_go_to_forgot_password_page_and_enter_Invalid_ID(String email) {
		AdactInPojo hotel = new AdactInPojo();
		hotel.getForgotPass().click();
		toFillTextBox(hotel.getEmail(),email);
		hotel.getSubmitBtn().click();
	}


	@Then("^Close the browser$")
	public void close_the_browser() {
		closeBrowser();
		}
}