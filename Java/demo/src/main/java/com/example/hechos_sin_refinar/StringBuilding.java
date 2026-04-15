package com.example.hechos_sin_refinar;

public class StringBuilding {

    // 1. Concatenación repetida (Ineficiente - O(n^2))
    // Recrea el objeto String completo en memoria en cada iteración.
    public String buildWithConcat(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a";
        }
        return result;
    }

    // 2. Uso de Builder (Eficiente - O(n))
    // Usa un arreglo de caracteres interno que crece dinámicamente sin recrear el objeto.
    public String buildWithBuilder(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("a");
        }
        return builder.toString();
    }

    static void main(String[] args) {
        StringBuilding contruir = new StringBuilding();
        System.out.println(contruir.buildWithConcat(10));
        System.out.println(contruir.buildWithBuilder(10));
    }
}