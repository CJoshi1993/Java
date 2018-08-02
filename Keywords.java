package testscript;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Keywords {
	static FirefoxDriver driver;
	static FileInputStream file;
	static Properties prop;
	
	
	public void openbrowser() throws Exception{
	   	System.setProperty("webdriver.gecko.driver", "D://geckodriver.exe");
		 driver=new FirefoxDriver();
		// driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 file=new FileInputStream("C:\\Users\\Joshi\\workspace\\CRMFramework\\objectrepository.properties");
		 prop=new Properties();
		 prop.load(file);
	}
	
	
	public void navigate(String testdata){
		driver.get(testdata);
	}
	
	
	public void input(String testdata,String objectName){
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(testdata);
	}
	
	public void click(String objectName){
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
	}
	public String verifyTitle(){
		String av=driver.getTitle();
		return av;
	}
	public String verifyPageText(String objectName){
		String av=driver.findElement(By.xpath(prop.getProperty(objectName))).getText();
		return av;
	}
	public String verifyEditBox(String objectName){
		String av=driver.findElement(By.xpath(prop.getProperty(objectName))).getAttribute("value");
		return av;
	}

}
