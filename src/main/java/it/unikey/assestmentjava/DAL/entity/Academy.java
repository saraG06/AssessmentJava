package it.unikey.assestmentjava.DAL.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name = "academy")
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "data_inizio", nullable = false)
    private LocalDate data_inizio;
    @Column(name = "data_fine", nullable = false)
    private LocalDate data_fine;
    @OneToMany(mappedBy = "academy")
    private List<Modulo> moduli;
    @OneToMany(mappedBy = "academy")
    private List<Discente> discenti;
}
