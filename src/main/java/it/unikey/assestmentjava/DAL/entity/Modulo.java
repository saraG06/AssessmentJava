package it.unikey.assestmentjava.DAL.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name = "modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "argomenti")
    private String argomenti;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;
    @Column(name = "data_inizio")
    private LocalDate data_inizio;
    @Column(name = "data_fine")
    private LocalDate data_fine;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id", nullable = false)
    private Academy academy;
}
