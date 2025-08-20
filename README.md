# Tipo De Cambio Service

Servicio REST en **Quarkus** para consultar y registrar el tipo de cambio de monedas.  
Usa **H2 en memoria** como base de datos y expone un endpoint para obtener el tipo de cambio desde una API externa.

## Ejecución en modo desarrollo

Ejecuta el proyecto con:

```shell script
./mvnw compile quarkus:dev
```
La aplicación estará disponible en: http://localhost:8080

## Endpoint

### GET /tipo-cambio/{dni}:

Registra un nuevo tipo de cambio en la base de datos.

**Cuerpo esperado (JSON):**
```json
{
    "fecha": "2025-08-20",
    "sunat": 3.555,
    "compra": 3.549,
    "venta": 3.561
}
```

## Respuestas y errores

200 OK

400 Bad Request → El campo dni es obligatorio.

400 Bad Request → El campo dni debe contener exactamente 8 dígitos numéricos.

429 Too Many Requests → Límite de 10 consultas por día alcanzado.
