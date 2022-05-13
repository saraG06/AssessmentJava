package it.unikey.assessmentjava.DAL.Entity;

import javax.persistence.*;

@Entity
@Table(name = "discenti")
public class Discenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_discente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "codice_fiscale")
    private String codice_fiscale;

    @ManyToOne(cascade = CascadeType.ALL)
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
