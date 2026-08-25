package automatizacion;

public class ServicioLogin {

    public boolean iniciarSesion(String usuario, String password) {

        String usuarioCorrecto = "francisco";
        String passwordCorrecta = "clave123";

        return usuarioCorrecto.equals(usuario)
                && passwordCorrecta.equals(password);
    }
}