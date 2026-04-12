package com.example.hechos_sin_refinar;

import java.util.ArrayList;

public class Nodo3 {
    static class Nodo {
        int date;
        Nodo left;
        Nodo right;

        public Nodo(int date) {
            this.date = date;
            this.left = null;
            this.right = null;
        }
    }

    // Tu método original inOrder
    public static void inOrder(Nodo node, ArrayList<Integer> res){
        if (node == null) return;

        inOrder(node.left, res);
        res.add(node.date);
        inOrder(node.right, res);
    }

    // ¡NUEVO MÉTODO! Para imprimir el árbol de forma visual
    public static void imprimirArbol(Nodo nodo, String prefijo, boolean esIzquierdo, boolean esRaiz) {
        if (nodo == null) {
            return;
        }

        // 1. Recorremos el lado derecho primero (quedará en la parte de arriba de la consola)
        imprimirArbol(nodo.right, prefijo + (esIzquierdo ? "│   " : "    "), false, false);

        // 2. Imprimimos las "ramas" y el valor del nodo actual
        System.out.print(prefijo);
        if (esRaiz) {
            System.out.print("─── "); // La raíz principal se dibuja distinto
        } else {
            System.out.print(esIzquierdo ? "└── " : "┌── ");
        }
        System.out.println(nodo.date);

        // 3. Recorremos el lado izquierdo (quedará en la parte de abajo de la consola)
        imprimirArbol(nodo.left, prefijo + (esIzquierdo ? "    " : "│   "), true, false);
    }

    static void main(String[] args) {
        // Tu mismo árbol
        Nodo root = new Nodo(1);
        root.left = new Nodo(2);
        root.right = new Nodo(3);
        root.left.left = new Nodo(4);
        root.left.right = new Nodo(5);
        root.right.right = new Nodo(6);

        // Mostrar el árbol bonito
        System.out.println("Estructura del árbol (léelo de izquierda a derecha):");
        System.out.println();
        // Llamada inicial a la raíz (prefijo vacío, y marcamos que es la raíz con 'true')
        imprimirArbol(root, "", false, true);

        System.out.println("\n-----------------------------");

        // Tu recorrido in-order
        System.out.println("Resultado del recorrido In-Order:");
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        System.out.println(res);
    }
}