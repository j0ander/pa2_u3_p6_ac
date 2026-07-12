package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.application.service.interceptors.Auditar;
import ec.com.uce.domain.model.Producto;
import ec.com.uce.infraestructure.repository.ProductoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProductoService {

    @Inject
    private ProductoRepositoryImpl productoRepositoryImpl;

    public void guardar(Producto producto) {
        String nombreHilo = Thread.currentThread().getName();
        System.out.println("nombre del hilo productoService: " + nombreHilo);
        System.out.println("ID: " + Thread.currentThread().threadId());
        this.productoRepositoryImpl.persist(producto);
    }

    @Auditar
    public void guardarListaProductos(List<Producto> lista) {
        for (Producto p : lista) {
            this.guardar(p);
        }
    }

    @Auditar
    public void guardarListaProductosParalelo(List<Producto> lista) {
        lista.parallelStream().forEach(p -> this.guardar(p));
    }

    public Producto buscarPorId(Integer id) {
        return this.productoRepositoryImpl.findById(id);
    }
}