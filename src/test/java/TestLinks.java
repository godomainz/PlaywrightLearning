import com.microsoft.playwright.*;

public class TestLinks {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        Locator otherProjects = page.locator(".other-projects");

        Locator links = otherProjects.locator("a");
        System.out.println(links.count());
        for (int i=0; i< links.count();i++){
            System.out.println(links.nth(i).innerText()+"-----------"+links.nth(i).getAttribute("href"));
        }

        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
