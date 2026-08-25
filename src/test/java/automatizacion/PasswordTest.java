package automatizacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordTest {

    @Test
    void debeAceptarPasswordConOchoCaracteres() {

        ValidadorUsuario validador = new ValidadorUsuario();

        boolean resultado = validador.passwordValida("clave123");

        assertTrue(resultado);
    }
}