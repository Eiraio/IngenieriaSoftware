package died.guia06.excepciones;

public class AlumnoSobrecargadoException extends Exception {
    private String message;

    public AlumnoSobrecargadoException(){
        this.message = "El alumno ya cursa todas las materias que le es posible este cuatrimestre";
    }

    @Override
    public String getMessage(){ return message;}
}
