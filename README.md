# Conversor de Monedas (Java + ExchangeRate API)

Este proyecto es una aplicación de consola escrita en Java que permite:

- Listar monedas soportadas por la API de [ExchangeRate API](https://www.exchangerate-api.com/)
- Convertir montos entre dos monedas
- Salir del programa

## 🧰 Tecnologías utilizadas

- Java 17+
- API pública de ExchangeRate API
- Gson (para parsear JSON)
- `java.net.http.HttpClient` (para peticiones HTTP)
- Dotenv (para gestionar variables de entorno)
- 
## 📦 Estructura del proyecto

src/
├── org.example/
│ ├── Main.java # Menú principal y lógica de consola
│
├── org.example.client/
│ └── ClienteExchangeRateApi.java # Cliente HTTP para consumir la API
│
├── org.example.model/
│ └── Conversion.java # Record que representa la respuesta de conversión
│
├── org.example.service/
│ └── ConvertirPorValor.java # Lógica de conversión de monto * tasa


## ⚙️ Configuración

1. Crea un archivo `.env` en la raíz del proyecto con el siguiente contenido:
API_KEY=tu_api_key_de_exchangerate

> Puedes obtener una API key gratuita desde: https://www.exchangerate-api.com/

2. Asegúrate de tener las siguientes dependencias en tu `pom.xml` o `build.gradle`:

### Maven

```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
    <dependency>
        <groupId>io.github.cdimascio</groupId>
        <artifactId>java-dotenv</artifactId>
        <version>5.2.2</version>
    </dependency>
</dependencies>
```

▶️ Cómo ejecutar
Compilá y ejecutá el programa con tu IDE o desde consola:

bash
Copiar
Editar
javac -d out src/org/example/**/*.java
java -cp out org.example.Main

=== MENÚ DE CONVERSIÓN DE MONEDAS ===
1. Listar monedas disponibles
2. Convertir monedas
3. Salir
Seleccione una opción: 2
ingrese moneda base
USD
ingrese moneda a cual la quiere convertir
EUR
ingrese monto a convertir
100
Conversion[base_code=USD, target_code=EUR, conversion_rate=0.914]
su monto convertido es: 91.4
![imagen de funcionamiento del programa](https://raw.githubusercontent.com/SantiagoPerezKay/conversor_de_monedas_curso_one_oracle/refs/heads/main/programa.jpg)
