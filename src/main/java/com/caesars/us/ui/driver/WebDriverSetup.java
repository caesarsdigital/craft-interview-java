package com.caesars.us.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebDriverSetup {

    private static WebDriver driver;
    private static final String PROPERTIES_FILE_PATH = "chrome.properties";

    public static void setupWebDriver() {
        String chromeDriverVersion = getChromeDriverVersionFromProperties();
        if (chromeDriverVersion != null && !chromeDriverVersion.isEmpty()) {
            WebDriverManager.chromedriver().driverVersion(chromeDriverVersion).setup();
        } else {
            String chromeVersion = getChromeVersion();
            if (chromeVersion == null) {
                throw new RuntimeException("Could not determine Chrome version");
            }

            if (isVersion114OrBelow(chromeVersion)) {
                WebDriverManager.chromedriver().setup();
            } else {
                WebDriverManager.chromedriver().browserVersion(chromeVersion).setup();
            }
        }
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static String getChromeVersion() {
        try {
            String[] command;
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("mac")) {
                command = new String[]{"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome", "--version"};
            } else if (os.contains("win")) {
                command = new String[]{"cmd", "/c", "reg query \"HKEY_CURRENT_USER\\Software\\Google\\Chrome\\BLBeacon\" /v version"};
            } else {
                command = new String[]{"google-chrome", "--version"};
            }

            Process process = new ProcessBuilder(command).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String versionLine = reader.readLine();

            if (versionLine != null) {
                if (os.contains("win")) {
                    Pattern pattern = Pattern.compile("version\\s+REG_SZ\\s+(\\d+\\.\\d+\\.\\d+\\.\\d+)");
                    Matcher matcher = pattern.matcher(versionLine);
                    if (matcher.find()) {
                        return matcher.group(1);
                    }
                } else {
                    Pattern pattern = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
                    Matcher matcher = pattern.matcher(versionLine);
                    if (matcher.find()) {
                        return matcher.group();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getChromeDriverVersionFromProperties() {
        Properties properties = new Properties();
        try (InputStream input = WebDriverSetup.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_PATH)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + PROPERTIES_FILE_PATH);
                return null;
            }
            properties.load(input);
            return properties.getProperty("chromeDriverVersion");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean isVersion114OrBelow(String version) {
        String[] parts = version.split("\\.");
        int majorVersion = Integer.parseInt(parts[0]);
        return majorVersion <= 114;
    }
}
