import com.microsoft.playwright.*;

import java.nio.file.Paths;
import java.util.ArrayList;

public class NonIncognitoWindowTest {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<String>();
        arguments.add("--start-maximized");
        String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
        BrowserContext browsercontext = playwright.chromium().launchPersistentContext(Paths.get("C:\\Users\\Akila\\AppData\\Local\\Google\\Chrome\\User Data\\Default"),
                new BrowserType.LaunchPersistentContextOptions().setHeadless(false)
                        .setExecutablePath(Paths.get(chromePath)));
        Page page = browsercontext.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
//        page.close();
//        playwright.close();
    }
}
