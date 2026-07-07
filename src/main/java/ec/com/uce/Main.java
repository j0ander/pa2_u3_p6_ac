package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.FacturaServiceCompletaFuture;
import ec.com.uce.domain.model.Factura;
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
        private FacturaServiceCompletaFuture fsp;


        @Override
        public int run(String... args) {
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("nombre del hilo Main: " + nombreHilo);
            System.out.println("ID: " + Thread.currentThread().threadId());
            Factura f1 = new Factura();
            f1.setFecha(LocalDate.of(2026, 10, 1));
            f1.setNumero("0001-003");
            f1.setRuc("1082398721936");
            this.fsp.guardar(f1);

            return 0;
        }
    }
}