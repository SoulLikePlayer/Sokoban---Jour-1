package SAE.exception;

public class FileFormatException extends Exception{


    public FileFormatException(String message){
        super("SAE.exception.FileFormatException : "+message);
    }
}
