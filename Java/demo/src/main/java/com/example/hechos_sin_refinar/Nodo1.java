package com.example.hechos_sin_refinar;

import java.util.Random;
import java.util.HashSet;
import java.util.HashMap;    // Para nuestro "diccionario"
import java.util.ArrayList;  // Para guardar listas de índices
import java.util.List;
import java.util.Map;

class Nodo1 {
    static class Nodo {
        int date;
        Nodo next;

        public Nodo(int date) {
            this.date = date;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        int tamanhoprueba = 2000;
        int tamanhoprueba2 = 1000;
        /*
        Nodo firstNode = new Nodo(3);
        Nodo secondNode = new Nodo(5);
        Nodo thirsNode = new Nodo(13);
        Nodo fourNode = new Nodo(2);

        firstNode.next = secondNode;
        secondNode.next = thirsNode;
        thirsNode.next = fourNode;

        System.out.println(firstNode.date + " -> " + secondNode.date + " -> " + thirsNode.date + " -> " + fourNode.date);
         */
        /* for (int i = 2; i < tamanhoprueba2; i = i + 2) {
            Nodo nuevo = new Nodo(generarNumerosRandom());
            System.out.println(nuevo.date + "->");
        }
         */

        Nodo primerNodo = null; // Guardará el inicio de nuestra lista
        Nodo nodoActual = null; // Nos ayudará a ir conectando los nodos

        // 1. CREAR Y CONECTAR LA LISTA
        for (int i = 2; i < tamanhoprueba2; i = i + 2) {
            Nodo nuevo = new Nodo(generarNumerosRandom());

            if (primerNodo == null) {
                // Si es el primer nodo que creamos, lo guardamos como el inicio
                primerNodo = nuevo;
                nodoActual = primerNodo;
            } else {
                // Si ya hay nodos, conectamos el nuevo al final de la cadena
                nodoActual.next = nuevo;
                nodoActual = nuevo; // Avanzamos al nuevo final
            }
        }

        // 2. BUSCAR DUPLICADOS PASÁNDOLE NUESTRA LISTA
        buscarNumeroDuplicado(primerNodo);
        // 2. BUSCAR DUPLICADOS Y MEDIR EL TIEMPO
        System.out.println("Iniciando búsqueda...");

        // --- INICIA EL CRONÓMETRO ---
        long tiempoInicio = System.nanoTime();

        // Ejecutamos el método que queremos medir
        buscarNumeroDuplicadoConIndice(primerNodo);

        // --- SE DETIENE EL CRONÓMETRO ---
        long tiempoFin = System.nanoTime();

        // 3. CALCULAR Y MOSTRAR LOS RESULTADOS
        long duracionNanosegundos = tiempoFin - tiempoInicio;

        // Los nanosegundos son números gigantes, así que es útil convertirlo a milisegundos
        // 1 milisegundo = 1,000,000 de nanosegundos
        double duracionMilisegundos = (double) duracionNanosegundos / 1_000_000.0;

        System.out.println("\n=== REPORTE DE RENDIMIENTO ===");
        System.out.println("Tiempo total en nanosegundos: " + duracionNanosegundos + " ns");
        System.out.println("Tiempo total en milisegundos: " + duracionMilisegundos + " ms");
    }

    public static int generarNumerospares(int n){
        return n;
    }

    public static int generarNumerosRandom() {
        Random rand = new Random();
        int totalNodos = 2000;
        return rand.nextInt(totalNodos);
    }

    // Modificamos el método para que reciba la lista y busque
    public static void buscarNumeroDuplicado(Nodo inicio) {
        // HashSet es como una caja donde solo puedes meter cosas que no estén repetidas
        HashSet<Integer> numerosVistos = new HashSet<>();
        HashSet<Integer> numerosRepetidos = new HashSet<>();

        Nodo actual = inicio;

        while (actual != null) {
            // Intentamos añadir el número a "numerosVistos"
            // Si el HashSet dice "falso", significa que ese número ya estaba adentro (es un duplicado)
            if (numerosVistos.add(actual.date) == false) {
                numerosRepetidos.add(actual.date); // Lo guardamos en la lista de repetidos
            }
            actual = actual.next; // Pasamos al siguiente nodo de la lista
        }

        // Imprimimos el resultado
        System.out.println("Se encontraron los siguientes números repetidos: ");
        for (Integer repetido : numerosRepetidos) {
            System.out.print(repetido + " -> ");
        }
    }

    // MÉTODO NUEVO CON MAPEO DE ÍNDICES
    public static void buscarNumeroDuplicadoConIndice(Nodo inicio) {
        // Diccionario: Clave = El número del nodo, Valor = Lista de índices donde aparece
        HashMap<Integer, List<Integer>> posiciones = new HashMap<>();

        Nodo actual = inicio;
        int indiceActual = 0; // ¡Nuestro propio contador de índice!

        while (actual != null) {
            // Si es la primera vez que vemos este número, le creamos una lista vacía
            if (!posiciones.containsKey(actual.date)) {
                posiciones.put(actual.date, new ArrayList<>());
            }

            // Añadimos el índice actual a la lista de ese número
            posiciones.get(actual.date).add(indiceActual);

            // Avanzamos al siguiente nodo y sumamos 1 al índice
            actual = actual.next;
            indiceActual++;
        }

        // 3. IMPRIMIR LOS RESULTADOS
        System.out.println("Números que se repiten y sus posiciones (índices):");

        // Recorremos nuestro diccionario para ver qué encontramos
        for (Map.Entry<Integer, List<Integer>> entrada : posiciones.entrySet()) {
            // Si la lista de índices tiene más de 1 elemento, significa que se repitió
            if (entrada.getValue().size() > 1) {
                System.out.println("El número " + entrada.getKey() +
                        " aparece en los índices: " + entrada.getValue());
            }
        }
    }
}