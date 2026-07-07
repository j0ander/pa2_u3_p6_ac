package ec.com.uce.application.service;

import ec.com.uce.domain.model.Reporte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class ReporteServiceTarea implements Runnable{
    @Inject
    private ReporteService reporteService;

    private Reporte reporte;

    public ReporteServiceTarea() {
    }

    
    public Reporte getReporte() {
        return reporte;
    }


    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }


    @Override
    public void run() {
        System.out.println(this.reporteService);
        
        this.reporteService.guardar(reporte);    
    }



}
