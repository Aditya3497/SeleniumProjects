package TestSuite;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.Base;
import Pages.ChennaiUsedCars;
import Pages.HondaDetails;
import Pages.LoginPage;

public class AllTest extends Base{
	HondaDetails hd= new HondaDetails(); 
	ChennaiUsedCars cu = new ChennaiUsedCars();
	LoginPage l= new LoginPage();
	@Test
	public void test() throws InterruptedException, IOException {
		hd.openUrl();
		hd.closeLoginPopUp();
		hd.clickUpcomingBikes();
		hd.selectManufacturer();
		hd.viewMore();
		hd.printDetails();
		cu.openUrl();
		cu.clickUsedCars();
		cu.clickPopularModels();
		l.openUrl();
		l.clickLogin();
		l.clickGoogleSignIn();
		l.captureErrorMessage();
		hd.closeBrowser();
	}
}
