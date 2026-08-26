# Métricas de rendimiento

Se realizó una prueba básica de rendimiento utilizando k6.

La prueba simuló 5 usuarios virtuales durante 10 segundos realizando solicitudes HTTP.

## Resultados obtenidos

| Métrica                 |         Resultado |
| ----------------------- | ----------------: |
| Usuarios virtuales      |                 5 |
| Duración                |       10 segundos |
| Solicitudes HTTP        |                90 |
| Solicitudes por segundo | 8.08 req/s aprox. |
| Errores HTTP            |                0% |
| Latencia promedio       |          83.13 ms |
| Latencia p95            |         179.13 ms |
| Checks correctos        |              100% |

## Interpretación

Durante la ejecución no se registraron errores HTTP y todas las validaciones fueron correctas.

La latencia promedio fue de aproximadamente 83.13 ms, lo que representa el tiempo promedio utilizado por las solicitudes para obtener una respuesta.

El percentil 95 fue de 179.13 ms. Esto indica que el 95% de las solicitudes respondió en aproximadamente 179 ms o menos.

La prueba alcanzó aproximadamente 8.08 solicitudes por segundo sin presentar fallos durante la carga simulada.

## Simulación de dashboard

En un ambiente real estas métricas podrían enviarse a un dashboard utilizando herramientas como Grafana.

El dashboard podría mostrar principalmente:

* Solicitudes por segundo.
* Latencia promedio.
* Latencia p95.
* Porcentaje de errores.
* Usuarios virtuales activos.
* Cantidad total de solicitudes.

Esto permitiría observar el comportamiento de la aplicación durante una prueba de carga y detectar aumentos de latencia o errores.

## Alertas propuestas

También se podrían configurar alertas automáticas para detectar problemas durante las pruebas.

Ejemplos:

* Generar una alerta si el porcentaje de errores supera el 5%.
* Generar una alerta si la latencia p95 supera los 500 ms.
* Generar una alerta si disminuye considerablemente la cantidad de solicitudes procesadas por segundo.

Estas alertas permitirían detectar rápidamente una degradación en el rendimiento del sistema.
