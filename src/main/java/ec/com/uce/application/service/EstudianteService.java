package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.Auditable;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.infraestructure.repository.EstudianteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class EstudianteService {
    @Inject
    EstudianteRepositoryImpl estudianteRepositoryImpl;
    @Auditable
    public void guardar(Estudiante estudiante){
        this.estudianteRepositoryImpl.crear(estudiante);
    }
    
    @Auditable
    public void actualizar(Estudiante estudiante){
        this.estudianteRepositoryImpl.actualizar(estudiante);
    }
    @Auditable
    public void borrar(Integer id){
        this.estudianteRepositoryImpl.eliminar(id);
    }
    
}