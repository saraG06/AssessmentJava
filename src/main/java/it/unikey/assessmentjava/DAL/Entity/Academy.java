package it.unikey.assessmentjava.DAL.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes= "academy_id", example= "1", required = true)
    Long id_academy;

    @Column(name = "nome")
    @ApiModelProperty(notes= "nome_academy", example= "2", required = true)
    private String nome;

    @Column(name = "data_inizio")
    @ApiModelProperty(notes= "data_inizio", example= "3", required = true)
    private LocalDate data_inizio;

    @Column(name = "data_fine")
    @ApiModelProperty(notes= "data_fine", example= "4", required = true)
    private LocalDate data_fine;

    @OneToMany(mappedBy = "academy")
    @ApiModelProperty(notes= "discenti", example= "5", required = true)
    private List<Discenti> discenti;

    @OneToMany(mappedBy = "academymodulo")
    @ApiModelProperty(notes= "moduli", example= "6", required = true)
    private List<Modulo> moduli;

    public Long getId_academy() {
        return id_academy;
    }

    public void setId_academy(Long id_academy) {
        this.id_academy = id_academy;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(LocalDate data_inizio) {
        this.data_inizio = data_inizio;
    }

    public LocalDate getData_fine() {
        return data_fine;
    }

    public void setData_fine(LocalDate data_fine) {
        this.data_fine = data_fine;
    }

    public List<Discenti> getDiscenti() {
        return discenti;
    }

    public void setDiscenti(List<Discenti> discenti) {
        this.discenti = discenti;
    }

    public List<Modulo> getModuli() {
        return moduli;
    }

    public void setModuli(List<Modulo> moduli) {
        this.moduli = moduli;
    }

    @Override
    public String toString() {
        return "Academy{" +
                "id_academy=" + id_academy +
                ", nome='" + nome + '\'' +
                ", data_inizio=" + data_inizio +
                ", data_fine=" + data_fine +
                ", discenti=" + discenti +
                ", moduli=" + moduli +
                '}';
    }
}
