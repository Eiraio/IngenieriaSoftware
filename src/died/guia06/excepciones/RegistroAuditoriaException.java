package died.guia06.excepciones;

public class RegistroAuditoriaException extends Exception {
    private String message;

    public RegistroAuditoriaException(){
        this.message = "Ha ocurrido un problema con el registro de auditoría";
    }

    @Override
    public String getMessage(){ return message;}
}
