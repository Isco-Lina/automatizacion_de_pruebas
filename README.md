# Automatización de Pruebas

Proyecto Java desarrollado con Maven y JUnit 5 para implementar pruebas automatizadas y un flujo básico de Integración Continua.

## Objetivo

El objetivo del proyecto es implementar un proceso básico de automatización de pruebas utilizando Java, Maven, JUnit 5, Git y GitHub Actions.

El proyecto permite ejecutar pruebas unitarias de forma local y también automáticamente mediante un pipeline de Integración Continua.

## Tecnologías utilizadas

- Java 17
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions

## Estructura del proyecto

```text
automatizacion_de_pruebas/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── automatizacion/
│   │           └── ValidadorUsuario.java
│   │
│   └── test/
│       └── java/
│           └── automatizacion/
│               ├── EdadTest.java
│               └── PasswordTest.java
│
├── .gitignore
├── pom.xml
└── README.md
```

La carpeta `src/main/java` contiene el código principal de la aplicación.

La carpeta `src/test/java` contiene las pruebas automatizadas.

El archivo `pom.xml` contiene la configuración del proyecto Maven y la dependencia de JUnit 5.

El archivo `.gitignore` evita que Git almacene archivos generados automáticamente, como la carpeta `target`.

El archivo `.github/workflows/ci.yml` contiene la configuración del pipeline de Integración Continua.

## Pruebas implementadas

Se implementaron dos pruebas unitarias independientes:

- `EdadTest`: valida que un usuario sea mayor de edad.
- `PasswordTest`: valida que una contraseña tenga un mínimo de 8 caracteres.

Ambas pruebas utilizan JUnit 5 y verifican comportamientos específicos de la clase `ValidadorUsuario`.

Cada prueba evalúa una sola condición, por lo que se mantienen separadas e independientes entre sí.

## Ejecución local de las pruebas

Para ejecutar las pruebas de forma local se utiliza el siguiente comando:

```bash
mvn clean test
```

Este comando limpia los archivos generados en ejecuciones anteriores, compila el proyecto y ejecuta las pruebas automatizadas.

Cuando las pruebas se ejecutan correctamente, Maven muestra un resultado similar a:

```text
Tests run: 2
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## Control de versiones

El proyecto utiliza Git para mantener el control de los cambios realizados durante el desarrollo.

Se trabajó con una rama adicional llamada:

```text
feature/pruebas-usuario
```

Algunos de los comandos utilizados fueron:

```bash
git init
git branch -M main
git checkout -b feature/pruebas-usuario
git add .
git commit -m "feat: configura proyecto Maven y pruebas de validacion de usuario"
git log --oneline
```

También se realizaron commits separados para registrar cambios relacionados con documentación y configuración del pipeline.

Posteriormente el proyecto fue enviado a un repositorio remoto en GitHub.

## Integración Continua

Se configuró un pipeline de Integración Continua utilizando GitHub Actions mediante el archivo:

```text
.github/workflows/ci.yml
```

El pipeline se ejecuta automáticamente cuando se realiza un `push` o un `pull request` sobre la rama `main`.

Durante la ejecución del pipeline se realizan los siguientes pasos:

1. Se descarga el código del repositorio.
2. Se configura Java 17.
3. Se ejecuta Maven.
4. Se compila el proyecto.
5. Se ejecutan automáticamente las pruebas unitarias.
6. Se guardan los reportes generados por Maven.

El comando principal utilizado por el pipeline es:

```bash
mvn clean test
```

De esta forma las pruebas no dependen solamente de una ejecución local, ya que también son verificadas automáticamente dentro de GitHub.

## Reporte de pruebas

Maven genera automáticamente los resultados de las pruebas dentro de la carpeta:

```text
target/surefire-reports/
```

El pipeline de GitHub Actions guarda estos resultados como un artefacto llamado:

```text
reporte-pruebas
```

Este artefacto queda disponible dentro de la ejecución del workflow y permite revisar los resultados obtenidos por las pruebas.

Dentro del reporte se encuentran los resultados correspondientes a `EdadTest` y `PasswordTest`, donde es posible verificar la cantidad de pruebas ejecutadas, fallos, errores y tiempo de ejecución.

De esta forma los resultados pueden ser consultados por el equipo directamente desde GitHub Actions.