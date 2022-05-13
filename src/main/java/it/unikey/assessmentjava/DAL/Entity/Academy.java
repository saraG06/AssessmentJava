package it.unikey.assessmentjava.DAL.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_academy;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inizio")
    private LocalDate data_inizio;

    @Column(name = "data_fine")
    private LocalDate data_fine;

    @OneToMany(mappedBy = "academy")
    private List<Discenti> discenti;

    @OneToMany(mappedBy = "academymodulo")
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
