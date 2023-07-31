package Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class flipcart_ex {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions CO=new ChromeOptions();
		CO.addArguments("--remote-allow-origins=*");
		WebDriver d=new ChromeDriver(CO);
		d.get("https://www.flipkart.com/");
		d.manage().window().maximize();
//		d.manage().timeouts().implicitlyWait(20, TimeUnit sec);
		WebElement close = d.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		close.click();
		WebElement search = d.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("mobiles"+Keys.ENTER);
		Thread.sleep(5000);
		
		String firstWindow = d.getWindowHandle();
		
		WebElement select_mob = d.findElement(By.xpath("//*[text()='SAMSUNG Galaxy F13 (Waterfall Blue, 64 GB)']"));
		select_mob.click();
		Thread.sleep(3000);
		
		
		
		Set<String> handles = d.getWindowHandles();
		
		
		for (String handles1 : handles) {
			
			d.switchTo().window(handles1);
			
		}
		
		
//		int size = handles.size();
//		System.out.println("Size" + size);
//	    List li = new ArrayList(size);
//		d.switchTo().window((String) li.get(0));
		WebElement add_to_cart = d.findElement(By.xpath("//button[text()='Add to cart']"));
		add_to_cart.click();
		
	}

}
