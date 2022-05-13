package it.unikey.assesmentfedericodc.DAL.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "modulo")
@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "nome")
    private String nome;
    @Column(name = "argomenti")
    private String argomenti ;
    @Column(name = "dataInizio")
    private LocalDate dataInizio;
    @Column(name = "dataFine")
    private LocalDate dataFine;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="academy_id" )
    private Academy academy;
}
