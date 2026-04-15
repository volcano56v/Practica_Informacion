import heapq

# Datos iniciales
data = [8, 4, 7, 3, 1, 4, 6, 2, 1, 1]

# 1. Crear un Min-Heap (comportamiento por defecto)
min_heap = data.copy()
heapq.heapify(min_heap)
print(f"Min-Heap: {min_heap}")

# 2. Crear un Max-Heap (invirtiendo signos)
max_heap = [-x for x in data]
heapq.heapify(max_heap)

# Para recuperar el valor original al sacar elementos:
print("Valores del Max-Heap (al extraer):")
while max_heap:
    print(-heapq.heappop(max_heap), end=" ")