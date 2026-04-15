import pytest
from src.heap_engine import GenericHeap

# Una fixture prepara el escenario para los tests
@pytest.fixture
def max_heap_numerico():
    return GenericHeap([1, 10, 5], mode="max")

@pytest.fixture
def min_heap_texto():
    return GenericHeap(["b", "z", "a"], mode="min")

# Los tests son simples funciones. Pytest les pasa las fixtures por nombre.
def test_max_heap_logic(max_heap_numerico):
    # Usamos el assert estándar de Python (¡más fácil!)
    assert max_heap_numerico.peek() == 10
    assert len(max_heap_numerico.heap) == 3

def test_min_heap_logic(min_heap_texto):
    assert min_heap_texto.peek() == "a"
    assert min_heap_texto.extract() == "a"
    assert min_heap_texto.peek() == "b"

def test_edge_empty():
    h = GenericHeap([], "max")
    assert h.extract() is None