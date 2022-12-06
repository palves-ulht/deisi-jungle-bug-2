package pt.ulusofona.lp2.deisiJungle;

public class InitializationError {
    private String message;

    InitializationError() {

    }

    public void setMessage(String mensagem) {
        message = mensagem;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return getMessage();
    }
}