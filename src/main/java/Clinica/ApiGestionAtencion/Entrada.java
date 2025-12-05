package Clinica.ApiGestionAtencion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Entrada {

    private String fec;
    private String hor;
    private String dgn;
    private String trt;
    private Long idMed;

    public Entrada() {
    }

    public Entrada(String fec, String hor, String dgn, String trt, Long idMed) {
        this.fec = fec;
        this.hor = hor;
        this.dgn = dgn;
        this.trt = trt;
        this.idMed = idMed;
    }

    public String getFec() {
        if (this.fec == null) {
            this.fec = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return fec;
    }

    public String getHor() {
        if (this.hor == null) {
            this.hor = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        }
        return hor;
    }

    public void setFec(String fec) {
        this.fec = fec;
    }

    public void setHor(String hor) {
        this.hor = hor;
    }

    public String getDgn() {
        return dgn;
    }

    public void setDgn(String dgn) {
        this.dgn = dgn;
    }

    public String getTrt() {
        return trt;
    }

    public void setTrt(String trt) {
        this.trt = trt;
    }

    public Long getIdMed() {
        return idMed;
    }

    public void setIdMed(Long idMed) {
        this.idMed = idMed;
    }
}
