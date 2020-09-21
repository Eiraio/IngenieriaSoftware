package died.guia06.excepciones;

public class CreditosInsuficientesException extends Exception {
    private String message;

    public CreditosInsuficientesException(){
        this.message = "El alumno no tiene los créditos necesarios para inscribirse a este curso";
    }

    @Override
    public String getMessage(){ return message;}
}
