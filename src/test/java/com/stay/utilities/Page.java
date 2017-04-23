package com.stay.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void switchWindows(int index) {
		List<String> window = new ArrayList<>(Driver.getInstance().getWindowHandles());
		Driver.getInstance().switchTo().window(window.get(index));
	}

	public static void waitForElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForClickElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static String generate(int length) {
		String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		int n = alphabet.length();
		String result = new String();
		Random r = new Random();
		for (int i = 0; i < length; i++) // 12
			result = result + alphabet.charAt(r.nextInt(n)); // 13

		return result;
	}

	public static String getMonth() {
		Date date = new Date();
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"November", "December" };
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		return months[Integer.parseInt(dateFormat.format(date)) - 1];

	}

	public static void waitForPageToClose() {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.se-pre-con")));
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static Character firstNonRepeatedCharacter(String str) {
		HashMap<Character, Integer> arr = new HashMap<Character, Integer>();
		int i, length;
		Character c;
		length = str.length(); 
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			if (arr.containsKey(c)) {
				arr.put(c, arr.get(c) + 1);
			} else {
				arr.put(c, 1);
			}
		}
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			if (arr.get(c) == 1)
				return c;
		}
		return null;
	}
}
