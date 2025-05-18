package org.example.client;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import org.example.model.Conversion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ClienteExchangeRateApi {

    //librearia para asignar variable de entorno desde archivo .evn
    private static final Dotenv dotenv = Dotenv.load();
    private static final String apiKey = dotenv.get("API_KEY");


    public static Conversion convertir(String monedaBase, String monedaObjetivo) {
        try {

            // Crear cliente HTTP
            var client = HttpClient.newHttpClient();

            // Construir URL
            String url = String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                    apiKey, monedaBase, monedaObjetivo);

            // Crear request HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("accept", "application/json")
                    .build();

            // Enviar request y obtener response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir JSON a objeto Pelicula
            return new Gson().fromJson(response.body(), Conversion.class);


        } catch (Exception e) {
            throw new RuntimeException("Error al convertir monedas: " + e.getMessage());
        }
    }
        public static List<String> listadoMonedas () {
            try {
                var client = HttpClient.newHttpClient();
                String url = String.format("https://v6.exchangerate-api.com/v6/%s/codes", apiKey);

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("accept", "application/json")
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
                JsonArray codesArray = jsonObject.getAsJsonArray("supported_codes");

                List<String> monedas = new ArrayList<>();

                for (JsonElement element : codesArray) {
                    JsonArray pair = element.getAsJsonArray();
                    String code = pair.get(0).getAsString();
                    monedas.add(code);
                }

                return monedas;

            } catch (Exception e) {
                throw new RuntimeException("Error al obtener listado de monedas: " + e.getMessage());
            }
        }



        }




