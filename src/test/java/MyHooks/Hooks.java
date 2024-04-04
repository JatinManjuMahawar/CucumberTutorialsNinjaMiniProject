package MyHooks;

import io.cucumber.java.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Hooks {
    static WebDriver driver = null;

    @Before
    public static void initializeBrowser() throws Exception {
        driver = Base.Base.initializeBrowser("chrome");
    }

    @After(order = 0)
    public void tearDown() {
        driver.quit();
    }

    @After(order = 1)
    public void takeScreenshotIfFailed(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName().replace(" ", "");
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenarioName);
//            String screenshotFileName = System.getProperty("user.dir") + "\\TestScreenshots\\" + scenario.getName() + ".png";
//            File screenshotFile = new File(screenshotFileName);
//
//            Robot robo = new Robot();
//            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//            Rectangle r = new Rectangle(d);
//            BufferedImage img = robo.createScreenCapture(r);
//
//            try {
//                ImageIO.write(img, "PNG", screenshotFile);
//            } catch (Throwable t) {
//                t.printStackTrace();
//            }
        }


    }
}
