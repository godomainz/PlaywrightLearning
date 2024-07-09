import com.microsoft.playwright.*;

public class TestLocators {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://gmail.com");
        page.locator("#identifierId").fill("trainer@way2automation.com");
//        page.type("#identifierId","trainer@way2automation.com",  new Page.TypeOptions().setDelay(100));
//        page.click("text=Next");
        page.click("button:has-text('Next')");

        page.locator("[type=password]").fill("asdasda");
        page.click("button:has-text('Next')");

        String txt = page.locator("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span").innerHTML();
        System.out.println(txt);
        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
