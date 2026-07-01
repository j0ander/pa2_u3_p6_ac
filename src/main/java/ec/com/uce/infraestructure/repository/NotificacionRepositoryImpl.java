package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Notificacion;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotificacionRepositoryImpl implements PanacheRepositoryBase<Notificacion, Integer> {
}
