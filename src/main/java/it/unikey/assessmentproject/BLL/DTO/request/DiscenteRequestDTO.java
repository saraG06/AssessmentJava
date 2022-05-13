package it.unikey.assessmentproject.BLL.DTO.request;


public class DiscenteRequestDTO {

    private Long id;
    private String codiceFiscale;
    private String nome;
    private String cognome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        if (codiceFiscale.length() == 16) {
            this.codiceFiscale = codiceFiscale;
        }else System.out.println("Il codice fiscale deve contenere 16 caratteri!");;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public DiscenteRequestDTO(Long id, String codiceFiscale, String nome, String cognome) {
        this.id = id;
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
    }
}
