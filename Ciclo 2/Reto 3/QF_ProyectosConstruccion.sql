/*  AUTOR: Bryan Biojó
 *  1) Obtener el listado de los identificadores (id) de los materiales de construcción 
 *     importados, incluyendo: sus nombres y precios (ordenados por nombre). Utilice los 
 *     siguientes alias: ID_MATERIALCONSTRUCCION como ID, NOMBRE_MATERIAL como NOMBRE 
 *     y PRECIO_UNIDAD como PRECIO.
 */

SELECT
	ID_MaterialConstruccion as ID,
	Nombre_Material as NOMBRE,
	Precio_Unidad as PRECIO
FROM
	MaterialConstruccion
WHERE
	Importado = 'Si'
ORDER BY
	NOMBRE;


/*  AUTOR: Bryan Biojó
 *  2) Se necesita conocer el listado de los proyectos, incluyendo la siguiente información:
 *     id del proyecto, constructora, ciudad, clasificación, estrato y nombre completo del 
 *     líder de los proyectos que fueron financiados por el banco “Conavi”. Ordenados desde 
 *     el proyecto más reciente hasta el más antiguo, por nombre de la ciudad (de forma ascendente) 
 *     y por constructora. Para construir el listado mencionado, se debe realizar un JOIN entre las 
 *     tablas Proyecto y Tipo y, Proyecto y Líder. Utilice los siguientes alias: ID_PROYECTO como ID 
 *     y la unión del nombre + apellido del líder como LIDER, el resto, queda en su forma natural.
 */

SELECT
	p.ID_Proyecto AS ID,
	p.Constructora,
	p.Ciudad,
	p.Clasificacion,
	t.Estrato,
	l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER
FROM
	Proyecto p
INNER JOIN Tipo t ON
	(p.ID_Tipo = t.ID_Tipo)
INNER JOIN Lider l ON
	(p.ID_Lider = l.ID_Lider)
WHERE
	p.Banco_Vinculado = 'Conavi'
ORDER BY
	Fecha_Inicio DESC,
	Ciudad,
	Constructora;


/* AUTOR: Bryan Biojó
 * 3) Se desea conocer por cada ciudad y clasificación: el total de proyectos, la fecha del proyecto 
 *    más antiguo y la fecha del proyecto más reciente (ordenados por ciudad y clasificación). No se 
 *    deben incluir los proyectos tipo "Casa Campestre" ni "Condominio".
 */

SELECT
	Ciudad,
	Clasificacion,
	COUNT(*) AS TOTAL,
	MIN(Fecha_Inicio) AS VIEJO,
	MAX(Fecha_Inicio) AS RECIENTE
FROM
	Proyecto
WHERE
	Clasificacion NOT IN('Casa Campestre', 'Condominio')
GROUP BY
	Ciudad,
	Clasificacion
ORDER BY
	Ciudad,
	Clasificacion;


/* AUTOR: Bryan Biojó
 * 4) Se debe presentar el total adeudado en cada proyecto (por las compras no pagadas a los proveedores). 
 *    Se debe agrupar los datos por el ID_proyecto y el valor total de la deuda, siempre y cuando esta 
 *    última sea superior a $50.000. Ordene los datos de mayor a menor deuda.
 */

SELECT
	c.ID_Proyecto,
	SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR
FROM
	Compra c
INNER JOIN MaterialConstruccion mc ON
	(c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)
WHERE
	c.Pagado = 'No'
GROUP BY
	ID_Proyecto
HAVING
	VALOR > 50000
ORDER BY
	VALOR DESC;


/* AUTOR: Bryan Biojó
 * 5) Seleccione los 10 líderes que han realizado más compras en sus proyectos. Se debe presentar el 
 *    nombre completo del líder y el valor total de las compras realizadas. Para limitar el número de 
 *    registros, usar al final de la consulta la instrucción LIMIT <numero>.
 */ 

SELECT
	l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER,
	SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR
FROM
	Proyecto p
INNER JOIN Lider l ON
	(p.ID_Lider = l.ID_Lider)
INNER JOIN Compra c ON
	(p.ID_Proyecto = c.ID_Proyecto)
INNER JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)
GROUP BY LIDER
ORDER BY VALOR DESC
LIMIT 10;



-- CONSULTA 2
SELECT p.ID_Proyecto AS ID, p.Constructora, p.Ciudad, p.Clasificacion, t.Estrato, l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER
FROM Proyecto p
INNER JOIN Tipo t ON (p.ID_Tipo = t.ID_Tipo)
INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider)
WHERE p.Banco_Vinculado = 'Conavi'
ORDER BY Fecha_Inicio DESC, Ciudad, Constructora;

-- CONSULTA 4
SELECT c.ID_Proyecto, SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR
FROM Compra c
INNER JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)
WHERE c.Pagado = 'No'
GROUP BY ID_Proyecto
HAVING VALOR > 50000
ORDER BY VALOR DESC;

-- CONSULTA 5
SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido AS LIDER, SUM(mc.Precio_Unidad * c.Cantidad) AS VALOR
FROM Proyecto p
INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider)
INNER JOIN Compra c ON (p.ID_Proyecto = c.ID_Proyecto)
INNER JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion)
GROUP BY LIDER
ORDER BY VALOR DESC
LIMIT 10;