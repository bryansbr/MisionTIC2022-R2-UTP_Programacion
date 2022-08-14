# -*- coding: utf-8 -*-
"""
Created on Sun Jun  12 04:18:10 2022

@author: Bryan Biojó
"""

import pandas as pd
from os.path import splitext

rutaFileCsv = 'https://raw.githubusercontent.com/luisguillermomolero/MisionTIC2022_2/master/Modulo1_Python_MisionTIC2022_Main/Semana_5/Reto/movies.csv'

def listaPeliculas(rutaFileCsv: str) -> str:
    extension = splitext(rutaFileCsv)[1]
    
    if extension == '.csv':
        try:
            datos = pd.read_csv(rutaFileCsv)
            datos_finales = (pd.pivot_table(datos, index= ['Country', 'Language'], values= 'Gross Earnings')).head(10)
            return datos_finales
        except:
            return 'Error al leer el archivo de datos.'
    else:
        print('Extensión inválida.')

print(listaPeliculas(rutaFileCsv))