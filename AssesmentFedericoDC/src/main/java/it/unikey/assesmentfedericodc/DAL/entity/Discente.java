package it.unikey.assesmentfedericodc.DAL.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "discente")
@Entity
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "ID discente", example= "1", required = true)
    private Long id ;

    @Column(name = "nome",nullable = false)
    @ApiModelProperty(notes= "nome discente", example= "Mario", required = true)
    private String nome;
    @Column(name = "cognome",nullable = false)
    @ApiModelProperty(notes= "cognome discente", example= "Rossi", required = true)
    private String cognome;
    @Column(name = "codiceFiscale" , length=16,nullable = false)
    @ApiModelProperty(notes= "CF discente", example= "DFRESV86H13Y603P" , required = true)
    private String codiceFiscale;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="academy_id" )
    @ApiModelProperty(notes= "relazione ManyToOne con academy", required = true)
    private Academy academy;


}
