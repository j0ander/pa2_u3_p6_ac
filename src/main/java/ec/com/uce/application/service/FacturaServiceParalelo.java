package ec.com.uce.application.service;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.FacturaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class FacturaServiceParalelo {

    @Inject
    private FacturaRepositoryImpl facturaRepositoryImpl;

    @Inject
    private ReporteService rs;
    @Inject
    private ReporteServiceTarea reporteServiceTarea;

    @Inject
    private MailService ms;
    @Inject
    private MailServiceTarea mailServiceTarea;

    @Tiempo
    public void guardar(Factura factura) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo facturaServiceParalelo: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.facturaRepositoryImpl.persist(factura);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Reporte r = new Reporte();
        r.setAutor("Anderson");
        r.setFechaCreacion(LocalDate.now());
        r.setFormato("formato");
        r.setTitulo("titulo");
        // ReporteServiceTarea reporteServiceTarea = new ReporteServiceTarea(r, rs);
        this.reporteServiceTarea.setReporte(r);
        Future<?> reporteFuture = executorService.submit(reporteServiceTarea);

        Mail m = new Mail();
        m.setAsunto("asunto");
        m.setCuerpo("cuerpo");
        m.setDe("Anderson");
        m.setPara("para");
        //MailServiceTarea mailServiceTarea = new MailServiceTarea(m, ms);
        this.mailServiceTarea.setMail(m);
        Future<?> mailFuture = executorService.submit(mailServiceTarea);
        // cerrar el proceso de ejecucion indicando que no voy a enviar mas tareas

        try {
            // Thread.sleep(2000);
            reporteFuture.get();
            mailFuture.get();

        } catch (Exception e) {

        }
        executorService.shutdown();
    }

}
