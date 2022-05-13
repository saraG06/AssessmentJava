package it.unikey.DAL.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "academy")
public class Academy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "dataInizio", nullable = false)
    private LocalDate dataInizio;

    @Column(name = "dataFine")
    private LocalDate dataFine;

    @OneToMany(mappedBy = "academy",cascade = CascadeType.ALL)
    private List<Modulo> moduloList;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL)
    private List<Discente> discenteList;
}
