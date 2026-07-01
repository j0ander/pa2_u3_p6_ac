package ec.com.uce.domain.model;

import java.time.LocalDate;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "seq_matricula_generador", sequenceName = "seq_matricula", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula_generador")
    @Column(name = "matr_id")
    private Integer id;

    @Column(name = "matr_fecha")
    private LocalDate fecha;

    @Column(name = "matr_carrera")
    private String carrera;

    @Column(name = "matr_codigo")
    private String codigo;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
}
