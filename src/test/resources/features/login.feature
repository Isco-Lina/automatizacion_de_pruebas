Feature: Inicio de sesion de usuario

  Como usuario registrado
  Quiero iniciar sesion con mis credenciales
  Para acceder correctamente al sistema

  Scenario: Inicio de sesion correcto
    Given el usuario "francisco" esta registrado
    When intenta iniciar sesion con la contrasena "clave123"
    Then el acceso debe ser permitido

  Scenario Outline: Intentos de inicio de sesion no validos
    Given el usuario "<usuario>" intenta acceder
    When utiliza la contrasena "<password>"
    Then el acceso debe ser rechazado

    Examples:
      | usuario   | password   |
      | francisco | incorrecta |
      | pedro     | clave123   |