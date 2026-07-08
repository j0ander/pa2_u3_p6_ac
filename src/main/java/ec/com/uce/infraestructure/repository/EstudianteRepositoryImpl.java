package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {
    @Inject
    EntityManager entityManager;
    @Override
    public void crear(Estudiante estudiante) {
        this.entityManager.persist(estudiante);

    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(buscarPorId(id));

    }

    @Override
    public Estudiante buscarPorId(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
        
    }

}