package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.application.service.interceptors.Auditar;
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
    
    //@Tiempo
    public void guardar(Reporte reporte) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo reporteService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.reporteRepositoryImpl.persist(reporte);
    }
    @Auditar
    public void guardarListaReportes(List<Reporte> lista){
        for(Reporte r: lista){
            this.guardar(r);
        }
    }
    public Reporte buscarPorId(Integer id) {
        return this.reporteRepositoryImpl.findById(id);
    }

}

