package died.guia06;

import died.guia06.excepciones.AlumnoSobrecargadoException;
import died.guia06.excepciones.CreditosInsuficientesException;
import died.guia06.excepciones.CupoCompletoException;

public class App {

	public static void main(String[] args) {
		Alumno[] alumnos = {
				new Alumno ("Luciano", 1),
				new Alumno ("Yunuen", 2),
				new Alumno ("Gabor", 3),
				new Alumno ("Sol", 4),
		};

		Curso[] cursos = {

				//Cursos de primer cuatrimestre
				new Curso (1,"Matemática Discreta",2,3,0),
				new Curso (2,"Análisis Matemático 1",2,3,0),
				new Curso (3,"Álgebra y Geometría Analítica",2,3,0),
				new Curso (4,"Ingeniería y Sociedad",2,3,0),

				//Cursos de segundo cuatrimestre
				new Curso (5,"Algoritmos y Estructuras de Datos",2,2,6),
				new Curso (6,"Física 1",2,2,6),
				new Curso (7,"Sistemas y Organizaciones",3,2,3),
				new Curso (8,"Análisis de Sistemas",2,2,3)
		};


		// Los alumnos se inscriben a los cursos del primer cuatrimestre.
		// Luciano y Yunuen llegan a inscribirse a Matemática Discreta, Análisis Matemático1 y Álgebra y Geometría Ananlítica
		// Gabor y Sol solo llegan a inscribirse a Ingeniería y Sociedad.

		System.out.println("Inscribiendo a los alumnos a los cursos del primer cuatrimestre:");
		System.out.println("");
		for(int i=0; i < 4; i++){
			for(int j=0; j < 4; j++){
				try {
					cursos[i].inscribirAlumno(alumnos[j]);
				}
				catch(AlumnoSobrecargadoException e){
					System.out.println(e.getMessage());
				}
				catch (CreditosInsuficientesException e){
					System.out.println(e.getMessage());
				}
				catch(CupoCompletoException e){
					System.out.println(e.getMessage());
				}
				catch (Exception e){
					System.out.println("Tiró una excepción que no me esperaba");
				}
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		// Luciano y Yunuen aprueban Matemática Discreta, Análisis Matemático1 y Álgebra y Geometría Ananlítica
		// Gabor y Sol aprueban  a Ingeniería y Sociedad.
		System.out.println("Los alumnos aprueban los cursos del primer cuatrimestre");
		for(int i=0; i < 4; i++){
			for(int j=0; j < 4; j++) {
				alumnos[j].aprobar(cursos[i]);
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");


		//Se imprimen los créditos de los alumnos
		System.out.println("Se muestra cuantos créditos tiene cada alumno:");
		for(int i=0; i < 4; i++) {
			System.out.println("El alumno " + alumnos[i].getNombre() + " tiene " + alumnos[i].creditosObtenidos() + " créditos");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");


		//Los alumnos se inscriben a los cursos del segundo cuatrimestre.
		//Luciano y Yunuen se logran inscribir a Algoritmos y Estructuras de Datos, Física 1 y Sistemas y Organizaciones
		// Gabor se logra inscribir a Sistemas y Organizaciones y Análisis de Sistemas
		// Sol se logra inscribir a Análisis de Sistemas
		System.out.println("Inscribiendo a los alumnos a los cursos del segundo cuatrimestre:");
		for(int i=4; i < 8; i++){
			for(int j=0; j < 4; j++){
				try {
					cursos[i].inscribirAlumno(alumnos[j]);
				}
				catch(AlumnoSobrecargadoException e){
					System.out.println(e.getMessage());
				}
				catch (CreditosInsuficientesException e){
					System.out.println(e.getMessage());
				}
				catch(CupoCompletoException e){
					System.out.println(e.getMessage());
				}
				catch (Exception e){
					System.out.println("Tiró una excepción que no me esperaba");
				}
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");


		//Se muestran las materias que los alumnos aprobaron
		for(int i=0; i < 4; i++){
			System.out.println("El alumno "+ alumnos[i].getNombre() + " aprobó las materias:");
			for(int j=0; j < alumnos[i].getAprobados().size(); j++){
				System.out.println(alumnos[i].getAprobados().get(j).getNombre());
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");


		//Se muestran las materias que los alumnos están cursando
		for(int i=0; i < 4; i++){
			System.out.println("El alumno "+ alumnos[i].getNombre() + " está cursando las materias:");
			for(int j=0; j < alumnos[i].getCursando().size(); j++){
				System.out.println(alumnos[i].getCursando().get(j).getNombre());
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");


	}
}
