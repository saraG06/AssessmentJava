package it.unikey.assestmentjava.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "discente")
public class Discente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id", nullable = false)
    @ApiModelProperty(notes = "Richiede un oggetto di tipo Persona, è una OneToOne", required = true)
    private Persona persona;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id", nullable = false)
    @ApiModelProperty(notes = "Oggetto di tipo Academy", required = true)
    private Academy academy;
}
