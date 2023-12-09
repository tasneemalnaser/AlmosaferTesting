import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class testcases {

	String URL = "https://www.almosafer.com/en";
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void pretesting() {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='Kingdom of Saudi Arabia, SAR']")).click();
	}

	@Test(enabled = false)
	public void checkthelanguges() {
		String Actuallanguages = driver.findElement(By.tagName("html")).getAttribute("lang");
		assertEquals(Actuallanguages, "en");

	}

	@Test(enabled = false)
	public void checkthecurrency() {
		WebElement Expectedcurrency = driver.findElement(By.className("sc-dRFtgE"));
		String Actualcurrency = Expectedcurrency.getText();
		assertEquals(Actualcurrency, "SAR");
		System.out.println(Actualcurrency);
	}

	@Test(enabled = false)
	public void contactnumberCheck() {
		WebElement MobileNumberOnTheWebSite = driver.findElement(By.cssSelector("a[class='sc-hUfwpO bWcsTG'] strong"));

		String Actualnumber = MobileNumberOnTheWebSite.getText();

		String Expectednumber = "+966554400000";

		assertEquals(Actualnumber, Expectednumber);
	}

	@Test(enabled = false)
	public void Qaitcheck() {
		WebElement Footer = driver.findElement(By.tagName("footer"));
		boolean isQait = Footer.findElement(By.xpath("//div[@class='sc-dznXNo iZejAw']//*[name()='svg']"))
				.isDisplayed();
		assertEquals(isQait, true);
	}

	@Test(enabled = false)
	public void hotelscheck() {
		WebElement hotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualTab = hotelTab.getAttribute("aria-selected");
		assertEquals(ActualTab, "false");

	}

	@Test(invocationCount = 10, enabled = false)
	public void checklanguage() {
		String[] myWebsite = { "https://www.almosafer.com/ar", "https://www.almosafer.com/en" };
		Random rand = new Random();
		int randomNumber = rand.nextInt(myWebsite.length);
		driver.get(myWebsite[randomNumber]);

		String myWebsiteURL = driver.getCurrentUrl();

		if (myWebsiteURL.contains("ar")) {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualLanguage, "ar", "this website in arabic");
		} else if (myWebsiteURL.contains("en")) {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			assertEquals(ActualLanguage, "en", "this is website in english");
		}

	}

	@Test(enabled = false)
	public void checkDate() {
		LocalDate today = LocalDate.now();
		//Actual
		String ActualNameMonth=driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-hvvHee cuAEQj']")).getText();
        int ActualNumberDay=Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText());
        String ActualDayName=driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-eSePXt ljMnJa']")).getText();
        
        //Actual return
        String ActualreturnMonth=driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-hvvHee cuAEQj']")).getText();
        int ActualreturnDay=Integer.parseInt(driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText());
        String ActualreturnName=driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-eSePXt ljMnJa']")).getText();
        
        //expected
        
        String ExpectedNameMonth=today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int ExpectedNumberDay=today.plusDays(1).getDayOfMonth();
        String ExpectedNameDay=today.plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        assertEquals(ActualNameMonth, ExpectedNameMonth);
        System.out.print(ActualNameMonth);
        assertEquals(ActualNumberDay,ExpectedNumberDay);
        assertEquals(ActualDayName,ExpectedNameDay);
        
        //expected return
        
        
        
        String ExpectedreturnMonth=today.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int ExpectedreturnDay=today.plusDays(1).getDayOfMonth();
        String ExpectedreturnNameDay=today.plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        assertEquals(ActualreturnMonth,ExpectedreturnMonth);
        assertEquals(ActualreturnDay,ExpectedreturnDay);
        assertEquals(ActualreturnName,ExpectedreturnNameDay);
/*
		 * int expectedDepatureDate=today.plusDays(1).getDayOfMonth();
		 * 
		 * //int expectedReturnDate=today.plusDays(2).getDayOfMonth();
		 * 
		 * WebElement ActualDepatureDateOnTheWebSite=driver.findElement(By.
		 * cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']"
		 * ));
		 * 
		 * 
		 * WebElement ActualexpectedReturnDate=driver.findElement(By.
		 * cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']"
		 * ));
		 * 
		 * assertEquals(Integer.parseInt(ActualDepatureDateOnTheWebSite.getText()),
		 * 6,"this is depature date");
		 * 
		 * assertEquals(Integer.parseInt(ActualexpectedReturnDate.getText()),7);
		 */
		

	}

	@Test()
	public void checkhoteltab() throws InterruptedException {
		Random rand = new Random();
		String[] arabcities = { "دبي", "جدة" };
		String[] englishcities = { "dubai", "jeddah", "riyadh", "amman", "muscat" };
		int Randomarabic = rand.nextInt(arabcities.length);
		int Randomenglish = rand.nextInt(englishcities.length);

		String[] myWebSites = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };

		int randomNumber = rand.nextInt(myWebSites.length);

		driver.get(myWebSites[randomNumber]);

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();

		if (driver.getCurrentUrl().contains("ar")) {
			WebElement SearchArabic = driver.findElement(By.xpath("//input[@placeholder='البحث عن فنادق أو وجهات']"));
			SearchArabic.sendKeys((arabcities[Randomarabic]) + Keys.ENTER);
			driver.findElement(By.xpath(
					"//button[@class='sc-jTzLTM eJkYKb sc-1vkdpp9-6 iKBWgG js-HotelSearchBox__SearchButton btn btn-primary btn-block']"))
					.click();
			Thread.sleep(10000);
			WebElement myselectElement = driver
					.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
			Select selector = new Select(myselectElement);
			selector.selectByIndex(rand.nextInt(2));
			Thread.sleep(5000);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(text(),'الأقل سعراً')]")).click();
			String resultsFound = driver
					.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")).getText();
		assertEquals(resultsFound.contains("وجدنا"), true);
		}

		else if (driver.getCurrentUrl().contains("en")) {
			WebElement SearchEnglish = driver
					.findElement(By.xpath("//input[@placeholder='Search for hotels or places']"));
			SearchEnglish.sendKeys(englishcities[Randomenglish] + Keys.ENTER);
			driver.findElement(By.xpath(
					"//button[@class='sc-jTzLTM hQpNle sc-1vkdpp9-6 iKBWgG js-HotelSearchBox__SearchButton btn btn-primary btn-block']"))
					.click();
			Thread.sleep(10000);
			WebElement myselectElement = driver
					.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
			Select selector = new Select(myselectElement);
			selector.selectByIndex(rand.nextInt(2));
			Thread.sleep(5000);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[normalize-space()='Lowest price']")).click();
			String testResult = driver
					.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")).getText();
			assertEquals(testResult.contains("found"), true);

		}
	}

	@AfterTest
	public void posttesting() {

	}
}
