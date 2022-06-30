# -*- coding: utf-8 -*-
"""
Created on Sun Jun  5 00:36:10 2022

@author: Bryan Biojó
"""

from functools import reduce

def ordenes(rutinaContable):
    print('------------------------ Inicio Registro diario ---------------------------------')
    mensaje = ''
    lista_mult = list(map(lambda x: [x[0]] + list(map(lambda y: y[1] * y[2], x[1:])), rutinaContable))
    lista_reducida = list(map(lambda x: [x[0]] + [reduce(lambda i, j: i + j, x[1:])], lista_mult))

    for elem in lista_reducida:
        num_factura = elem[0]; total = elem[1]
        if total <= 600000: total += 25000
        mensaje += f'La factura {num_factura} tiene un total en pesos de {total:,.2f} \n'
    
    return print(f'{mensaje} -------------------------- Fin Registro diario ----------------------------------')

# PRUEBAS
rutinaContable = [
    [1201, ("5464", 4, 25842.99), ("7854", 18, 23254.99), ("8521", 9, 48951.95)],
    [1202, ("8756", 3, 115362.58), ("1112", 18, 2354.99)],
    [1203, ("2547", 1, 125698.20), ("2635", 2, 135645.20),
     ("1254", 1, 13645.20), ("9965", 5, 1645.20)],
    [1204, ("9635", 7, 11.99), ("7733", 11, 18.99), ("88112", 5, 390.95)]
]
ordenes(rutinaContable)