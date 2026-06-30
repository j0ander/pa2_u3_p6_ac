package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.infraestructure.repository.MailRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {

    @Inject
    private MailRepositoryImpl mailRepositoryImpl;
    
    @Tiempo
    public void guardar(Mail mail) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo mailService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.mailRepositoryImpl.persist(mail);
    }

    public Mail buscarPorId(Integer id) {
        return this.mailRepositoryImpl.findById(id);
    }
}
