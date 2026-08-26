# Automatización de Pruebas

Proyecto Java desarrollado con Maven, JUnit 5, Cucumber y k6 para implementar pruebas automatizadas, Integración Continua, escenarios BDD, reportes navegables y una prueba básica de rendimiento.

## Objetivo

El objetivo del proyecto es implementar un proceso básico de automatización de pruebas utilizando Java, Maven, JUnit 5, Git, GitHub Actions, Cucumber y k6.

El proyecto permite ejecutar pruebas unitarias de forma local, automatizar escenarios BDD y verificar su ejecución mediante un pipeline de Integración Continua.

También incorpora reportes de pruebas, una prueba básica de rendimiento, análisis de métricas, una simulación de dashboard y una propuesta de alertas automáticas.

## Tecnologías utilizadas

* Java 17
* Maven
* JUnit 5
* Git
* GitHub
* GitHub Actions
* Cucumber
* Gherkin
* k6

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

La carpeta `performance` contiene el script de rendimiento realizado con k6 y los archivos utilizados para documentar las métricas, dashboard y alertas simuladas.

El archivo `pom.xml` contiene la configuración del proyecto Maven y las dependencias necesarias para trabajar con JUnit 5 y Cucumber.

El archivo `.gitignore` evita que Git almacene archivos generados automáticamente, como la carpeta `target`.

El archivo `.github/workflows/ci.yml` contiene la configuración del pipeline de Integración Continua.

## Pruebas unitarias implementadas

Se implementaron dos pruebas unitarias independientes:

* `EdadTest`: valida que un usuario sea mayor de edad.
* `PasswordTest`: valida que una contraseña tenga un mínimo de 8 caracteres.

Ambas pruebas utilizan JUnit 5 y comprueban comportamientos específicos de la clase `ValidadorUsuario`.

Cada prueba evalúa una sola condición y puede ejecutarse de manera independiente, manteniendo la atomicidad de la suite.

## Ejecución local de las pruebas

Para ejecutar las pruebas de forma local se utiliza:

```bash
mvn clean test
```

Este comando limpia los archivos generados en ejecuciones anteriores, compila el proyecto y ejecuta las pruebas automatizadas.

Después de incorporar las pruebas BDD, Maven ejecuta:

* 2 pruebas unitarias.
* 3 escenarios BDD.
* 5 pruebas en total.

El resultado obtenido fue:

```text
Tests run: 5
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

## Control de versiones

El proyecto utiliza Git para mantener un historial de los cambios realizados durante el desarrollo.

Se trabajó utilizando ramas separadas para implementar nuevas funcionalidades y posteriormente integrarlas a `main`.

Entre las ramas utilizadas se encuentran:

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

También se utilizó un Pull Request para integrar la funcionalidad BDD a la rama principal.

Antes de realizar la fusión, GitHub Actions ejecutó automáticamente las pruebas y comprobó que el proyecto se encontrara en estado correcto.

## Integración Continua

Se configuró un pipeline de Integración Continua utilizando GitHub Actions mediante el archivo:

```text
.github/workflows/ci.yml
```

El pipeline se ejecuta automáticamente cuando se realiza un `push` o un `pull request` sobre la rama `main`.

Durante su ejecución se realizan los siguientes pasos:

1. Se descarga el código del repositorio.
2. Se configura Java 17.
3. Maven compila el proyecto.
4. Se ejecutan las pruebas unitarias.
5. Se ejecutan los escenarios BDD.
6. Se generan los reportes de pruebas.
7. Se almacena el reporte de Maven como artefacto.
8. Se almacena el reporte HTML de Cucumber como artefacto.

El comando principal ejecutado por el pipeline es:

```bash
mvn clean test
```

De esta forma, las pruebas no dependen solamente de una ejecución local, sino que también son verificadas automáticamente en GitHub Actions.

## Reportes de pruebas

Maven genera los resultados de las pruebas dentro de:

```text
target/surefire-reports/
```

El pipeline de GitHub Actions almacena estos archivos como un artefacto llamado:

```text
reporte-pruebas
```

Esto permite consultar los resultados después de cada ejecución del workflow.

## BDD y simulación de Three Amigos

Para complementar las pruebas unitarias se implementó Behavior-Driven Development utilizando Cucumber y Gherkin.

La funcionalidad seleccionada fue el inicio de sesión de usuario.

Antes de implementar los escenarios se realizó una simulación de Three Amigos considerando los roles de Negocio, QA y Desarrollo.

| Rol        | Decisión / aporte                                           |
| ---------- | ----------------------------------------------------------- |
| Negocio    | Define el comportamiento esperado del inicio de sesión      |
| QA         | Define los casos que deben comprobarse                      |
| Desarrollo | Determina cómo implementar la funcionalidad y automatizarla |

Los principales criterios definidos fueron:

* El usuario puede iniciar sesión cuando utiliza credenciales correctas.
* El acceso debe rechazarse cuando el usuario o la contraseña son incorrectos.
* Las diferentes combinaciones inválidas deben poder comprobarse mediante pruebas automatizadas.

## Escenarios BDD

Los escenarios se encuentran en:

```text
src/test/resources/features/login.feature
```

Se implementaron:

* Un escenario de inicio de sesión correcto.
* Un `Scenario Outline` para comprobar diferentes intentos de inicio de sesión incorrectos.
* Una tabla `Examples` con distintas combinaciones de usuario y contraseña.

Los pasos `Given`, `When` y `Then` se conectan con Java mediante:

```text
LoginSteps.java
```

La lógica utilizada para validar las credenciales se encuentra separada en:

```text
ServicioLogin.java
```

La clase:

```text
RunCucumberTest.java
```

permite ejecutar los escenarios mediante JUnit Platform y Cucumber.

## Reporte BDD

Cucumber genera automáticamente un reporte HTML en:

```text
target/cucumber-report.html
```

El reporte permite revisar de forma navegable:

* La funcionalidad ejecutada.
* Los escenarios.
* Los pasos `Given`, `When` y `Then`.
* Los ejemplos utilizados.
* El estado de cada escenario.

El pipeline almacena este archivo como un artefacto llamado:

```text
reporte-bdd
```

De esta forma el equipo puede acceder al reporte después de cada ejecución del pipeline.

## Prueba de rendimiento con k6

Se implementó una prueba básica de rendimiento utilizando k6.

El archivo utilizado se encuentra en:

```text
performance/login-test.js
```

La prueba configura:

* 5 usuarios virtuales.
* 10 segundos de duración.
* Solicitudes HTTP concurrentes.
* Validación de respuestas HTTP con código 200.
* Threshold de errores inferior al 5 %.
* Threshold de p95 inferior a 500 ms.

Para ejecutar la prueba se utiliza:

```bash
k6 run performance/login-test.js
```

Para esta simulación se utilizó el sitio público:

```text
https://test.k6.io/
```

como endpoint HTTP de prueba.

El objetivo fue demostrar la configuración de una prueba de carga y analizar sus principales métricas sin requerir un backend propio desplegado para el proyecto.

## Métricas de rendimiento

Los resultados obtenidos fueron:

| Métrica                      |   Resultado |
| ---------------------------- | ----------: |
| Usuarios virtuales           |           5 |
| Duración                     | 10 segundos |
| Solicitudes HTTP             |          90 |
| Solicitudes por segundo      |  8,08 req/s |
| Errores HTTP                 |         0 % |
| Tiempo promedio de respuesta |    83,13 ms |
| Percentil 95 (p95)           |   179,13 ms |
| Checks correctos             |       100 % |

Las principales métricas analizadas fueron:

* solicitudes HTTP procesadas;
* solicitudes por segundo;
* porcentaje de errores;
* tiempo promedio de respuesta;
* percentil 95;
* cumplimiento de los thresholds definidos.

## Thresholds de rendimiento

En el archivo `login-test.js` se configuraron los siguientes thresholds:

```javascript
thresholds: {
    http_req_failed: ['rate<0.05'],
    http_req_duration: ['p(95)<500'],
}
```

Esto establece que:

* La tasa de errores debe permanecer bajo el 5 %.
* El percentil 95 debe mantenerse bajo 500 ms.

Durante la ejecución ambos thresholds fueron cumplidos.

## Dashboard de métricas de pruebas

Se creó el archivo:

```text
performance/dashboard-rendimiento.md
```

como una simulación de dashboard para visualizar de forma conjunta las métricas funcionales y de rendimiento.

### Métricas funcionales

El dashboard considera:

* 2 pruebas unitarias JUnit.
* 3 escenarios BDD.
* 5 pruebas funcionales en total.
* 5 pruebas exitosas.
* 0 pruebas fallidas.
* 100 % de éxito.

### Métricas de rendimiento

También muestra:

* usuarios virtuales;
* duración de la prueba;
* solicitudes HTTP;
* solicitudes por segundo;
* tasa de errores;
* tiempo promedio de respuesta;
* p95;
* cumplimiento de los thresholds.

De esta forma se obtiene una vista consolidada del estado general de las pruebas del proyecto.

En un entorno real estas métricas podrían integrarse con herramientas como Grafana para ser representadas mediante gráficos y paneles de monitoreo.

## Simulación de alertas automáticas

A partir de las métricas funcionales y de rendimiento se definieron condiciones de alerta para detectar posibles fallos o degradaciones.

| Condición detectada                      | Nivel       | Acción propuesta                                    |
| ---------------------------------------- | ----------- | --------------------------------------------------- |
| Una prueba funcional falla               | Crítica     | Detener la validación del cambio y revisar el error |
| Tasa de errores HTTP superior al 5 %     | Crítica     | Notificar al equipo de desarrollo y QA              |
| Percentil 95 superior a 500 ms           | Advertencia | Revisar una posible degradación del rendimiento     |
| Pipeline de Integración Continua fallido | Crítica     | Evitar fusionar el Pull Request hacia `main`        |

### Flujo simulado de alertas

1. GitHub Actions ejecuta automáticamente las pruebas.
2. Si alguna prueba funcional falla, el pipeline queda en estado fallido.
3. k6 verifica los thresholds configurados durante la prueba de rendimiento.
4. Si la tasa de errores supera el 5 % o el p95 supera 500 ms, el threshold no se cumple.
5. El equipo debe revisar el problema antes de incorporar los cambios a la rama principal.

En un entorno real estas condiciones podrían integrarse con servicios como:

* correo electrónico;
* Microsoft Teams;
* Slack;
* Grafana.

## Resultado general

El proyecto permite ejecutar pruebas unitarias, escenarios BDD y una prueba básica de rendimiento.

GitHub Actions automatiza la ejecución de las pruebas ante cambios enviados al repositorio y almacena los reportes generados para su posterior revisión.

Los resultados funcionales obtenidos fueron:

```text
Pruebas unitarias: 2
Escenarios BDD: 3
Total: 5
Fallos: 0
Errores: 0
```

La prueba de rendimiento también cumplió los thresholds establecidos, obteniendo una tasa de errores de 0 % y un p95 aproximado de 179,13 ms.

Con esto se implementa un flujo de automatización que integra:

* control de versiones;
* pruebas unitarias;
* BDD;
* Integración Continua;
* reportes navegables;
* prueba de rendimiento;
* métricas;
* dashboard;
* simulación de alertas automáticas.
