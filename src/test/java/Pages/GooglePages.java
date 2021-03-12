package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePages {
	
	
	//Browser --> WebPage --> WebElement
	
	WebDriver driver;
	// instantiate the elements on the browser which has page that is loaded when this constructor is called to other test script
	public GooglePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="q")
	WebElement SearchTextBox;
	
	public WebElement getSearchTextBox() {
		return SearchTextBox;
	}
	
	@FindAll(@FindBy(className="sbtc"))
	List<WebElement> AutoSuggestElements;
	
	public List<WebElement> getAutoSuggestElements(){
		return AutoSuggestElements;
	}

}
