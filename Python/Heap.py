import random
import string

class Heap:
    def __init__(self, mode="min"):
        self.heap = []
        self.mode = mode # Puede ser "min" o "max"

    def _compare(self, val1, val2):
        if self.mode == "min":
            return val1 < val2
        return val1 > val2

    def push(self, val):
        self.heap.append(val)
        self._sift_up(len(self.heap) - 1)

    def _sift_up(self, i):
        parent = (i - 1) // 2
        if i > 0 and self._compare(self.heap[i], self.heap[parent]):
            self.heap[i], self.heap[parent] = self.heap[parent], self.heap[i]
            self._sift_up(parent)

def main():
    # Generar 8 palabras aleatorias de 3 letras
    datos_texto = [''.join(random.choices(string.ascii_lowercase, k=3)) for _ in range(8)]
    
    print(f"Datos originales: {datos_texto}")
    
    # Probamos Max-Heap (la palabra 'mayor' alfabéticamente arriba)
    mi_heap = Heap(mode="max")
    for palabra in datos_texto:
        mi_heap.push(palabra)
    
    print(f"Arreglo (Max-Heap): {mi_heap.heap}")
    print(f"Raíz (Palabra mayor): {mi_heap.heap[0]}")

if __name__ == "__main__":
    main()