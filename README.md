# Automatización de Pruebas

Proyecto Java desarrollado con Maven, JUnit 5, Cucumber y k6 para implementar pruebas automatizadas, Integración Continua, pruebas BDD y pruebas básicas de rendimiento.

## Objetivo

El objetivo del proyecto es implementar un proceso básico de automatización de pruebas utilizando Java, Maven, JUnit 5, Git, GitHub Actions, Cucumber y k6.

El proyecto permite ejecutar pruebas unitarias de forma local, automatizar escenarios BDD y verificar su ejecución mediante un pipeline de Integración Continua.

También incorpora una prueba básica de rendimiento con métricas, umbrales y una simulación de dashboard para analizar el comportamiento del sistema.

## Tecnologías utilizadas

- Java 17
- Maven
- JUnit 5
- Git
- GitHub
- GitHub Actions
- Cucumber
- Gherkin
- k6

## Estructura del proyecto

```text
automatizacion_de_pruebas/
│
├── .github/
│   └── workflows/
│       └── ci.yml
│
├── performance/
│   ├── login-test.js
│   ├── metricas-rendimiento.md
│   └── dashboard-rendimiento.md
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── automatizacion/
│   │           ├── ValidadorUsuario.java
│   │           └── ServicioLogin.java
│   │
│   └── test/
│       ├── java/
│       │   └── automatizacion/
│       │       ├── EdadTest.java
│       │       ├── PasswordTest.java
│       │       └── bdd/
│       │           ├── LoginSteps.java
│       │           └── RunCucumberTest.java
│       │
│       └── resources/
│           └── features/
│               └── login.feature
│
├── .gitignore
├── pom.xml
└── README.md
```

La carpeta `src/main/java` contiene el código principal de la aplicación.

La carpeta `src/test/java` contiene las pruebas automatizadas.

La carpeta `src/test/resources/features` contiene los escenarios escritos en lenguaje Gherkin.

La carpeta `performance` contiene la prueba de rendimiento realizada con k6 y los archivos utilizados para documentar sus métricas.

El archivo `pom.xml` contiene la configuración del proyecto Maven y las dependencias necesarias para JUnit 5 y Cucumber.

El archivo `.gitignore` evita que Git almacene archivos generados automáticamente, como la carpeta `target`.

El archivo `.github/workflows/ci.yml` contiene la configuración del pipeline de Integración Continua.

## Pruebas unitarias implementadas

Se implementaron dos pruebas unitarias independientes:

- `EdadTest`: valida que un usuario sea mayor de edad.
- `PasswordTest`: valida que una contraseña tenga un mínimo de 8 caracteres.

Ambas pruebas utilizan JUnit 5 y verifican comportamientos específicos de la clase `ValidadorUsuario`.

Cada prueba evalúa una sola condición, por lo que se mantienen separadas e independientes entre sí.

## Ejecución local de las pruebas

Para ejecutar las pruebas de forma local se utiliza:

```bash
mvn clean test
```

Este comando limpia los archivos generados en ejecuciones anteriores, compila el proyecto y ejecuta las pruebas automatizadas.

Después de incorporar las pruebas BDD, Maven ejecuta un total de 5 pruebas:

```text
Tests run: 5
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## Control de versiones

El proyecto utiliza Git para mantener el control de los cambios realizados durante el desarrollo.

Se trabajó utilizando ramas separadas para desarrollar nuevas funcionalidades y posteriormente integrarlas a `main`.

Algunas de las ramas utilizadas fueron:

```text
feature/pruebas-usuario
feature/bdd-login
```

Algunos comandos utilizados durante el desarrollo fueron:

```bash
git init
git branch -M main
git checkout -b feature/pruebas-usuario
git checkout -b feature/bdd-login
git add .
git commit -m "feat: configura proyecto Maven y pruebas de validacion de usuario"
git log --oneline
git push
```

También se utilizaron Pull Requests para integrar cambios a la rama principal después de comprobar que las pruebas automatizadas se ejecutaran correctamente.

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
5. Se ejecutan las pruebas unitarias.
6. Se ejecutan los escenarios BDD.
7. Se guardan los reportes generados por Maven.
8. Se guarda el reporte HTML generado por Cucumber.

El comando principal ejecutado por el pipeline es:

```bash
mvn clean test
```

De esta forma las pruebas no dependen solamente de una ejecución local, ya que también son verificadas automáticamente dentro de GitHub.

## Reportes de pruebas

Maven genera los resultados de las pruebas dentro de:

```text
target/surefire-reports/
```

El pipeline de GitHub Actions guarda estos archivos como un artefacto llamado:

```text
reporte-pruebas
```

Esto permite consultar los resultados de las pruebas directamente desde la ejecución del workflow.

## Pruebas BDD

Para complementar las pruebas unitarias se implementó BDD utilizando Cucumber y Gherkin.

La funcionalidad seleccionada fue el inicio de sesión de usuario.

Se definieron criterios de aceptación considerando los roles de negocio, desarrollo y QA mediante una simulación de Three Amigos.

Los escenarios se encuentran en:

```text
src/test/resources/features/login.feature
```

Se implementó:

- Un escenario de inicio de sesión correcto.
- Un `Scenario Outline` para validar diferentes intentos de inicio de sesión incorrectos.
- Una tabla `Examples` con diferentes combinaciones de usuario y contraseña.

Los pasos `Given`, `When` y `Then` se conectan con Java mediante:

```text
LoginSteps.java
```

La clase:

```text
RunCucumberTest.java
```

permite ejecutar los escenarios BDD mediante JUnit Platform y Cucumber.

## Reporte BDD

Cucumber genera automáticamente un reporte HTML en:

```text
target/cucumber-report.html
```

Este reporte muestra de forma navegable:

- La funcionalidad ejecutada.
- Los escenarios.
- Los pasos `Given`, `When` y `Then`.
- Los ejemplos utilizados.
- El estado de cada escenario.

El pipeline también guarda este archivo como un artefacto llamado:

```text
reporte-bdd
```

De esta forma el reporte puede ser consultado después de cada ejecución del pipeline.

## Prueba de rendimiento

Se implementó una prueba básica de rendimiento utilizando k6.

El archivo utilizado se encuentra en:

```text
performance/login-test.js
```

La prueba simula:

- 5 usuarios virtuales.
- Una duración aproximada de 10 segundos.
- Solicitudes HTTP concurrentes.
- Validación del código de respuesta.

Para ejecutar la prueba se utiliza:

```bash
k6 run performance/login-test.js
```

## Métricas de rendimiento

Durante las pruebas se analizaron principalmente las siguientes métricas:

- Solicitudes HTTP.
- Solicitudes por segundo.
- Latencia promedio.
- Latencia p90.
- Latencia p95.
- Porcentaje de errores.
- Usuarios virtuales.
- Checks ejecutados correctamente.

En las ejecuciones realizadas no se registraron errores HTTP y los checks fueron ejecutados correctamente.

Los resultados e interpretación se encuentran documentados en:

```text
performance/metricas-rendimiento.md
```

## Umbrales y alertas

Dentro de la prueba de k6 se configuraron los siguientes límites:

```javascript
thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<500'],
}
```

Esto significa que:

- El porcentaje de errores debe mantenerse bajo el 5%.
- El 95% de las solicitudes debe responder en menos de 500 ms.

Estos umbrales permiten detectar automáticamente una posible degradación del rendimiento durante una prueba.

## Dashboard de rendimiento

Se realizó una simulación de dashboard para representar las principales métricas obtenidas durante las pruebas.

El archivo se encuentra en:

```text
performance/dashboard-rendimiento.md
```

El dashboard considera indicadores como:

- Usuarios virtuales.
- Solicitudes procesadas.
- Solicitudes por segundo.
- Porcentaje de errores.
- Latencia promedio.
- Latencia p95.
- Estado de los umbrales definidos.

En un ambiente real estas métricas podrían ser enviadas a herramientas como Grafana para monitorear el comportamiento del sistema mediante gráficos y alertas.

## Resultado general

El proyecto permite ejecutar pruebas unitarias, escenarios BDD y pruebas básicas de rendimiento.

Además, GitHub Actions automatiza la ejecución de las pruebas en cada cambio enviado a la rama principal y genera reportes que pueden ser consultados por el equipo.

Con esto se implementa un flujo básico de automatización de pruebas que integra control de versiones, pruebas automatizadas, BDD, Integración Continua, reportes y análisis de rendimiento.