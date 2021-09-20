package Scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Library.Testbase;

public class Search extends Testbase{

	
	
	
	@Test(priority=1,description="valid value in the search text box")
	public void SearchWithvalidText() throws InterruptedException {
	
		findElementAndSendKeys(searchbtn,"xpath","java");
		Thread.sleep(2000);
		String str=FindElementAndGetText("xpath",Textassert1);
		Assert.assertEquals(str,"James Gosling");
		
		
	}
	
	@Test(priority=2,description="Invalid value in the search text box")
	public void SearchWithInvalidText() throws InterruptedException {
		
	findElementAndSendKeys(searchbtn,"xpath","^%!!!%5436988htra");
	Thread.sleep(2000);
	String str=FindElementAndGetText("xpath",Textassert2);
	
	Assert.assertEquals(str,"Make sure that all words are spelled correctly.");
	
	}
	@Test(priority=3,description="Minus numeric value in the search text box")
	public void SearchWithInvalidnumericvalue() throws InterruptedException {
		
	findElementAndSendKeys(searchbtn,"xpath","-76758");
	Thread.sleep(2000);
	String str=FindElementAndGetText("xpath",Textassert2);
	Assert.assertEquals(str,"Make sure that all words are spelled correctly.");
	
	}
	
}
