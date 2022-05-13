package it.unikey.testfinale.BLL.Exception;

public class ConflictBetweenAttributesException extends Exception{

    public ConflictBetweenAttributesException(){
        System.out.println("Gli attributi di questo oggetto sono incompatibili");
    }
}
