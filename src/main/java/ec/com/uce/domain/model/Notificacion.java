package ec.com.uce.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "notificacion")
public class Notificacion extends PanacheEntityBase {

    @Id
    @SequenceGenerator(name = "seq_notificacion_generador", sequenceName = "seq_notificacion", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_notificacion_generador")
    @Column(name = "notif_id")
    private Integer id;

    @Column(name = "notif_mensaje")
    private String mensaje;

    @Column(name = "notif_destinatario")
    private String destinatario;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
}
