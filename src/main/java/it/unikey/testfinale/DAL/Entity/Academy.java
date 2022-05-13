package it.unikey.testfinale.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name= "academy")
@Entity
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID academy", example= "1", required = true)
    private Long id;

    @Column(name= "nome", nullable = false)
    @ApiModelProperty(notes= "Nome academy", example= "Java_2022.3", required = true)
    private String nome;

    @Column(name= "dataInizio", nullable = false)
    @ApiModelProperty(notes= "Data inizio academy", example= "2021-03-21", required = true)
    private LocalDate dataInizio;

    @Column(name= "dataFine", nullable = false)
    @ApiModelProperty(notes= "Data fine academy", example= "2022-01-17", required = true)
    private LocalDate dataFine;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione OneToMany con lista di moduli")
    private List<Modulo> moduloList;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione OneToMany con lista di discenti")
    private List<Discente> discenteList;
}
