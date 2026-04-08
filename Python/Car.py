class Auto:

    def __init__(self, velocidad=0):
        self.velocidad = velocidad
        self.cuentaKilometros = 0
        self.tiempo = 0

    def acelerar(self):
        self.velocidad += 5

    def frenar(self):
        self.velocidad -= 5

    def step(self):
        self.cuentaKilometros += self.velocidad
        self.tiempo += 1

    def promedio_De_Velocidad(self):
        return self.cuentaKilometros / self.tiempo


if __name__ == '__main__':

    mi_auto = Auto()
    print("Estoy en un auto!")
    while True:
        action = input("Que Deberia hacer? [A]celerar, [F]renar, "
                        "mostrar [C]uentaKilometros, o mostrar promedio de [V]elocidad?").upper()
        if action not in "ABCV" or len(action) != 1:
            print("I don't know how to do that")
            continue
        if action == 'A':
            mi_auto.acelerar()
            print("Acelerando...")
        elif action == 'B':
            mi_auto.frenar()
            print("Frenando...")
        elif action == 'C':
            print("El auto a conducido {} kilometeros".format(mi_auto.odometer))
        elif action == 'V':
            print("El velocidad  promedio del auto es {} kph".format(mi_auto.promedio_De_Velocidad()))
        mi_auto.step()