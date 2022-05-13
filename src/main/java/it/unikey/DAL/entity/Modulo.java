package it.unikey.DAL.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "modulo")
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "argomenti", nullable = false)
    private String argomenti;

    @Column(name = "dataInizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "dataFine")
    private LocalDate dataFine;

    @OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL)
    private List<Docente> docente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Academy academy;
}
