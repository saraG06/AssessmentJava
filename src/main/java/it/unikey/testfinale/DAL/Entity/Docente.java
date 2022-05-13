package it.unikey.testfinale.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name= "docente")
@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID docente", example= "1", required = true)
    private Long id;

    @Column(name= "nome", nullable = false)
    @ApiModelProperty(notes= "Nome docente", example= "Mario", required = true)
    private String nome;

    @Column(name= "cognome", nullable = false)
    @ApiModelProperty(notes= "Cognome docente", example= "Rossi", required = true)
    private String cognome;

    @Column(name= "email", nullable = false)
    @ApiModelProperty(notes= "Email docente", example= "mariorossi@gmail.com", required = true)
    private String email;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione OneToMany con lista di moduli")
    private List<Modulo> moduloList;
}
