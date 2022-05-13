package it.unikey.assestmentjava.DAL.entity;

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
    private Persona persona;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "academy_id", nullable = false)
    private Academy academy;
}
