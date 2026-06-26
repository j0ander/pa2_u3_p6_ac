package ec.com.uce.application.service;

import ec.com.uce.domain.model.Mail;
import ec.com.uce.infraestructure.repository.MailRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class MailService {

    @Inject
    private MailRepositoryImpl mailRepositoryImpl;

    public void guardar(Mail mail) {
        mail.persist();
        // Alternativa usando repositorio:
        // this.mailRepositoryImpl.persist(mail);
    }

    public Mail buscarPorId(Integer id) {
        return Mail.findById(id);
        // Alternativa usando repositorio:
        // return this.mailRepositoryImpl.findById(id);
    }
}
