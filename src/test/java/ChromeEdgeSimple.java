import com.microsoft.playwright.*;

import java.util.ArrayList;

public class ChromeEdgeSimple {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<String>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setArgs(arguments));
        BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browsercontext.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }
}
