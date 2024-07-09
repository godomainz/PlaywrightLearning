import com.microsoft.playwright.*;

public class TestFrames {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https:/www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
        FrameLocator iframe = page.frameLocator("#iframeResult");
        iframe.locator("body > button").click();

        Locator frames = page.locator("iframe");
        System.out.println(frames.count());

        for (int i = 0; i < frames.count(); i++) {
            System.out.println(frames.nth(i).getAttribute("id"));
        }


        Thread.sleep(2000);
        page.close();
        browser.close();
        playwright.close();
    }
}
