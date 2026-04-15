import heapq
import random
import string

# Clase para "engañar" a heapq y que funcione como Max-Heap con texto
class MaxText:
    def __init__(self, val): self.val = val
    def __lt__(self, other): return self.val > other.val # Invierte el '<'
    def __repr__(self): return self.val

def main():
    # Generar datos aleatorios
    datos = [''.join(random.choices(string.ascii_uppercase, k=3)) for _ in range(8)]
    print(f"Palabras generadas: {datos}")

    # --- MIN-HEAP (Por defecto) ---
    min_h = datos.copy()
    heapq.heapify(min_h)
    print(f"Min-Heap (Orden diccionario): {min_h}")

    # --- MAX-HEAP (Usando el envoltorio) ---
    max_h = [MaxText(x) for x in datos]
    heapq.heapify(max_h)
    print(f"Max-Heap (Inverso): {max_h}")
    
    # El último nodo no-hoja (según tu imagen) sería:
    idx_last_non_leaf = (len(max_h) - 2) // 2
    print(f"Último nodo no-hoja en índice: {idx_last_non_leaf}")

if __name__ == "__main__":
    main()