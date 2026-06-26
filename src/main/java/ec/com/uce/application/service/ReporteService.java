package ec.com.uce.application.service;

import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ReporteService {

    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

    public void guardar(Reporte reporte) {
        reporte.persist();
        // Alternativa usando repositorio:
        // this.reporteRepositoryImpl.persist(reporte);
    }

    public Reporte buscarPorId(Integer id) {
        return Reporte.findById(id);
        // Alternativa usando repositorio:
        // return this.reporteRepositoryImpl.findById(id);
    }

}
