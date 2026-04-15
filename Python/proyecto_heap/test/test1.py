import unittest
import sys
import os

# Parche para encontrar el módulo src
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from src.heap_engine import GenericHeap

class TestHeapManual(unittest.TestCase):
    
    # Este método se corre ANTES de cada test (ideal para limpiar datos)
    def setUp(self):
        self.data_nums = [1, 10, 5]
        self.data_text = ["b", "z", "a"]

    def test_max_heap_numeric(self):
        h = GenericHeap(self.data_nums, mode="max")
        # En unittest no usas "assert x == y", usas:
        self.assertEqual(h.peek(), 10)
        self.assertEqual(len(h.heap), 3)

    def test_min_heap_text(self):
        h = GenericHeap(self.data_text, mode="min")
        self.assertEqual(h.peek(), "a")
        
    def test_empty_extraction(self):
        h = GenericHeap([], "max")
        self.assertIsNone(h.extract())

if __name__ == "__main__":
    unittest.main()