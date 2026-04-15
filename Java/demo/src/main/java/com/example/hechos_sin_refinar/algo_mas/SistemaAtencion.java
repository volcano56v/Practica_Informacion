package com.example.hechos_sin_refinar.algo_mas;

class SistemaAtencion {
    private MiDeque<String> fila;

    public SistemaAtencion() {
        fila = new MiDeque<>();
    }

    public void registrarNormal(String cliente) {
        fila.addLast(cliente);
        System.out.println("Normal registrado: " + cliente);
    }

    public void registrarPrioritario(String cliente) {
        fila.addFirst(cliente);
        System.out.println("Prioritario registrado: " + cliente);
    }

    public void atender() {
        if (!fila.isEmpty()) {
            System.out.println("Atendiendo a: " + fila.removeFirst());
        } else {
            System.out.println("No hay clientes por atender.");
        }
    }

    public void cancelarUltimo() {
        if (!fila.isEmpty()) {
            System.out.println("Se canceló la atención de: " + fila.removeLast());
        } else {
            System.out.println("No hay clientes para cancelar.");
        }
    }
}