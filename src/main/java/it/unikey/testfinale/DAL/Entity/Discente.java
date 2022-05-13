package it.unikey.testfinale.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name= "discente")
@Entity
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID discente", example= "1", required = true)
    private Long id;

    @Column(name= "CF", nullable = false, unique = true, length= 16)
    @ApiModelProperty(notes= "Codice fiscale docente", example= "MRIRSS02A05K501H", required = true)
    private String CF;

    @Column(name= "nome", nullable = false)
    @ApiModelProperty(notes= "Nome docente", example= "Maria", required = true)
    private String nome;

    @Column(name= "cognome", nullable = false)
    @ApiModelProperty(notes= "Cognome docente", example= "Rossa", required = true)
    private String cognome;

    @JoinColumn(name= "academy_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    @ApiModelProperty(notes= "Relazione ManyToOne con academy", required = true)
    private Academy academy;
}
