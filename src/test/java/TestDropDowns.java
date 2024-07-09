import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class TestDropDowns {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        //Select by value
        page.selectOption("select", "la");

        //Select by text
        page.selectOption("select", new SelectOption().setLabel("Bahasa Melayu"));

        //Select by index
        page.selectOption("select", new SelectOption().setIndex(1));
    /*
        Locator values = page.locator("select > option");
        System.out.println(values.count());
        for (int i=0;i<values.count();i++){
            System.out.println(values.nth(i).innerHTML()+"-----"+values.nth(i).getAttribute("lang"));
        }
        */
        List<ElementHandle> values = page.querySelectorAll("select > option");
        System.out.println(values.size());
        for (ElementHandle value: values){
            System.out.println(value.innerHTML()+"-----"+value.getAttribute("lang"));
        }

        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
