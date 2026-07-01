package ec.com.uce.application.service;

import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Pago;
import ec.com.uce.infraestructure.repository.PagoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class PagoService {

    @Inject
    private PagoRepositoryImpl pagoRepositoryImpl;

    @Tiempo
    public void guardar(Pago pago) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo pagoService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());

        this.pagoRepositoryImpl.persist(pago);
    }

    public Pago buscarPorId(Integer id) {
        return this.pagoRepositoryImpl.findById(id);
    }
}
