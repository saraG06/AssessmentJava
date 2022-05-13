package com.example.assessmentfinale.DAL.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "discenti")
public class Discente {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "codice_fiscale")
    private String codiceFiscale;

    @Column (name = "nome")
    private String nome;

    @Column (name = "cognome")
    private String cognome;

    @JsonIgnore
    @ManyToMany (mappedBy = "discentiModulo")
    private List<Modulo> moduliStudente;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "academy_id", referencedColumnName = "id", nullable = false)
    private Academy academy;


}
