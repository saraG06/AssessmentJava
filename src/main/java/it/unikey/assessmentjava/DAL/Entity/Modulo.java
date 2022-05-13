package it.unikey.assessmentjava.DAL.Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "modulo")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_modulo;

    @Column(name = "argomenti")
    private String argomenti;

    @Column(name = "data_inizio_modulo")
    private LocalDate data_inizio_modulo;

    @Column(name = "data_fine")
    private LocalDate data_fine_modulo;

    @ManyToOne(cascade = CascadeType.ALL)
    private Docente docente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Academy academymodulo;

    public Long getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(Long id_modulo) {
        this.id_modulo = id_modulo;
    }

    public String getArgomenti() {
        return argomenti;
    }

    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
    }

    public LocalDate getData_inizio_modulo() {
        return data_inizio_modulo;
    }

    public void setData_inizio_modulo(LocalDate data_inizio_modulo) {
        this.data_inizio_modulo = data_inizio_modulo;
    }

    public LocalDate getData_fine_modulo() {
        return data_fine_modulo;
    }

    public void setData_fine_modulo(LocalDate data_fine_modulo) {
        this.data_fine_modulo = data_fine_modulo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Academy getAcademymodulo() {
        return academymodulo;
    }

    public void setAcademymodulo(Academy academymodulo) {
        this.academymodulo = academymodulo;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id_modulo=" + id_modulo +
                ", argomenti='" + argomenti + '\'' +
                ", data_inizio_modulo=" + data_inizio_modulo +
                ", data_fine_modulo=" + data_fine_modulo +
                ", docente=" + docente +
                '}';
    }
}
