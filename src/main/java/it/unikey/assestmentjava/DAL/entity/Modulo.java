package it.unikey.assestmentjava.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "Nome del Modulo", required = true)
    private String nome;
    @Column(name = "argomenti")
    @ApiModelProperty(notes = "Lista degli argomenti in formato String")
    private String argomenti;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "docente_id", nullable = false)
    @ApiModelProperty(notes = "Richiede un Docente, è una ManyToOne", required = true)
    private Docente docente;
    @Column(name = "data_inizio")
    @ApiModelProperty(notes = "Data di inizio Modulo")
    private LocalDate data_inizio;
    @Column(name = "data_fine")
    @ApiModelProperty(notes = "Data di fine modulo, non può essere antecedente alla data di inizio")
    private LocalDate data_fine;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id", nullable = false)
    @ApiModelProperty(notes = "Richiede un'Academy, è una relazione ManyToOne", required = true)
    private Academy academy;
}
