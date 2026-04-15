package com.example.hechos_sin_refinar;

import java.util.HashMap;
import java.util.Map;

public class OcurrenceCounting {

    // 1. Búsqueda lineal (Ineficiente - O(n^2))
    // Por cada elemento, recorre el arreglo completo para contar cuántas veces aparece.
    public int[] countLinear(int[] data) {
        int[] counts = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[i] == data[j]) {
                    count++;
                }
            }
            counts[i] = count;
        }
        return counts; // Retorna un arreglo con las frecuencias en el mismo orden
    }

    // 2. Usar diccionario/Hash (Eficiente - O(n))
    // Recorre el arreglo una sola vez y va guardando/actualizando el conteo en un Mapa.
    public Map<Integer, Integer> countHash(int[] data) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : data) {
            // Si el número existe, le suma 1 a su valor. Si no, lo inicializa en 0 + 1.
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return counts; // Retorna un mapa con la relación Número -> Frecuencia
    }

    public int generarNumerosAleatorios(){
        int max = 99;
        int min = 1;
        int numero = (int) (Math.random() * (max - min + 1)) + min;
        return numero;
    }

    static void main(String[] args) {
        int [] numeros = new int[10];
        OcurrenceCounting ocurencia = new OcurrenceCounting();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = ocurencia.generarNumerosAleatorios();
        }

        ocurencia.countLinear(numeros);
        ocurencia.countHash(numeros);
    }
}