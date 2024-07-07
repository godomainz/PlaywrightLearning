import com.microsoft.playwright.*;

import java.awt.*;

public class TestCases {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println(width+"----------"+height);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext =  browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));
        Page page =  browserContext.newPage();
        page.navigate("https://google.com");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }

}
