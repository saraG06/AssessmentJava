package it.unikey.assestmentjava.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "Nome dell'Academy", required = true)
    private String nome;
    @Column(name = "datainizio", nullable = false)
    @ApiModelProperty(notes = "Data di inizio Academy", example = "YY-MM-DD", required = true)
    private LocalDate datainizio;
    @Column(name = "datafine", nullable = false)
    @ApiModelProperty(notes = "Data di fine Academy, deve essere antecedente a quella di inizio", example = "YY-MM-DD", required = true)
    private LocalDate datafine;
    @OneToMany(mappedBy = "academy")
    @ApiModelProperty(notes = "Questa è una relazione OneToMany")
    private List<Modulo> moduli;
    @OneToMany(mappedBy = "academy")
    @ApiModelProperty(notes = "Questa è una relazione OneToMany")
    private List<Discente> discenti;

}
