# Variables
poblacion_estudiantil = 500
tasa_aumento_estudiantes = 0.5
tasa_desercion = 0.1  # Supongamos que la tasa de deserción es del 10%

# Condiciones compuestas y anidadas
if poblacion_estudiantil < 1000:
    if tasa_aumento_estudiantes > 0.4:
        print("La población estudiantil es baja y la tasa de aumento es alta.")
        print("Se deben implementar medidas para aumentar la retención de estudiantes.")
    elif tasa_desercion > 0.1:
        print("La tasa de deserción es alta.")
        print("Se deben identificar las causas y tomar medidas para reducir la deserción.")
    else:
        print("La población estudiantil está dentro de los parámetros esperados.")
else:
    print("La población estudiantil es alta.")
    print("Se deben asegurar recursos suficientes para atender a todos los estudiantes.")
