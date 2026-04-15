import random
import string
from heap_engine import GenericHeap

# --- UTILIDADES DE GENERACIÓN ---

def generar_datos(tipo="int", n=0):
    if tipo == "int":
        return [random.randint(1, 99) for _ in range(n)]
    return [''.join(random.choices(string.ascii_uppercase, k=3)) for _ in range(n)]

# --- VISUALIZACIÓN ---

def mostrar_arbol(heap, i=0, level=0):
    """Imprime el montículo de forma visual (rotado 90 grados)"""
    if i < len(heap):
        # Primero procesamos el lado derecho (arriba en la terminal)
        mostrar_arbol(heap, 2 * i + 2, level + 1)
        
        # Imprimimos el nodo con indentación proporcional al nivel
        print('       ' * level + f"({i})[ {heap[i]} ]")
        
        # Luego el lado izquierdo (abajo en la terminal)
        mostrar_arbol(heap, 2 * i + 1, level + 1)

# --- LÓGICA DE PRUEBA ---

def probar_tipo(nombre, datos):
    print(f"\n{'='*20} PRUEBA: {nombre} {'='*20}")
    print(f"Datos base: {datos}\n")

    for modo in ["min", "max"]:
        print(f"--- MODO: {modo.upper()} ---")
        h = GenericHeap(datos, mode=modo)
        mostrar_arbol(h.heap)
        print(f"Raíz: {h.peek()}\n")
    print("-" * 55)

def run_example():
    while True:
        try:
            # Pedimos el número y lo convertimos a entero de inmediato
            n = int(input("¿Cuántos elementos quieres generar para las pruebas?: "))
            
            if n <= 0:
                print("Por favor, ingresa un número mayor a 0.")
                continue
                
            break  # Salimos del bucle si todo salió bien
        except ValueError:
            # Esto se ejecuta si el usuario escribe letras en lugar de números
            print("Error: Debes ingresar un número entero (ej: 10).")

    # Ejecución de las pruebas con el número 'n' validado
    probar_tipo("NÚMEROS", generar_datos("int", n))
    probar_tipo("TEXTO", generar_datos("str", n))

if __name__ == "__main__":
    run_example()