# guia06
Problema GUIA 06

Deberá modelar el caso de una organización que brinda carreras de capacitación a alumnos a través de cursos a los cuales los alumnos se pueden inscribir si cumplen con las situaciones previstas.
De cada Curso se guarda un valor numérico como Identificador (id), el nombre y el ciclo lectivo. Además cada curso conoce la cantidad de créditos que otorga a quienes lo aprueban. Por otra parte cada curso tiene una cantidad de créditos mínimo que el alumno tiene que haber obtenido (aprobando otros cursos) para poder inscribirse. Algunos cursos no requieren créditos mínimos para inscribirse por lo que dicho valor es de cero (0). Además todo curso tiene un cupo, y cuando el mismo es alcanzado no se pueden inscribir más alumnos.
Por otra parte de los métodos que se espera que pueda resolver un curso son:
-	Inscribir un alumno: Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso, y además agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna el valor booleano verdadero. En caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista de cursos en los que el alumno está inscripto. Para poder inscribirse un alumno debe
o	a) tener como mínimo los créditos necesarios
o	b) el curso debe tener cupo disponibles
o	c) un alumno puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
-	Imprimir un curso: se debe poder imprimir el listado de inscriptos ordenados alfabéticamente, por numero de libreta universitaria, o por cantidad de créditos obtenidos.
Además en cada método de la clase curso “registrar” se invoca a una clase que deja registros de auditoria en un archivo del sistema operativo.

A su vez el alumno se modela como una clase que tiene los atributos nombre y nro de libreta universitaria. A su vez cada alumno una vez que le es aceptada la inscripción a un curso, se le agrega dicho curso a su lista de cursos que está cursando. Por otro lado, cada vez que aprueba un curso, se quita el curso de la lista de cursos que está cursando y se agrega a la lista de cursos aprobados.
El comportamiento minimo esperado para la clase alumno es:
-	Poder determinar la cantidad de créditos que posee (esto se determina como la suma de los créditos que otorgan los cursos que ya aprobó).
-	Poder registrar que se inscribe a un curso.
-	Poder registrar que aprobó un curso (y ya no está cursando)
