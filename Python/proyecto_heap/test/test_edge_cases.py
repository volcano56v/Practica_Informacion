import sys
import os

# Agregamos la carpeta raíz del proyecto al "camino" de búsqueda de Python
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from src.heap_engine import GenericHeap

def test_heap():
    # Caso 1: Heap Vacío
    h = GenericHeap([], "max")
    assert h.extract() is None, "Error en heap vacío"

    # Caso 2: Elementos Duplicados
    h = GenericHeap([5, 5, 5], "max")
    assert h.extract() == 5
    assert len(h.heap) == 2, "Error con duplicados"

    # Caso 3: Un solo elemento
    h = GenericHeap([10], "min")
    assert h.extract() == 10
    assert len(h.heap) == 0

    print("✅ Todos los tests de borde pasaron.")

if __name__ == "__main__":
    test_heap()