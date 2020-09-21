package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private String apellido;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;

	public Alumno(String nombre, String apellido, Integer nroLibreta, List<Curso> cursando, List<Curso> aprobados) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroLibreta = nroLibreta;
		this.cursando = cursando;
		this.aprobados = aprobados;
	}

	public Alumno(String nombre, String apellido, Integer nroLibreta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroLibreta = nroLibreta;
		this.cursando = new ArrayList<>();
		this.aprobados = new ArrayList<>();
	}

	public String getNombre() {
		return nombre+" "+ apellido;
	}

	public List<Curso> getCursando() {
		return cursando;
	}

	public List<Curso> getAprobados() {
		return aprobados;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public int creditosObtenidos() {
		int aux = 0;
		for(int i=0; i< this.aprobados.size(); i++){
			aux += this.aprobados.get(i).getCreditos();
		}
		return aux;
	}

	public void aprobar(Curso c) {
		for(int i=0; i < this.cursando.size(); i++){
			if( c == this.cursando.get(i)){
				this.cursando.remove(i);
				this.aprobados.add(c);
				break;
			}
		}
	}

	public void inscripcionAceptada(Curso c) {
		if(c.inscribir(this)){
			System.out.println("El alumno " + this.nombre + " se ha inscripto con éxito al curso " + c.getNombre());
		}else {
			System.out.println("El alumno " + this.nombre + " no se ha podido inscribir al curso " + c.getNombre());
		}
	}

	public Boolean equals(Alumno alumno){
		if(this.nroLibreta == alumno.nroLibreta) return true;
		return false;
	}

	@Override
	public int compareTo(Alumno a){
		return (int) (this.nombre.compareTo(a.getNombre()));
	}

	@Override
	public String toString(){
		return this.nroLibreta + "  " + this.nombre;
	}

}