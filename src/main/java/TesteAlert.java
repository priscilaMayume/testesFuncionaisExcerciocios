import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {
    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        System.setProperty("webdriver.gecko.driver", "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/testeSelium/src/main/resources/firefox/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/campo_treinamento/componentes.html");
        dsl = new DSL(driver);

    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveInteragirComAlertSimples(){
        dsl.clicarBotao("alert");
        String texto = dsl.alertaObterTextoEAceita();
        Assert.assertEquals("Alert Simples", texto);

        dsl.escrever("elementosForm:nome", texto);
    }

    @Test
    public void deveInteragirComAlertConfirm(){
        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
        Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

        dsl.clicarBotao("confirm");
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
        Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
    }

    @Test
    public void deveInteragirComAlertPrompt(){
        dsl.clicarBotao("prompt");
        Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
        dsl.alertaEscrever("12");
        Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
        Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
    }
}