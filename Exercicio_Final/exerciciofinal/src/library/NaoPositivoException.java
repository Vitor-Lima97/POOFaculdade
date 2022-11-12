package library;

public class NaoPositivoException extends Exception{

    @Override
    public String getMessage() {
        return "Valor não permitido, favor usar um valor valido!";
    }
}
