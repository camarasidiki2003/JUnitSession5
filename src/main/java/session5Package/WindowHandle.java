package session5Package;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	WebDriver driver;

	@Before
	public void Login() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void windowHandleTest() throws InterruptedException {

		String title1 = driver.getTitle();
		System.out.println(title1);
		 String handle1 = driver.getWindowHandle();
		 System.out.println(handle1);

		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("xpath");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		Thread.sleep(3000);
		// String title2 = driver.getTitle();
		// System.out.println(title2);
		// String handle2 = driver.getWindowHandle();
		// System.out.println(handle2);

		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		for (String str : handles) {
//			System.out.println(str);
			driver.switchTo().window(str);
		}

		String title3 = driver.getTitle();
		System.out.println(title3);
		
		driver.switchTo().window(handle1);
		
		String title4 = driver.getTitle();
		System.out.println(title4);
		

}
}