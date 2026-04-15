class MaxHeap:
    def __init__(self):
        self.heap = []

    def push(self, val):
        self.heap.append(val)
        self._sift_up(len(self.heap) - 1)

    def _sift_up(self, i):
        # Fórmula del padre: (i - 1) // 2
        parent = (i - 1) // 2
        if i > 0 and self.heap[i] > self.heap[parent]:
            self.heap[i], self.heap[parent] = self.heap[parent], self.heap[i]
            self._sift_up(parent)

    def pop(self):
        if len(self.heap) == 0: return None
        if len(self.heap) == 1: return self.heap.pop()
        
        root = self.heap[0]
        self.heap[0] = self.heap.pop()
        self._sift_down(0)
        return root

    def _sift_down(self, i):
        # Fórmulas de hijos: 2i + 1 y 2i + 2
        left = 2 * i + 1
        right = 2 * i + 2
        largest = i

        if left < len(self.heap) and self.heap[left] > self.heap[largest]:
            largest = left
        if right < len(self.heap) and self.heap[right] > self.heap[largest]:
            largest = right
            
        if largest != i:
            self.heap[i], self.heap[largest] = self.heap[largest], self.heap[i]
            self._sift_down(largest)

# Ejemplo de uso con los datos de tu imagen
h = MaxHeap()
for x in [8, 4, 7, 3, 1, 4, 6, 2, 1, 1]:
    h.push(x)

print(f"Arreglo resultante: {h.heap}")

def main():
    # Aquí metemos la lógica principal
    h = MaxHeap()
    datos = [8, 4, 7, 3, 1, 4, 6, 2, 1, 1]
    for x in datos:
        h.push(x)
    print(f"Arreglo resultante: {h.heap}")

# Esta es la "llave de encendido" en Python
if __name__ == "__main__":
    main()