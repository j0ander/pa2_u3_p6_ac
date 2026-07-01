package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Estudiante;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstudianteRepositoryImpl implements PanacheRepositoryBase<Estudiante, Integer> {
}
