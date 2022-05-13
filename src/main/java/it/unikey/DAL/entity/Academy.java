package it.unikey.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes= "Id Academy", example= "1", required = true)
    private Long id;

    @Column(name = "nome", nullable = false)
    @ApiModelProperty(notes= "Nome Academy", example= "Franco", required = true)
    private String nome;

    @Column(name = "dataInizio", nullable = false)
    @ApiModelProperty(notes= "Data di Inizio Academy", example= "2000-01-01", required = true)
    private LocalDate dataInizio;

    @Column(name = "dataFine")
    @ApiModelProperty(notes= "Data di Fine Academy", example= "2001-01-01", required = true)
    private LocalDate dataFine;

    @OneToMany(mappedBy = "academy",cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione OneToMany con Modulo")
    private List<Modulo> moduloList;

    @OneToMany(mappedBy = "academy", cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione OneToMany con Discente")
    private List<Discente> discenteList;
}
