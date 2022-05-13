package it.unikey.testfinale.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name= "modulo")
@Entity
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID modulo", example= "1", required = true)
    private Long id;

    @Column(name= "nome", nullable = false)
    @ApiModelProperty(notes= "Nome modulo", example= "Back-end", required = true)
    private String nome;

    @Column(name= "argomenti", nullable = false)
    @ApiModelProperty(notes= "Argomenti modulo", example= "Design pattern", required = true)
    private String argomenti;

    @JoinColumn(name= "docente_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione ManyToOne con docente", required = true)
    private Docente docente;

    @Column(name= "inizio", nullable = false)
    @ApiModelProperty(notes= "Data inizio modulo", example= "2021-03-21", required = true)
    private LocalDate inizio;

    @Column(name= "argomenti", nullable = false)
    @ApiModelProperty(notes= "Data fine modulo", example= "2021-04-21", required = true)
    private LocalDate fine;
}
