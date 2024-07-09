import com.microsoft.playwright.*;

public class TestSlider {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");
        Locator slider =  page.locator("#slider span");
        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width/2,slider.boundingBox().y+slider.boundingBox().height/2);
        page.mouse().down();
        page.mouse().move(slider.boundingBox().x + 800,slider.boundingBox().y+slider.boundingBox().height/2);
        page.mouse().up();


        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
