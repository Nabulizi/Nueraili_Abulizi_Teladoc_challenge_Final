package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.UserPage;

public class UserManagement_Steps {

		public WebDriver driver;	

	@Given("user is on User_Page {string}")
	public void user_is_on_user_page(String url) throws Exception {
		System.setProperty("webdriver.chrome.driver", "//Users/nurali/Project/Nueraili_Abulizi_Teladoc_challenge-master/Driver//chromedriver");
	    driver=new ChromeDriver();
	    driver.get(url);
	    Thread.sleep(1500);
	}
	 
	@When("user click add_user link")
	public void user_click_add_user_link() throws Exception {
		UserPage.clickAddUser(driver);
		Thread.sleep(1500);
	}

	@Then("user should see add_user modal")
	public void user_should_see_add_user_modal() {
	    WebDriverWait wait=new WebDriverWait(driver,5);
	    WebElement addUserModal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Close')]")));
	    String actual=addUserModal.getText();
	    Assert.assertEquals("Close",actual );
	}

	@When("user enters \"(.*?)\" in firstname field$")
	public void user_enters_first_name_in_firstname_field(String firstName) throws Exception {
		driver.findElement(By.name("FirstName")).sendKeys(firstName);
		Thread.sleep(1500);
	}

	@And("user enters \"(.*?)\" in username field$")
	public void user_enters_user_name_in_username_field(String userName) throws Exception {
		driver.findElement(By.name("UserName")).sendKeys(userName);
		Thread.sleep(1500);
	}

	@And("user enters \"(.*?)\" in password field$")
	public void user_enters_pass_word_in_password_field(String passWord) throws Exception {
		driver.findElement(By.name("Password")).sendKeys(passWord);
		Thread.sleep(1500);
	}
	
	@And("user selects \"(.*?)\" role$")
	public void user_selects_role(String userRole) throws Exception {
		Select role= new Select(driver.findElement(By.name("RoleId")));
		role.selectByVisibleText(userRole);
		Thread.sleep(1500);
	}

	@And("user enters \"(.*?)\" in cellphone field$")
	public void user_enters_cell_phone_in_cellphone_field(String cellPhone) throws Exception {
		driver.findElement(By.name("Mobilephone")).sendKeys(cellPhone);
		Thread.sleep(1500);
	}
	
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		UserPage.clickSaveButton(driver);
	}

	@Then("user \"(.*?)\" is added$")
	public void a_user_is_added(String fn) throws Exception {
		UserPage.verifyUser(driver,fn);
		Thread.sleep(5000);
	}
	
	@When("user click delete mark for username {string} from webtable")
	public void user_click_delete_mark_for_username_from_webtable(String userName) throws Exception {
		Thread.sleep(4500);
		UserPage.clickDelete(driver, userName);	
	}

	@Then("user should be able to see confirmation Dialog")
	public void user_should_be_able_to_see_confirmation_dialog() throws Exception {
		UserPage.verifyConfirmationDialog(driver);
		Thread.sleep(2000);
	}

	@When("user click ok button")
	public void user_click_ok_button() throws Exception {
		UserPage.clickOkButton(driver);
		Thread.sleep(4000);
	}

	@Then("user {string} should be deleted from webtable")
	public void user_should_be_deteted_from_webtable(String string) {

	}

}
