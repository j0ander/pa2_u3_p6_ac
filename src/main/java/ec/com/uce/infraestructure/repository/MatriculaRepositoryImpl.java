package ec.com.uce.infraestructure.repository;

import ec.com.uce.domain.model.Matricula;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatriculaRepositoryImpl implements PanacheRepositoryBase<Matricula, Integer> {
}
