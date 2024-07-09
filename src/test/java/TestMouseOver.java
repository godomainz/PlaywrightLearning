import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestMouseOver {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/");
        page.locator("text=All Courses").nth(0).hover();
        page.locator("#menu-item-27580 #menu-item-27592 a").click();

        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
