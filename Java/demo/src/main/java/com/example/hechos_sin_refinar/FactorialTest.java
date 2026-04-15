package com.example.hechos_sin_refinar;

import java.math.BigInteger;
import java.util.logging.Logger;

public class FactorialTest {
    private static final Logger logger = Logger.getLogger(FactorialTest.class.getName());

    public static BigInteger factorialLineal(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger factorialRecursivo(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialRecursivo(n - 1));
    }

    public static void main(String[] args) {
        int[] casosDePrueba = {10, 100, 1000, 5000, 10000};
        for (int n : casosDePrueba) {
            logger.info("--- Midiendo n = " + n + " ---");

            long inicioLineal = System.nanoTime();
            factorialLineal(n);
            long finLineal = System.nanoTime();
            double segundosLineal = (finLineal - inicioLineal) / 1_000_000_000.0;
            logger.info(String.format("Lineal    - Tiempo: %.6f segundos", segundosLineal));

            try {
                long inicioRecursivo = System.nanoTime();
                factorialRecursivo(n);
                long finRecursivo = System.nanoTime();
                double segundosRecursivo = (finRecursivo - inicioRecursivo) / 1_000_000_000.0;
                logger.info(String.format("Recursivo - Tiempo: %.6f segundos", segundosRecursivo));
            } catch (StackOverflowError e) {
                logger.severe("Recursivo - Error: Stack Overflow para n = " + n);
            }
        }
    }
}
