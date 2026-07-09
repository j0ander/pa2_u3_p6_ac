package ec.com.uce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Reporte;
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
        private ReporteService rs;

        @Override
        public int run(String... args) throws Exception {
            List<Reporte> lista = new ArrayList<>();
            
            for(int i = 0; i<10; i++){
                Reporte r2 = new Reporte();
                r2.setTitulo("ANDERSON" + i);
                r2.setAutor("autor");
                r2.setFechaCreacion(LocalDate.now());
                r2.setFormato("a");
                lista.add(r2);
            }
            
            this.rs.guardarListaReportes(lista);
           
            
            return 0;
        }
    }
}