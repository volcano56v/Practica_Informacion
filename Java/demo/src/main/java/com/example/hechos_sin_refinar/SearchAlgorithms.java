package com.example.hechos_sin_refinar;

public class SearchAlgorithms {

    // 1. Búsqueda Lineal (Ineficiente para arreglos grandes - O(n))
    // Revisa uno por uno desde el principio hasta el final.
    public int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i; // Retorna el índice donde lo encontró
            }
        }
        return -1; // Retorna -1 si no lo encuentra
    }

    // 2. Búsqueda Binaria (Eficiente - O(log n))
    // Divide el arreglo a la mitad en cada paso. Requiere datos ordenados.
    public int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == target) {
                return mid; // Lo encontró justo en el medio
            }
            if (data[mid] < target) {
                left = mid + 1; // Descarta la mitad izquierda
            } else {
                right = mid - 1; // Descarta la mitad derecha
            }
        }
        return -1; // Retorna -1 si no lo encuentra
    }

    public int generarNumerosAleatorios(){
        int max = 99;
        int min = 1;
        int numero = (int) (Math.random() * (max - min + 1)) + min;
        return numero;
    }

    static void main(String[] args) {
        int [] numeros = new int[10];
        int encontrar = 49;
        SearchAlgorithms busqueda = new SearchAlgorithms();

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = busqueda.generarNumerosAleatorios();
        }

        busqueda.linearSearch(numeros,encontrar);
        busqueda.binarySearch(numeros,encontrar);
    }
}
