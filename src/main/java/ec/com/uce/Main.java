package ec.com.uce;

import ec.com.uce.application.service.FacturaService;
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

        @Override
        public int run(String... args) {
            //System.out.println("PRUEBA DE NUEVO PROYECTO");
            //Factura f1 = new Factura();
          
            //this.fs.guardar(f1);

            System.out.println(this.fs.buscarPorId(1).getNumero());
            return 0;
        }

    }

}
