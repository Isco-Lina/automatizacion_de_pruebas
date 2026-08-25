package automatizacion.bdd;

import automatizacion.ServicioLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private final ServicioLogin servicioLogin = new ServicioLogin();

    private String usuario;
    private String password;
    private boolean resultado;

    @Given("el usuario {string} esta registrado")
    public void elUsuarioEstaRegistrado(String usuario) {
        this.usuario = usuario;
    }

    @When("intenta iniciar sesion con la contrasena {string}")
    public void intentaIniciarSesion(String password) {
        this.password = password;
        resultado = servicioLogin.iniciarSesion(usuario, password);
    }

    @Then("el acceso debe ser permitido")
    public void elAccesoDebeSerPermitido() {
        assertTrue(resultado);
    }

    @Given("el usuario {string} intenta acceder")
    public void elUsuarioIntentaAcceder(String usuario) {
        this.usuario = usuario;
    }

    @When("utiliza la contrasena {string}")
    public void utilizaLaPassword(String password) {
        this.password = password;
        resultado = servicioLogin.iniciarSesion(usuario, password);
    }

    @Then("el acceso debe ser rechazado")
    public void elAccesoDebeSerRechazado() {
        assertFalse(resultado);
    }
}