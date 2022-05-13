package it.unikey.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "discenti")
public class Discenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "id_discente", example= "1", required = true)
    Long id_discente;

    @Column(name = "nome")
    @ApiModelProperty(notes= "nome_discente", example= "2", required = true)
    private String nome;

    @Column(name = "cognome")
    @ApiModelProperty(notes= "cognome_discente", example= "3", required = true)
    private String cognome;

    @Column(name = "codice_fiscale")
    @ApiModelProperty(notes= "codice_fiscale", example= "4", required = true)
    private String codice_fiscale;

    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "academy", example= "5", required = true)
    private Academy academy;

    public Long getId_discente() {
        return id_discente;
    }

    public void setId_discente(Long id_discente) {
        this.id_discente = id_discente;
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

    public String getCodice_fiscale() {
        return codice_fiscale;
    }

    public void setCodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Discenti{" +
                "id_discente=" + id_discente +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codice_fiscale='" + codice_fiscale + '\'' +
                ", academy=" + academy +
                '}';
    }
}
