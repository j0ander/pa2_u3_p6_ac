package ec.com.uce;

import ec.com.uce.application.service.EstudianteService;
import ec.com.uce.domain.model.Estudiante;
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
        private EstudianteService estudianteService;

        @Override
        public int run(String... args) throws Exception {

            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Anderson");
            estudiante.setApellido("Chancusi");

            estudianteService.guardar(estudiante);

            Estudiante estudiante1 = new Estudiante();
            estudiante1.setId(17);
            estudiante1.setNombre("anderson joel");
            
            estudianteService.actualizar(estudiante1);


            estudianteService.borrar(18);
            return 0;
        }
    }
}