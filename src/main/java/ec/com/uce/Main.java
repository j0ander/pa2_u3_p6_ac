package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.FacturaService;
import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.ReporteService;
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
        private FacturaService fs;

        @Inject
        private MailService ms;

        @Inject
        private ReporteService rs;

        @Override
        public int run(String... args) {
            String nombreHilo = Thread.currentThread().getName();
            System.out.println("nombre del hilo Main: " + nombreHilo);
            System.out.println("ID: " + Thread.currentThread().threadId());
            Factura f1 = new Factura();
            f1.setFecha(LocalDate.of(2026, 10, 1));
            f1.setNumero("0001-003");
            f1.setRuc("1082398721936");
            this.fs.guardar(f1);
            // System.out.println(this.fs.buscarPorId(1).getNumero());

            return 0;
        }
    }
}