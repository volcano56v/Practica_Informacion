package com.example.hechos_sin_refinar.algo_mas;

class MiDeque<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamano;

    public MiDeque() {
        primero = null;
        ultimo = null;
        tamano = 0;
    }

    public void addFirst(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
        } else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
        tamano++;
    }

    public void addLast(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        tamano++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("El Deque está vacío");
        T dato = primero.dato;
        primero = primero.siguiente;
        if (primero == null) ultimo = null;
        else primero.anterior = null;
        tamano--;
        return dato;
    }

    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("El Deque está vacío");
        T dato = ultimo.dato;
        ultimo = ultimo.anterior;
        if (ultimo == null) primero = null;
        else ultimo.siguiente = null;
        tamano--;
        return dato;
    }

    public T peekFirst() {
        if (isEmpty()) throw new IllegalStateException("El Deque está vacío");
        return primero.dato;
    }

    public T peekLast() {
        if (isEmpty()) throw new IllegalStateException("El Deque está vacío");
        return ultimo.dato;
    }

    public boolean isEmpty() {
        return tamano == 0;
    }

    public int size() {
        return tamano;
    }
}