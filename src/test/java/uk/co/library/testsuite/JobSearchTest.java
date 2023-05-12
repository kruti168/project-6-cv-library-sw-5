package uk.co.library.testsuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;

@Listeners(CustomListeners.class)
public class JobSearchTest extends BaseTest {

    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){

        homePage = new HomePage();
        resultPage = new ResultPage();
    }
    @Test(dataProvider = "Find jobs", dataProviderClass = TestData.class,groups = {"sanity","regression"})
    public void verifyJobSearchResultUsingDifferentDataSet(String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String result)throws InterruptedException

    {
        Thread.sleep(5000);
        homePage.acceptCookies();
        homePage.jobSearchResult(jobTitle,location,distance,salaryMin,salaryMax,salaryType,jobType);
        resultPage.verifytheResult(result);
}

}
