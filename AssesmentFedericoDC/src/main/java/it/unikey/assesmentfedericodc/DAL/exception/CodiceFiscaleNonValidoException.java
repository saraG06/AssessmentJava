package it.unikey.assesmentfedericodc.DAL.exception;

public class CodiceFiscaleNonValidoException extends Exception{
    public CodiceFiscaleNonValidoException(){
        super("il codice fiscale inserito non e' valido") ;
    }
}
