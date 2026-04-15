import random
import string

class MaxHeap:
    def __init__(self):
        self.heap = []

    def push(self, val):
        self.heap.append(val)
        self._sift_up(len(self.heap) - 1)

    def _sift_up(self, i):
        parent = (i - 1) // 2
        if i > 0 and self.heap[i] > self.heap[parent]:
            self.heap[i], self.heap[parent] = self.heap[parent], self.heap[i]
            self._sift_up(parent)

    def show(self, index=0, level=0):
        # Si el índice está fuera del arreglo, no imprimimos nada
        if index < len(self.heap):
            # 1. Intentar ir al hijo derecho (2i + 2)
            self.show(2 * index + 2, level + 1)
            
            # 2. Imprimir el nodo actual con sangría
            print('       ' * level + f"-> {self.heap[index]}")
            
            # 3. Intentar ir al hijo izquierdo (2i + 1)
            self.show(2 * index + 1, level + 1)

def main():
    h = MaxHeap()
    # Generamos 7 textos aleatorios de 2 letras
    datos = [''.join(random.choices(string.ascii_uppercase, k=2)) for _ in range(7)]
    
    print(f"Insertando: {datos}\n")
    for d in datos:
        h.push(d)
    
    print("ESTRUCTURA DEL MAX-HEAP (Rotada 90°):")
    print("-" * 30)
    h.show()
    print("-" * 30)

if __name__ == "__main__":
    main()