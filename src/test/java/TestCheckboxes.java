import com.microsoft.playwright.*;

public class TestCheckboxes {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");

        Locator block = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");

        Locator checkboxes = block.locator("[type='checkbox']");
        System.out.println(checkboxes.count());

        for (int i = 0; i < checkboxes.count(); i++) {
            checkboxes.nth(i).click();
        }

        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
