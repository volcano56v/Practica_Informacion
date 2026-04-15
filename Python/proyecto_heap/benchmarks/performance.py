import time
import random
import sys
import os
import statistics  # Necesario para calcular la mediana

# Agregamos la carpeta raíz del proyecto al "camino" de búsqueda de Python
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from src.heap_engine import GenericHeap

def benchmark():
    # 1. Definir al menos 6 tamaños de entrada
    tamanos = [1000, 5000, 10000, 25000, 50000, 100000]
    repeticiones = 20
    
    print(f"Iniciando Benchmark: {repeticiones} repeticiones por tamaño.")
    print(f"{'Tamaño':<10} | {'Mediana Heapify':<18} | {'Mediana Extract All':<20}")
    print("-" * 60)

    for n in tamanos:
        tiempos_heapify = []
        tiempos_extract = []

        for _ in range(repeticiones):
            # SEPARACIÓN DE I/O Y GENERACIÓN:
            # Generamos los datos antes de iniciar el cronómetro
            datos_base = [random.randint(0, 1000000) for _ in range(n)]
            
            # --- Medir Heapify ---
            start_h = time.time()
            h = GenericHeap(datos_base)
            end_h = time.time()
            tiempos_heapify.append(end_h - start_h)

            # --- Medir Extract All ---
            # No volvemos a generar datos, usamos el heap ya construido
            start_e = time.time()
            while h.heap:
                h.extract()
            end_e = time.time()
            tiempos_extract.append(end_e - start_e)

        # 2. Reportar MEDIANA por tamaño
        mediana_h = statistics.median(tiempos_heapify)
        mediana_e = statistics.median(tiempos_extract)

        print(f"{n:<10} | {mediana_h:>17.6f}s | {mediana_e:>19.6f}s")

if __name__ == "__main__":
    benchmark()