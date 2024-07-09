import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestTabsPopups {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

        Page popup =  page.waitForPopup(()->{
            page.locator("text=Privacy Policy").nth(0).click();
        });
        System.out.println(popup.title());
        popup.locator("#header-sign-up-btn").click();
        popup.locator("text=Log in").nth(0).click();
        popup.locator("#email").fill("Akila Mendis");

        popup.close();


        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
