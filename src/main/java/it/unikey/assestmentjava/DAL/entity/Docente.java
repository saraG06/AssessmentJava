package it.unikey.assestmentjava.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id", nullable = false)
    @ApiModelProperty(notes = "Richiede un oggetto di tipo Persona, è una OnetoOne", required = true)
    private Persona persona;
    @OneToMany(mappedBy = "docente")
    @ApiModelProperty(notes = "Questa è una relazione OneToMany")
    private List<Modulo> moduli;

}
