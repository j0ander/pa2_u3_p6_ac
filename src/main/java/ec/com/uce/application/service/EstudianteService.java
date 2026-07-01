package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.infraestructure.repository.EstudianteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteService {

    @Inject
    private EstudianteRepositoryImpl estudianteRepositoryImpl;

    @Tiempo
    public void guardar(Estudiante estudiante) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo estudianteService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.estudianteRepositoryImpl.persist(estudiante);
    }

    public Estudiante buscarPorId(Integer id) {
        return this.estudianteRepositoryImpl.findById(id);
    }
}
