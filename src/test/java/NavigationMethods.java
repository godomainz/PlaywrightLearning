import com.microsoft.playwright.*;
import com.microsoft.playwright.Page.GoBackOptions;
import com.microsoft.playwright.Page.GoForwardOptions;

import java.util.ArrayList;

public class NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<String>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browsercontext.newPage();
        page.navigate("https://way2automation.com");
        System.out.println(page.title());

        page.navigate("https://google.com");
        page.goBack(new GoBackOptions().setTimeout(5000));
        Thread.sleep(2000);
        page.goForward(new GoForwardOptions().setTimeout(5000));
        Thread.sleep(2000);
        page.reload();


        page.close();
        playwright.close();
    }
}
