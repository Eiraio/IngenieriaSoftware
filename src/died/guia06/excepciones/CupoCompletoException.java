package died.guia06.excepciones;

public class CupoCompletoException extends Exception {
    private String message;

    public CupoCompletoException(){
        this.message = "El curso tiene su cupo completo de alumnos";
    }

    @Override
    public String getMessage(){ return message;}
}
