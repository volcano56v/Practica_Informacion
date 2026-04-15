package com.example.hechos_sin_refinar.algo_mas;

public class Main1 {
    public static void main(String[] args) {
        //para esto se podria hacer un menu
        System.out.println("--- INICIANDO VALIDACIÓN ---");
        SistemaAtencion sistema = new SistemaAtencion();

        sistema.registrarNormal("Cliente A");
        sistema.registrarNormal("Cliente B");
        sistema.registrarPrioritario("Cliente C (Prioridad)");
        
        sistema.atender();
        
        sistema.registrarNormal("Cliente D");
        sistema.cancelarUltimo();
        
        sistema.atender();
        sistema.atender();
        
        sistema.atender();
        sistema.cancelarUltimo(); 
    }
}