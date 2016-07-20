package testcase;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.TouchAction;

public class demo1 {

	String service_url;
	private AppiumDriver<WebElement> driver;

	@Before

	public void setUp() throws Exception {

		// AppiumDriverLocalService service =
		// AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		// .usingDriverExecutable(new
		// File("/Applications/Appium.app/Contents/Resources/node/bin/node"))
		// .withAppiumJS(new
		// File("/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js"))
		// .usingAnyFreePort());
		// service.start();
		// service_url = service.getUrl().toString();
		// 设置apk的路径
		// File classpathRoot = new File(System.getProperty("user.dir"));
		// File appDir = new File(classpathRoot, "apps");
		// File app = new File(appDir, "ContactManager.apk");

		// 设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("deviceName", "iPhone 6s");
		capabilities.setCapability("platformVersion", "9.3");
	    //capabilities.setCapability("udid", "09d0051562ad9a0398fcbd94de68a719a8153689");

		// 设置app的主包名和主类名
		capabilities.setCapability("bundleId", "com.opentrans.kaka");
		// capabilities.setCapability("appActivity", ".ui.WelcomeActivity");
		// capabilities.setCapability("appWaitActivity", ".ui.MainActivity");

		// 初始化
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

	@Test
	public void swipe() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction Action = new TouchAction(driver);
        Action.press(width / 2, height * 2 / 5).waitAction(500).moveTo(width / 2, height * 4 / 5).release().perform();
//        Action.press(width / 2, height * 2 / 5).waitAction(500).moveTo(width / 2, height * 4 / 5).release().perform();
//        Thread.sleep(1000);
        driver.swipe(width / 2, height * 2 / 5, width * 2 / 2, height * 5 / 5, 500);
//        Thread.sleep(1000);
//        driver.swipe(width / 2, height * 2 / 5, width * 2 / 2, height * 5 / 5, 500);
		// driver.findElement(By.name("已收货")).click();
		// driver.findElement(By.name("CP01002168")).click();
		// driver.findElement(By.name("货物")).click();
		// driver.findElement(By.id("com.opentrans.hub:id/iv_add")).click();
		// driver.swipe(400, 1500, 400, 1450, 500);
		// driver.swipe(800, 1500, 800, 1450, 500);
		// //driver.swipe(400, 1500, 400, 1450, 500);
		// driver.findElement(By.name("确认")).click();
		// driver.findElement(By.id("com.opentrans.hub:id/edt_comment")).sendKeys("123");
		// driver.findElement(By.name("报告异常")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}