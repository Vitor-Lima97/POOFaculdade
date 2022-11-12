package library;

public class EstadoInvalidoException extends Exception{

    @Override
    public String getMessage() {
        return "Só é permitido 2 cacteres maiusculo, por favor informar um estado valido!";
    }
}
