package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Auditoria;
import ec.com.uce.domain.repository.AuditoriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuditoriaRepositoryImpl implements AuditoriaRepository{
    @Inject
    private EntityManager entityManager;
    @Override
    public void crear(Auditoria auditoria) {
        this.entityManager.persist(auditoria);
    }

}
