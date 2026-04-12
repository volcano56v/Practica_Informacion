package com.example.hechos_sin_refinar;

public class Nodo2 {
    static class TreeNodo {
        int date;
        TreeNodo left;
        TreeNodo right;

        public TreeNodo(int date) {
            this.date = date;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNodo creandoElNuevoTreeNodo (int date){
        return new TreeNodo(date);
    }

    static void main(String[] args) {
        /*
        TreeNodo root = creandoElNuevoTreeNodo('0');
        TreeNodo nodoA = creandoElNuevoTreeNodo('A');
        TreeNodo nodoB = creandoElNuevoTreeNodo('B');
        TreeNodo nodoC = creandoElNuevoTreeNodo('C');
        TreeNodo nodoD = creandoElNuevoTreeNodo('D');
        TreeNodo nodoE = creandoElNuevoTreeNodo('E');
        TreeNodo nodoF = creandoElNuevoTreeNodo('F');
        TreeNodo nodoG = creandoElNuevoTreeNodo('G');

        // Nivel 1: Hijos de la raíz
        root.left = nodoA;
        root.right = nodoB;

// Nivel 2: Hijos del nodo A
        nodoA.left = nodoC;
        nodoA.right = nodoD;

// Nivel 2: Hijos del nodo B
        nodoB.left = nodoE;
        nodoB.right = nodoF;

// Nivel 3: Hijo del nodo C (por ejemplo)
        nodoC.left = nodoG;

        System.out.println("root.right.left.date"+root.right.left.date);
         */

        TreeNodo root = creandoElNuevoTreeNodo(5);
        TreeNodo nodo9 = creandoElNuevoTreeNodo(9);
        TreeNodo nodo26 = creandoElNuevoTreeNodo(26);
        TreeNodo nodo32 = creandoElNuevoTreeNodo( 32);
        TreeNodo nodo41 = creandoElNuevoTreeNodo(41);
        TreeNodo nodo3 = creandoElNuevoTreeNodo(3);
        TreeNodo nodo4 = creandoElNuevoTreeNodo(4);
        TreeNodo nodo7 = creandoElNuevoTreeNodo(7);
        TreeNodo nodo21 = creandoElNuevoTreeNodo(21);
        TreeNodo nodo20 = creandoElNuevoTreeNodo(20);
        TreeNodo nodo17 = creandoElNuevoTreeNodo(17);
        TreeNodo nodo31 = creandoElNuevoTreeNodo(31);

//nivel 1
        root.left = nodo9;
        root.right = nodo26;
//nivel 2
        nodo9.left = nodo32;
        nodo9.right = nodo41;

        nodo26.left = nodo3;
        nodo26.right = nodo41;
//nivel 3
        nodo32.left = nodo4;
        nodo32.right = nodo7;

        nodo41.right = nodo21;

        nodo41.left = nodo20;
        nodo41.right = nodo17;
//nivel 4
        nodo4.left = nodo31;
        nodo4.right = nodo3;

    }
}

/*
__|__
0 | 1
0 | 2
1 | 3
1 | 4
2 | 5
2 | 6
3 | 7
3 | 8
4 | 9
6 | 10
6 | 11
7 | 12
7 | 13
traverse
pre-order
In-oder recorrer por la izquierda
Post order recorrer por la derecha
 */
