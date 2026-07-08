package ec.com.uce.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "auditoria")
public class Auditoria {
    @Id
    @SequenceGenerator(name = "seq_auditoria_generador", sequenceName = "seq_auditoria", allocationSize = 1)
    @GeneratedValue(generator = "seq_auditoria_generador", strategy = GenerationType.SEQUENCE)
    @Column(name = "audi_id")
    private Integer id;

    @Column(name = "audi_nombreMetodo")
    private String nombreMetodo;

    @Column(name = "audi_argumentos")
    private String argumentos;

    @Column(name = "audi_fechaHoraEjecucion")
    private LocalDateTime fechaHoraEjecucion;

    @Column(name = "audi_tiempoEjecucionMs")
    private Long tiempoEjecucionMs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public void setNombreMetodo(String nombreMetodo) {
        this.nombreMetodo = nombreMetodo;
    }

    public String getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(String argumentos) {
        this.argumentos = argumentos;
    }

    public LocalDateTime getFechaHoraEjecucion() {
        return fechaHoraEjecucion;
    }

    public void setFechaHoraEjecucion(LocalDateTime fechaHoraEjecucion) {
        this.fechaHoraEjecucion = fechaHoraEjecucion;
    }

    public Long getTiempoEjecucionMs() {
        return tiempoEjecucionMs;
    }

    public void setTiempoEjecucionMs(Long tiempoEjecucionMs) {
        this.tiempoEjecucionMs = tiempoEjecucionMs;
    }

}
