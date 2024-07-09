import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;

public class ChromeEdge {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<String>();
        arguments.add("--start-maximized");
        String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
        String edgePath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments)
                .setExecutablePath(Paths.get(edgePath)));
        BrowserContext browsercontext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browsercontext.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }
}
