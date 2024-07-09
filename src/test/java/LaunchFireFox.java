import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;

public class LaunchFireFox {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<String>();
        arguments.add("--start-maximized");
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browsercontext.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }
}
