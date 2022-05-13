package it.unikey.assessmentjava.BLL.Dto.Request;

import java.time.LocalDate;

public class ModuloRequestDTO {

    private String nome;
    private String argomenti;
    private String docente;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public ModuloRequestDTO(String nome, String argomenti, String docente, LocalDate dataInizio, LocalDate dataFine) {
        this.nome = nome;
        this.argomenti = argomenti;
        this.docente = docente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArgomenti() {
        return argomenti;
    }

    public void setArgomenti(String argomenti) {
        this.argomenti = argomenti;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "ModuloRequestDTO{" +
                "nome='" + nome + '\'' +
                ", argomenti='" + argomenti + '\'' +
                ", docente='" + docente + '\'' +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                '}';
    }
}
