package ec.com.uce.application.service;

import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.domain.repository.AuditoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AuditoriaService {
    @Inject
    private AuditoriaRepository auditoriaRepository;

    public void guardar(Auditoria auditoria) {
        this.auditoriaRepository.crear(auditoria);
    }
}
