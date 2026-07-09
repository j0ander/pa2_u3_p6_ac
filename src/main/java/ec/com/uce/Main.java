package ec.com.uce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ec.com.uce.application.service.ProductoService;
import ec.com.uce.domain.model.Producto;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(App.class, args);
    }

    public static class App implements QuarkusApplication {

        @Inject
        private ProductoService productoService;

        @Override
        public int run(String... args) throws Exception {
            List<Producto> lista = new ArrayList<>();
            
            for (int i = 1; i <= 500; i++) {
                Producto p = new Producto();
                
                p.setCodigoBarras(String.format("742100%06d", i)); 
                
                p.setNombre("Producto Modelo Omega " + i);
                
                if (i % 3 == 0) {
                    p.setCategoria("Tecnologia");
                } else if (i % 3 == 1) {
                    p.setCategoria("Hogar");
                } else {
                    p.setCategoria("Alimentos");
                }
                
                p.setStock(10 + (i % 50)); 
                p.setPrecio(new BigDecimal(10.00 + (i % 100) + 0.99)); 
                
                lista.add(p);
            }
            
            System.out.println("Iniciando la insercion masiva de 500 productos");
            this.productoService.guardarListaProductos(lista);
            System.out.println("Insercion finalizada con exito.");
           
            return 0;
        }
    }
}