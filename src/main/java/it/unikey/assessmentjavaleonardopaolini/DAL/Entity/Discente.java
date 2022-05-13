package it.unikey.assessmentjavaleonardopaolini.DAL.Entity;

import javax.persistence.*;

@Entity
@Table(name = "discente")
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cv",nullable = false,unique = true, length = 16)
    private String cv;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "cognome",nullable = false)
    private String cognome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id",nullable = false)
    private Academy academy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
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

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    @Override
    public String toString() {
        return "Discente{" +
                "id=" + id +
                ", cv='" + cv + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", academy=" + academy +
                '}';
    }
}
