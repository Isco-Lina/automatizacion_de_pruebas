package automatizacion;

public class ValidadorUsuario {

    public boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    public boolean passwordValida(String password) {
        return password != null && password.length() >= 8;
    }
}