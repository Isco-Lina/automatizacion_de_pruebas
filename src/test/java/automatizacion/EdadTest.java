package automatizacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EdadTest {

    @Test
    void debeAceptarUsuarioMayorDeEdad() {

        ValidadorUsuario validador = new ValidadorUsuario();

        boolean resultado = validador.esMayorDeEdad(20);

        assertTrue(resultado);
    }
}