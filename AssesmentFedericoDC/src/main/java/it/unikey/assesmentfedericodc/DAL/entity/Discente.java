package it.unikey.assesmentfedericodc.DAL.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "discente")
@Entity
public class Discente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "codiceFiscale")
    private String codiceFiscale;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="academy_id" )
    private Academy academy;


}
