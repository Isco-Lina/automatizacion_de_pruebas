# Dashboard de rendimiento

Este dashboard representa de forma resumida los principales resultados obtenidos durante la prueba de rendimiento realizada con k6.

## Estado general

| Indicador | Resultado | Estado |
|---|---:|---|
| Usuarios virtuales | 5 | OK |
| Duración de prueba | 10 segundos | OK |
| Solicitudes HTTP | 80 aprox. | OK |
| Solicitudes por segundo | 7 a 8 req/s aprox. | OK |
| Errores HTTP | 0% | OK |
| Latencia promedio | Menor a 100 ms | OK |
| Latencia p95 | Menor a 500 ms | OK |
| Checks correctos | 100% | OK |

## Indicadores monitoreados

### Solicitudes por segundo

Permite observar la cantidad de solicitudes procesadas por el sistema durante la prueba.

### Latencia

Permite conocer cuánto demora el sistema en responder.

Se considera especialmente el percentil 95, ya que permite revisar el tiempo máximo aproximado en el que respondió la mayoría de las solicitudes.

### Porcentaje de errores

Permite detectar solicitudes que no fueron procesadas correctamente.

Durante las pruebas realizadas el porcentaje de errores fue de 0%.

### Usuarios virtuales

La prueba fue ejecutada simulando 5 usuarios virtuales concurrentes.

## Umbrales definidos

En k6 se configuraron los siguientes límites:

- El porcentaje de errores debe mantenerse bajo el 5%.
- El percentil 95 de la latencia debe mantenerse bajo los 500 ms.

Estos valores permiten detectar automáticamente una degradación del rendimiento durante la ejecución de la prueba.