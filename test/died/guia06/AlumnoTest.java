package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AlumnoTest {

	ArrayList<Alumno> vaciaAlumnos = new ArrayList<>();
	Curso matematica = new Curso(1,"Matemática",2,3,vaciaAlumnos,20,0);
	ArrayList<Curso> vacia = new ArrayList<>();
	ArrayList<Curso> llena = new ArrayList<>();



	@Test
	void testCreditosObtenidos() {
		llena.add(matematica);
		Alumno alumno = new Alumno("Manuel", 1234,vacia, llena);
		Integer obtenido = alumno.creditosObtenidos();
		Integer esperado = 20;
		assertEquals(esperado,obtenido);
	}

	@Test
	void testAprobar() {
		llena.add(matematica);
		Alumno alumno = new Alumno("Manuel", 1234,llena,vacia);
		alumno.aprobar(matematica);
		assertTrue(alumno.getAprobados().contains(matematica) && !alumno.getCursando().contains(matematica));
	}

	@Test
	void testInscripcionAceptada() {
		llena.add(matematica);
		Curso matematica2 = new Curso(2,"Matemática 02",1,3,vaciaAlumnos,20,20);
		Alumno alumno = new Alumno("Manuel", 1234,vacia, llena);
		alumno.inscripcionAceptada(matematica2);
		assertTrue(alumno.getCursando().contains(matematica2));
	}

	@Test
	void testInscripcionRechazada() {
		llena.add(matematica);
		Curso matematica3 = new Curso(2,"Matemática 02",1,3,vaciaAlumnos,20,40);
		Alumno alumno = new Alumno("Manuel", 1234,vacia, llena);
		alumno.inscripcionAceptada(matematica3);
		assertFalse(alumno.getCursando().contains(matematica3));
	}

}
