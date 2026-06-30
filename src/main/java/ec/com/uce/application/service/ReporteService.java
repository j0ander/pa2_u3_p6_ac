package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;
    
    @Tiempo
    public void guardar(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo reporteService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.reporteRepositoryImpl.persist(reporte);
    }

    public Reporte buscarPorId(Integer id) {
        return this.reporteRepositoryImpl.findById(id);
    }

}
