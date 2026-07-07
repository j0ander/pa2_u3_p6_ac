package ec.com.uce.application.service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class FacturaServiceCompletaFuture {
    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;

    @Inject
    private ReporteService reporteService;
    @Inject
    private MailService mailService;

    @Tiempo
    public void guardar(Factura factura) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo facturaService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.facturaRepositoryImpl.persist(factura);

        Reporte r = new Reporte();
        r.setAutor("Anderson");
        r.setFechaCreacion(LocalDate.now());
        r.setFormato("formato");
        r.setTitulo("titulo");
        CompletableFuture<Void> completableReporte =CompletableFuture.runAsync(() -> this.reporteService.guardar(r));
        
        
        Mail m = new Mail();
        m.setAsunto("asunto");
        m.setCuerpo("cuerpo");
        m.setDe("Anderson");
        m.setPara("para");
        CompletableFuture<Void> completableMail =CompletableFuture.runAsync(() -> this.mailService.guardar(m));
        //espera hasta que las dos tareas/hilos se terminen
        CompletableFuture.allOf(completableMail, completableReporte).join();
        
    }
}
