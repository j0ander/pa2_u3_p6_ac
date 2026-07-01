package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Notificacion;
import ec.com.uce.infraestructure.repository.NotificacionRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class NotificacionService {

    @Inject
    private NotificacionRepositoryImpl notificacionRepositoryImpl;

    @Tiempo
    public void guardar(Notificacion notificacion) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo notificacionService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.notificacionRepositoryImpl.persist(notificacion);
    }

    public Notificacion buscarPorId(Integer id) {
        return this.notificacionRepositoryImpl.findById(id);
    }
}
