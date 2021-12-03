package SeleniumAssignment.Mail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;


public class Login2 extends Initializer {

	@BeforeTest()
	public void setdriver() throws IOException {
		driver=setUp();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void SignIn() throws InterruptedException, FileNotFoundException, IOException{

		driver.findElement(By.cssSelector("a[class='btn btn-ghost btn-short']")).click();
		driver.findElement(By.id("username")).sendKeys("asdf2112@protonmail.com");
		driver.findElement(By.id("password")).sendKeys("Asdf@21212");

		driver.findElement(By.cssSelector("button[class='button button-large button-solid-norm w100 mt1-75']")).click();
		Thread.sleep(9000);

		driver.findElement(By.cssSelector("span[class='inline-block max-w100 text-ellipsis']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[class='inline-flex p0-5 no-pointer-events-children flex-item-noshrink border-left message-attachmentSecondaryAction interactive']")).click();
		Thread.sleep(5000);
		XWPFDocument docx= new XWPFDocument(new FileInputStream("C:\\Users\\yashwanth.n\\Downloads\\Sample.docx"));
		
		XWPFWordExtractor wt= new XWPFWordExtractor(docx);
		Thread.sleep(6000);
		System.out.println(wt.getText());

	}


	@AfterTest
	public void closebrowser() {
		//		driver.findElement(By.cssSelector("span[class='mtauto mbauto center']")).click();
		//		driver.findElement(By.cssSelector("button[class='button button-solid-norm w100 flex flex-justify-center flex-align-items-center']")).click();
		//driver.close();
	}
}