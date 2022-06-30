# -*- coding: utf-8 -*-
"""
Created on Sat May  7 12:47:10 2022

@author: Bryan Biojó
"""

def CDT(usuario: str, capital: int, tiempo: int):
    valor_total = capital - (capital * 0.02) if tiempo <= 2 else capital + ((capital * 0.03 * tiempo) / 12)
    mensaje = f"Para el usuario {usuario} La cantidad de dinero a recibir, según el monto inicial {capital} para un tiempo de {tiempo} meses es: {valor_total}"     
    
    return mensaje

# PRUEBAS
print(CDT("AB1012", 1000000, 3))
print(CDT("ER3366", 650000, 2))
