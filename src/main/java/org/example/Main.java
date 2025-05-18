package org.example;


import org.example.client.ClienteExchangeRateApi;
import org.example.model.Conversion;
import org.example.service.ConvertirPorValor;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        ClienteExchangeRateApi clienteExchangeRateApi = new ClienteExchangeRateApi();
        ConvertirPorValor convertirPorValor = new ConvertirPorValor();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE CONVERSIÓN DE MONEDAS ===");
            System.out.println("1. Listar monedas disponibles");
            System.out.println("2. Convertir monedas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println(ClienteExchangeRateApi.listadoMonedas());
                    break;
                case 2:
                    System.out.println("ingrese moneda base");
                    String monedaBase = scanner.nextLine();

                    System.out.println("ingrese moneda a cual la quiere convertir");
                    String monedaObjetivo = scanner.nextLine();

                    System.out.println("ingrese monto a convertir");
                    double monto = scanner.nextDouble();

                    Conversion conversion = clienteExchangeRateApi.convertir(monedaBase, monedaObjetivo);
                    System.out.println(conversion);

                    System.out.println("su monto convertido es: "+ convertirPorValor.convertirAxMonto(monto, conversion.conversion_rate()));

                    break;
                case 3:
                    System.out.println("¡Saliendo!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 3);

        scanner.close();


    }
}