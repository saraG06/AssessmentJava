package it.unikey.assesmentfedericodc.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "accademy")
@Entity
public class Accademy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "nome")
    private String nome;
    @Column(name = "dataInizio")
    private LocalDate dataInizio;
    @Column(name = "dataFine")
    private LocalDate dataFine;
    @OneToMany(mappedBy = "accademy", cascade=CascadeType.ALL)
    @ApiModelProperty(notes = "relazione OneToMany con lista Moduli")
    private List<Modulo>  moduli;
    @OneToMany(mappedBy = "accademy", cascade=CascadeType.ALL)
    @ApiModelProperty(notes = "relazione OneToMany con lista Discenti")
    private List<Discente> discenti;
}
