package ec.com.uce;

import java.time.LocalDate;

import ec.com.uce.application.service.FacturaService;
import ec.com.uce.application.service.MailService;
import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Factura;
import ec.com.uce.domain.model.Mail;
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
        private FacturaService fs;

        @Inject
        private MailService ms;

        @Inject
        private ReporteService rs;

        @Override
        public int run(String... args) {
            System.out.println("--- PRUEBA DE NUEVO PROYECTO ---");
            
            // 2.  Mail
            Mail m1 = new Mail();
            m1.setDe("anderson@uce.edu.ec");
            m1.setPara("destinatario@uce.edu.ec");
            m1.setAsunto("Reporte Mensual");
            m1.setCuerpo("Adjunto el reporte solicitado del mes actual.");
            this.ms.guardar(m1);

            System.out.println("Mail recuperado (Asunto): " + this.ms.buscarPorId(1).getAsunto());

            // 3.  Reporte
            Reporte r1 = new Reporte();
            r1.setTitulo("Reporte de Ventas Octubre");
            r1.setAutor("Admin UCE");
            r1.setFechaCreacion(LocalDate.now());
            r1.setFormato("PDF");
            this.rs.guardar(r1);

            System.out.println("Reporte recuperado (Título): " + this.rs.buscarPorId(1).getTitulo());
            
            return 0;
        }
    }
}