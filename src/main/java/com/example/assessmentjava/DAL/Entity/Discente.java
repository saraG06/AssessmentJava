package com.example.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "discente")
@Entity
public class Discente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID discente", example= "1", required = true)
    private Long id;
    @Column(name = "codiceFiscale", nullable = false)
    @ApiModelProperty(notes= "codice fiscale", example= "SFNDRN92H24S34G" , required = true)
    private String codiceFiscale;
    @Column(name = "nome", nullable = false)
    @ApiModelProperty(notes= "nome discente", example= "Peppone", required = true)
    private String nome;
    @Column(name = "cognome", nullable = false)
    @ApiModelProperty(notes= "cognome discente", example= "konbayashi", required = true)
    private String cognome;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @ApiModelProperty(notes= "relazione con academy", required = true)
    @JoinColumn(name="academy_id")
    private Academy academy;

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
        this.codiceFiscale = codiceFiscale;
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
}
