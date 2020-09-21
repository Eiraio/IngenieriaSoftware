package died.guia06;

import died.guia06.excepciones.AlumnoSobrecargadoException;
import died.guia06.excepciones.CreditosInsuficientesException;
import died.guia06.excepciones.CupoCompletoException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {

    ArrayList<Alumno> vaciaAlumnos = new ArrayList<>();
    Curso matematica = new Curso(1,"Matemática",2,3,vaciaAlumnos,20,0);
    ArrayList<Curso> vacia = new ArrayList<>();
    ArrayList<Curso> llena = new ArrayList<>();

    @Test
    void inscribirPositivoTest() {
        llena.add(matematica);
        Alumno alumno = new Alumno("Francisco", "Giancarelli",1234,vacia, llena);
        Curso matematica2 = new Curso(2,"Matemática 02",1,3,vaciaAlumnos,20,20);
        Boolean retorna = matematica2.inscribir(alumno);
        assertTrue(matematica2.getInscriptos().contains(alumno) && alumno.getCursando().contains(matematica2) && retorna);
    }

    @Test
    void inscribirNegativoTest() {
        llena.add(matematica);
        Alumno alumno = new Alumno("Francisco", "Giancarelli", 1234,vacia, llena);
        Curso matematica3 = new Curso(2,"Matemática 02",1,3,vaciaAlumnos,20,40);
        Boolean retorna = matematica3.inscribir(alumno);
        assertFalse(matematica3.getInscriptos().contains(alumno) || alumno.getCursando().contains(matematica3) || retorna);


    }

    @Test
    void imprimirInscriptosAlfabeticamenteTest() {
        Alumno alumno1 = new Alumno("Francisco", "Giancarelli", 3,vacia, llena);
        Alumno alumno2 = new Alumno("María","Magdalena",4,vacia, llena);
        Alumno alumno3 = new Alumno("Juan","Perez", 2,vacia, llena);

        matematica.inscribir(alumno1);
        matematica.inscribir(alumno2);
        matematica.inscribir(alumno3);

        matematica.imprimirInscriptosAlfabeticamente();

    }

    @Test
    void imprimirInscriptosNroLibretaTest() {
        Alumno alumno1 = new Alumno("Francisco", "Giancarelli", 3,vacia, llena);
        Alumno alumno2 = new Alumno("María","Magdalena", 4,vacia, llena);
        Alumno alumno3 = new Alumno("Juan","Perez",  2,vacia, llena);

        matematica.inscribir(alumno1);
        matematica.inscribir(alumno2);
        matematica.inscribir(alumno3);

        matematica.imprimirInscriptosNroLibreta();
    }


    @Test
    void imprimirInscriptosCreditosTest() {

        Curso lengua = new Curso(4,"Lengua",2,3,vaciaAlumnos,10,0);
        Curso ciencias = new Curso(5,"Ciencias",2,3,vaciaAlumnos,30,0);

        Alumno alumno1 = new Alumno("Francisco", "Giancarelli", 3,vacia, llena);
        ArrayList<Curso> llena2 = new ArrayList<>();
        llena2.add(lengua);
        llena2.add(matematica);
        Alumno alumno2 = new Alumno("María","Magdalena", 4,vacia, llena2);
        ArrayList<Curso> llena3 = new ArrayList<>();
        llena3.add(lengua);
        llena3.add(matematica);
        llena3.add(ciencias);
        Alumno alumno3 = new Alumno("Juan","Perez",2,vacia, llena3);

        matematica.inscribir(alumno1);
        matematica.inscribir(alumno3);
        matematica.inscribir(alumno2);

        matematica.imprimirInscriptosCreditos();
    }

    @Test
    void inscribirAlumnoAceptadoTest(){
        Alumno alumno = new Alumno("Facundo","Velazco", 1234,vacia, llena);
        Curso lengua = new Curso(4,"Lengua",2,3,vaciaAlumnos,10,0);
        try{
            lengua.inscribirAlumno(alumno);
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
        assertTrue(lengua.getInscriptos().contains(alumno) && alumno.getCursando().contains(lengua));
    }

    @Test
    void inscribirAlumnoRechazadoPorCreditosTest(){
        Alumno alumno = new Alumno("Facundo","Velazco", 1234,vacia, llena);
        Curso lengua = new Curso(4,"Lengua",2,3,vaciaAlumnos,10,50);
        try{
            lengua.inscribirAlumno(alumno);
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
        assertFalse(lengua.getInscriptos().contains(alumno) || alumno.getCursando().contains(lengua));
    }

    @Test
    void inscribirAlumnoRechazadoPorCupoTest(){
        Alumno alumno = new Alumno("Facundo", "Velazco", 1234,vacia, llena);
        vaciaAlumnos.add(new Alumno("Pepe","Marcial",02));
        vaciaAlumnos.add(new Alumno("Juan","Perez",03));
        vaciaAlumnos.add(new Alumno("Gorge","Lucas",04));
        Curso lengua = new Curso(4,"Lengua",2,3,vaciaAlumnos,10,0);
        try{
            lengua.inscribirAlumno(alumno);
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
        assertFalse(lengua.getInscriptos().contains(alumno) || alumno.getCursando().contains(lengua));
    }

    @Test
    void inscribirAlumnoRechazadoPorSobrecargaTest(){
        Curso arte = new Curso(4,"Lengua",2,3,vaciaAlumnos,10,0);
        Curso ciencias = new Curso(5,"Ciencias",2,3,vaciaAlumnos,30,0);
        llena.add(arte);
        llena.add(ciencias);
        llena.add(matematica);
        Alumno alumno = new Alumno("Facundo", "Velazco", 1234,llena, vacia);
        Curso lengua = new Curso(4,"Lengua",2,3,vaciaAlumnos,10,0);
        try{
            lengua.inscribirAlumno(alumno);
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
        assertFalse(lengua.getInscriptos().contains(alumno) || alumno.getCursando().contains(lengua));
    }
}