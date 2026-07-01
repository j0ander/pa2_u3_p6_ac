package ec.com.uce;

import java.time.LocalDate;
import ec.com.uce.application.service.MatriculaService;
import ec.com.uce.application.service.interceptors.Tiempo;
import ec.com.uce.domain.model.Matricula;
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
        private MatriculaService matriculaService;

        @Override
        @Tiempo
        public int run(String... args) {
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("nombre del hilo Main: " + nombreHilo);
            System.out.println("ID: " + Thread.currentThread().threadId());
            
            Matricula m1 = new Matricula();
            m1.setFecha(LocalDate.of(2026, 10, 1));
            m1.setCarrera("Ingeniería en Sistemas");
            m1.setCodigo("MATR-2026-001");
            
            this.matriculaService.guardar(m1);
            return 0;
        }
    }
}
