package main;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MainBot {

	public static void main(String[] args) {

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
			Page page = browser.newPage();
			page.navigate("https://recarga.nequi.com.co/bdigitalpsl/#!/");
			page.locator("id=Inputphone").fill("3102618792");
			page.locator("id=InputphoneValid").fill("3102618792");
			page.locator("id=Inputammount").fill("20000");
			page.selectOption("#form1 > fieldset > div:nth-child(6) > select:nth-child(2)", "1");
			page.selectOption("#form1 > fieldset > div:nth-child(8) > select", "1007");
			page.waitForTimeout(1000);

			page.click(
					"#form1 > fieldset > div.captcha-wp.ng-pristine.ng-untouched.ng-valid.ng-scope.ng-isolate-scope.ng-empty");
			page.waitForTimeout(2000);

			page.click("#form1 > button");

			if (page.waitForSelector("#form2 > fieldset > button") != null) {
				page.click("#form2 > fieldset > button");
			}

			page.waitForTimeout(10000);

		}

	}

}