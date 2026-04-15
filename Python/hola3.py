import heapq
import random
import string

def print_sideways(heap, i=0, level=0):
    if i < len(heap):
        # Derecha
        print_sideways(heap, 2 * i + 2, level + 1)
        # Nodo
        print('       ' * level + f"[{i}] {heap[i]}")
        # Izquierda
        print_sideways(heap, 2 * i + 1, level + 1)

def main():
    # Datos aleatorios
    data = [''.join(random.choices(string.ascii_lowercase, k=2)) for _ in range(7)]
    
    # Convertir la lista en un Min-Heap
    heapq.heapify(data)
    
    print(f"Lista interna de heapq: {data}\n")
    print("VISUALIZACIÓN HORIZONTAL (Raíz a la izquierda):")
    print("=" * 40)
    print_sideways(data)
    print("=" * 40)
    print("\n* Lee de izquierda a derecha. El de más a la izquierda es la RAÍZ.")

if __name__ == "__main__":
    main()