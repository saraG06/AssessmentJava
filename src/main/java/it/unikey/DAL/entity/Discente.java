package it.unikey.DAL.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "discente")
public class Discente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codiceFiscale", nullable = false)
    private String codiceFiscale;

    @Column(name = "nome",nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @ManyToOne(cascade = CascadeType.ALL)
    private Academy academy;
}
