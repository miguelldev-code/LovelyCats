import matplotlib.pyplot as plt

# Puntos del circuito
posiciones = ['A', 'Después R1', 'Después R2', 'Después R3', 'Después R4']
voltajes = [16, 15.24704, 11.01164, 10.3528, 8]

# Crear la gráfica
plt.figure(figsize=(10, 5))
plt.plot(posiciones, voltajes, marker='o')

# Añadir títulos y etiquetas
plt.title('Aumento y Caídas del Potencial en el Circuito')
plt.xlabel('Posición en el Circuito')
plt.ylabel('Voltaje (V)')
plt.grid(True)

# Mostrar los valores de voltaje en los puntos
for i, txt in enumerate(voltajes):
    plt.annotate(f'{txt:.2f}V', (posiciones[i], voltajes[i]), textcoords="offset points", xytext=(0,10), ha='center')

# Mostrar la gráfica
plt.show()
