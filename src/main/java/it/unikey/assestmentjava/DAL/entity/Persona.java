package it.unikey.assestmentjava.DAL.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cf", nullable = false, unique = true)
    private String cf;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cognome", nullable = false)
    private String cognome;
}
