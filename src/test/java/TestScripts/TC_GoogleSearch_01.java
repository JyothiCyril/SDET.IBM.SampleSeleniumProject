package TestScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtils;

public class TC_GoogleSearch_01 extends TestBase{

	@Test(dataProvider="getData")
	public void searchItem(String input) throws InterruptedException {
		GoogleOR.getSearchTextBox().clear();
		GoogleOR.getSearchTextBox().sendKeys(input);
		Thread.sleep(3000);

		List<WebElement> autoSuggestElements = GoogleOR.getAutoSuggestElements();

		for(WebElement item:autoSuggestElements) {
			Reporter.log(item.getText(),true);
		}

		GoogleOR.getSearchTextBox().submit();
		//GoogleOR.getSearchTextBox().sendKeys(Keys.ENTER);		

		String title = driver.getTitle();
		Assert.assertTrue(title.contains(input));
		Reporter.log(title,true);
	}

	//	@DataProvider
	//	public Object[][] getData(){
	//		
	//		Object[][] data = new Object[3][1];
	//		
	//		data[0][0] = "Automation Testing";
	//		data[1][0] = "Functional Testing";
	//		data[2][0] = "Performance Testing";
	//		
	//		return data;
	//	}

	@DataProvider
	public String [][] getData() throws IOException
	{
		//String path=System.getProperty("user.dir")+"src/test/java/com/qa/selenium/testdata/InputData.xlsx";

		String path = "D:\\Devlabs\\Batch 2\\BroadridgeBatch2\\SDET.IBM.SampleSeleniumProject\\src\\test\\java\\TestData\\InputData.xlsx";

		int rownum=ExcelUtils.getRowCount(path, "Sheet1");
		int colcount=ExcelUtils.getCellCount(path,"Sheet1",1);

		String data[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=ExcelUtils.getCellData(path,"Sheet1", i,j);//1 0
			}

		}
		return data;
	}

}
