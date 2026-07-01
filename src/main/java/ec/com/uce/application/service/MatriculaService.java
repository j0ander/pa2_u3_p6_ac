package ec.com.uce.application.service;

import java.time.LocalDate;
import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Matricula;
import ec.com.uce.domain.model.Estudiante;
import ec.com.uce.domain.model.Pago;
import ec.com.uce.domain.model.Notificacion;
import ec.com.uce.infraestructure.repository.MatriculaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MatriculaService {

    @Inject
    private MatriculaRepositoryImpl matriculaRepositoryImpl;

    @Inject
    private EstudianteService estudianteService;
    @Inject
    private PagoService pagoService;
    @Inject
    private NotificacionService notificacionService;

    @Tiempo
    public void guardar(Matricula matricula) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo matriculaService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.matriculaRepositoryImpl.persist(matricula);

        Estudiante e = new Estudiante();
        e.setNombre("Anderson");
        e.setCedula("1726394812");
        this.estudianteService.guardar(e);

        Pago p = new Pago();
        p.setMonto(350.00);
        p.setReferencia("REF-99821");
        this.pagoService.guardar(p);

        Notificacion n = new Notificacion();
        n.setMensaje("Matrícula procesada correctamente.");
        n.setDestinatario("anderson@uce.edu.ec");
        this.notificacionService.guardar(n);
    }

    public Matricula buscarPorId(Integer id) {
        return this.matriculaRepositoryImpl.findById(id);
    }
}
