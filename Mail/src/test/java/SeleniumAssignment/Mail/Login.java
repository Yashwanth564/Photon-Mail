package SeleniumAssignment.Mail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends Initializer {

	@BeforeTest()
	public void setdriver() throws IOException {
		driver=setUp();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void SignIn() throws InterruptedException, AWTException{

		driver.findElement(By.cssSelector("a[class='btn btn-ghost btn-short']")).click();
		driver.findElement(By.id("username")).sendKeys("abco09876@protonmail.com");
		driver.findElement(By.id("password")).sendKeys("Asdf@09876");
		
		driver.findElement(By.cssSelector("button[class='button button-large button-solid-norm w100 mt1-75']")).click();
		driver.findElement(By.cssSelector("button[class='button button-large button-solid-norm text-bold mt0-25 w100 no-mobile']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Email address']")).sendKeys("asdf2112@protonmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Subject']")).sendKeys("Word Document");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='w100 h100 squireIframe']")));
		driver.findElement(By.id("squire")).sendKeys("Document has been Uploaded below");;
		
		driver.switchTo().defaultContent();
		//driver.findElement(By.cssSelector("svg[class='icon-16p']")).click();
		driver.findElement(By.cssSelector("label[class='button button-for-icon button-outline-weak inline-block text-center inline-flex']"));
		fileupload();
		System.out.println("File is Uploaded Successfully");
		
		driver.findElement(By.cssSelector("span[class='pl1 pr1 no-mobile']")).click();
	}

	public WebElement fileupload() throws InterruptedException, AWTException {

		WebElement file = driver.findElement(By.cssSelector("label[class='button button-for-icon button-outline-weak inline-block text-center inline-flex']"));
		
		file.click(); 
		Thread.sleep(2000); 
		Robot rb = new Robot();

		StringSelection str = new StringSelection("C:\\Users\\yashwanth.n\\Desktop\\Sample.doc");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);	   
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		return file;

	}

	
	
	@AfterTest
	public void closebrowser() {
	driver.findElement(By.cssSelector("span[class='mtauto mbauto center']")).click();
		driver.findElement(By.cssSelector("button[class='button button-solid-norm w100 flex flex-justify-center flex-align-items-center']")).click();
	driver.close();
	}
}


//sendKeys("C:\\Users\\yashwanth.n\\eclipse-workspace\\Mail\\src\\main\\java\\SeleniumAssignment\\Mail\\Sample.doc");
//abco09876@protonmail.com
//Asdf@09876
