import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {

    @Test
    public void teste() {
     System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        WebDriver driver = new FirefoxDriver();
        //driver.manage().window().setSize(new Dimension(1200, 765));
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        Assert.assertEquals("Google", driver.getTitle());

        driver.quit();
    }
}
