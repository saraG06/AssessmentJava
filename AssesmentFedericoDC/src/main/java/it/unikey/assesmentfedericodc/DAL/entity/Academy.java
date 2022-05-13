package it.unikey.assesmentfedericodc.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "academy")
@Entity
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID academy", example= "1", required = true)
    private Long id ;

    @Column(name = "nome" ,nullable = false)
    @ApiModelProperty(notes= "nome academy", example= "JavaMarzo2022", required = true)
    private String nome;

    @Column(name = "dataInizio",nullable = false)
    @ApiModelProperty(notes= "data inizio academy", example= "2022-03-20", required = true)
    private LocalDate dataInizio;

    @Column(name = "dataFine",nullable = false)
    @ApiModelProperty(notes= "data fine academy", example= "2022-08-22", required = true)
    private LocalDate dataFine;

    @OneToMany(mappedBy = "academy", cascade=CascadeType.ALL)
    @ApiModelProperty(notes = "relazione OneToMany con lista Moduli")
    private List<Modulo>  moduli;

    @OneToMany(mappedBy = "academy", cascade=CascadeType.ALL)
    @ApiModelProperty(notes = "relazione OneToMany con lista Discenti")
    private List<Discente> discenti;
}
