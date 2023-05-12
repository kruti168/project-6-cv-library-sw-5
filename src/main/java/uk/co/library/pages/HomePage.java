package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath ="//input[@id='keywords']")
    WebElement enterJobTitle;

    @CacheLookup
    @FindBy(css = "#location")
    WebElement enterLocation;

    @CacheLookup
    @FindBy(css = "#distance")
    WebElement enterDistanceDropDown;

    @CacheLookup
    @FindBy(xpath ="//button[@id='toggle-hp-search']")
    WebElement clickMoreSearchOptionsLink;

    @CacheLookup
    @FindBy(css ="#salarymin")
    WebElement enterSalaryMin;

    @CacheLookup
    @FindBy(css ="#salarymax")
    WebElement enterSalaryMax;

    @CacheLookup
    @FindBy(css ="#salarytype")
    WebElement enterSalaryTypeDropDown;

    @CacheLookup
    @FindBy(css ="#tempperm")
    WebElement enterJobTypeDropDown;

    @CacheLookup
    @FindBy(css ="#hp-search-btn")
    WebElement findJobsBtn;

    @CacheLookup
    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptCookies;

    @CacheLookup
    @FindBy(id ="gdpr-consent-notice")
    WebElement iframe;


    public void jobSearchResult(String jobTitle,String location,String distance,String minSalary,String maxSalary,String sType,String jobType)
    {
        Reporter.log("Job Search Result");
        sendTextToElement(enterJobTitle,jobTitle);
        sendTextToElement(enterLocation,location);
        selectByVisibleTextFromDropDown(enterDistanceDropDown,distance);
        clickOnElement(clickMoreSearchOptionsLink);
        sendTextToElement(enterSalaryMin,maxSalary);
        sendTextToElement(enterSalaryMax,maxSalary);
        selectByVisibleTextFromDropDown(enterSalaryTypeDropDown,sType);
        selectByVisibleTextFromDropDown(enterJobTypeDropDown,jobType);
        clickOnElement(findJobsBtn);
        CustomListeners.test.log(Status.PASS,"Job Search Result");

    }public void acceptCookies(){

        switchToIframe(iframe);
        clickOnElement(acceptCookies);
        driver.switchTo().defaultContent();
    }

}
