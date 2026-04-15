import time
import random
import sys
import os

# Agregamos la carpeta raíz del proyecto al "camino" de búsqueda de Python
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))
from src.heap_engine import GenericHeap

def benchmark():
    tamanos = [1000, 10000, 100000]
    print(f"{'Tamaño':<10} | {'Tiempo Heapify':<15} | {'Tiempo Extract All':<15}")
    print("-" * 50)

    for n in tamanos:
        datos = [random.randint(0, 1000000) for _ in range(n)]
        
        # Medir Heapify (Construcción)
        start = time.time()
        h = GenericHeap(datos)
        t_heapify = time.time() - start

        # Medir Extracción total (Ordenamiento)
        start = time.time()
        while h.heap:
            h.extract()
        t_extract = time.time() - start

        print(f"{n:<10} | {t_heapify:>14.4f}s | {t_extract:>14.4f}s")

if __name__ == "__main__":
    benchmark()