# -*- coding: utf-8 -*-
"""
Created on Wed May  11 23:53:23 2022

@author: Bryan Biojó
"""

def cliente(informacion: dict) -> dict:
    nombre = informacion['nombre']; edad = informacion['edad']; primer_ingreso = informacion['primer_ingreso']; apto = True;
    
    if edad >= 7 and edad < 15:
        atraccion = 'Sillas voladoras'; total_boleta = 10000 * (1 - 0.05) if primer_ingreso else 10000

    elif edad >= 15 and edad <= 18:
        atraccion = 'Carros chocones'; total_boleta = 5000 * (1 - 0.07) if primer_ingreso else 5000

    elif edad > 18:
        atraccion = 'X-Treme'; total_boleta = 20000 * (1 - 0.05) if primer_ingreso else 20000

    else:
        apto = False; atraccion = 'N/A'; total_boleta = 'N/A'

    info = {"nombre": nombre, "edad": edad, "atraccion": atraccion, "apto": apto, "primer_ingreso": primer_ingreso, "total_boleta": total_boleta}

    return info

# PRUEBAS
info1 = {'id_cliente': 1, 'nombre': 'Jhoana Fernandez', 'edad': 20, 'primer_ingreso': True}
info2 = {'id_cliente': 1, 'nombre': 'Jhoana Fernandez', 'edad': 20, 'primer_ingreso': False}
info3 = {'id_cliente': 2, 'nombre': 'Gloria Suarez', 'edad': 3, 'primer_ingreso': True}
info4 = {'id_cliente': 3, 'nombre': 'Tatiana Suarez', 'edad': 17, 'primer_ingreso': True}
info5 = {'id_cliente': 3, 'nombre': 'Tatiana Suarez', 'edad': 17, 'primer_ingreso': False}
info6 = {'id_cliente': 4, 'nombre': 'Tatiana Ruiz', 'edad': 8, 'primer_ingreso': True}
info7 = {'id_cliente': 4, 'nombre': 'Tatiana Ruiz', 'edad': 8, 'primer_ingreso': False}

print(cliente(info1)); print(cliente(info2)); print(cliente(info3)); print(cliente(info4)); print(cliente(info5)); print(cliente(info6)); print(cliente(info7))






