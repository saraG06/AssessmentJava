package it.unikey.testfinale.BLL.Exception;

public class AlreadyExistsException extends Exception{

    public AlreadyExistsException(){
        System.out.println("Esiste già questo oggetto");
    }
}
