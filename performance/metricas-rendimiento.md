# Métricas de rendimiento

Se realizó una prueba básica de rendimiento utilizando k6.

La prueba simuló 5 usuarios virtuales durante 10 segundos realizando solicitudes HTTP.

## Resultados obtenidos

| Métrica | Resultado |
|---|---:|
| Usuarios virtuales | 5 |
| Duración | 10 segundos |
| Solicitudes HTTP | 80 |
| Solicitudes por segundo | 7.86 req/s |
| Errores HTTP | 0% |
| Latencia promedio | 80.84 ms |
| Latencia p90 | 147.05 ms |
| Latencia p95 | 169.95 ms |
| Latencia máxima | 173.02 ms |
| Checks correctos | 100% |

## Interpretación

Durante la ejecución no se registraron errores HTTP y todas las validaciones fueron correctas.

La latencia promedio fue de 80.84 ms, lo que representa el tiempo promedio utilizado por las solicitudes para obtener una respuesta.

El percentil 95 fue de 169.95 ms. Esto significa que el 95% de las solicitudes respondió en aproximadamente 170 ms o menos.

La prueba alcanzó aproximadamente 7.86 solicitudes por segundo sin presentar fallos durante la carga simulada.

## Simulación de dashboard

En un ambiente real estas métricas podrían enviarse a un dashboard utilizando herramientas como Grafana.

El dashboard podría mostrar principalmente:

- Solicitudes por segundo.
- Latencia promedio.
- Latencia p95.
- Porcentaje de errores.
- Usuarios virtuales activos.
- Cantidad total de solicitudes.

Esto permitiría observar el comportamiento de la aplicación durante una prueba de carga y detectar aumentos de latencia o errores.

## Alertas propuestas

También se podrían configurar alertas automáticas para detectar problemas durante las pruebas.

Ejemplos:

- Generar una alerta si el porcentaje de errores supera el 5%.
- Generar una alerta si la latencia p95 supera los 500 ms.
- Generar una alerta si disminuye considerablemente la cantidad de solicitudes procesadas por segundo.

Estas alertas permitirían detectar rápidamente una degradación en el rendimiento del sistema.