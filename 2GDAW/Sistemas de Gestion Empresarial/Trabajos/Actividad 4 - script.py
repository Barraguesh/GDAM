import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import matplotlib

#Seleccionamos el estilo de gráfico
matplotlib.style.use('ggplot')

#Generamos colores aleatorios para cada columna
colors = matplotlib.rcParams['axes.prop_cycle'].by_key()['color']

#Cargamos los datos en un diccionario con las claves y valores correspondientes
data = {
    'Año': [2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023],
    'Mes': ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    'Ventas': [100, 522, 354, 643, 252, 634, 72, 845, 911, 301, 191, 912]
}

#Generamos el DataFrame de Pandas con el diccionario de datos
df = pd.DataFrame(data)

#Insertamos la leyenda en el DataFrame
pivot_df = df.pivot(index='Año', columns='Mes', values='Ventas')

#Cargamos los valores para el estilo del gráfico
pivot_df.loc[:, ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre']].plot.bar(stacked=True, color=colors, figsize=(10, 7))

#Mostramos el gráfico al usuario
plt.show()