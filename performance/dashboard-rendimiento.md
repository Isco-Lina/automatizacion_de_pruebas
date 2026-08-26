# Dashboard de métricas de pruebas

Este dashboard simula una vista consolidada de los principales resultados obtenidos durante la ejecución de las pruebas funcionales y de rendimiento del proyecto.

El objetivo es facilitar la revisión de las métricas y permitir identificar rápidamente el estado general de las pruebas.

## 1. Métricas funcionales

| Indicador | Resultado |
|---|---:|
| Pruebas unitarias JUnit | 2 |
| Escenarios BDD ejecutados | 3 |
| Total de pruebas funcionales | 5 |
| Pruebas exitosas | 5 |
| Pruebas fallidas | 0 |
| Tasa de éxito | 100 % |
| Estado | APROBADO |

Las pruebas funcionales corresponden a las dos pruebas unitarias desarrolladas con JUnit 5 y a los tres escenarios ejecutados mediante Cucumber.

## 2. Métricas de rendimiento

| Indicador | Resultado |
|---|---:|
| Usuarios virtuales | 5 |
| Duración de la prueba | 10 segundos |
| Solicitudes HTTP | 90 |
| Solicitudes por segundo | 8,08 req/s |
| Tasa de errores | 0 % |
| Tiempo promedio de respuesta | 83,13 ms |
| Percentil 95 (p95) | 179,13 ms |
| Threshold de errores (< 5 %) | CUMPLIDO |
| Threshold p95 (< 500 ms) | CUMPLIDO |
| Estado | APROBADO |

Para la simulación de rendimiento se utilizó `https://test.k6.io/` como endpoint HTTP de prueba, con el propósito de demostrar la ejecución de carga y el análisis de métricas mediante k6.

## 3. Estado general

| Área | Estado |
|---|---|
| Pruebas unitarias | APROBADO |
| Pruebas BDD | APROBADO |
| Prueba de rendimiento | APROBADO |
| Pipeline de CI | APROBADO |
| Estado general del proyecto | CORRECTO |

La visualización conjunta de métricas funcionales y de rendimiento permite obtener una visión general del estado del proyecto y facilita la detección de posibles fallos o degradaciones.

## 4. Simulación de alertas automáticas

A partir de los resultados obtenidos se definieron condiciones de alerta que podrían utilizarse para informar al equipo cuando se detecten fallos funcionales o degradaciones de rendimiento.

| Condición detectada | Nivel | Acción propuesta |
|---|---|---|
| Una prueba funcional falla | Crítica | Detener la validación del cambio y revisar el error |
| Tasa de errores HTTP superior al 5 % | Crítica | Notificar al equipo de desarrollo y QA |
| Percentil 95 superior a 500 ms | Advertencia | Revisar una posible degradación del rendimiento |
| Pipeline de Integración Continua fallido | Crítica | Evitar fusionar el Pull Request hacia main |

### Flujo de alerta simulado

1. GitHub Actions ejecuta automáticamente las pruebas del proyecto.
2. Si una prueba funcional falla, el pipeline queda en estado fallido.
3. La prueba de rendimiento ejecutada con k6 verifica los thresholds configurados.
4. Si la tasa de errores supera el 5 % o el p95 supera 500 ms, k6 considera que el threshold no fue cumplido.
5. El equipo debe revisar el resultado antes de incorporar los cambios a la rama principal.

En un entorno real, estas alertas podrían integrarse con servicios de notificación como correo electrónico, Microsoft Teams, Slack o plataformas de monitoreo como Grafana.