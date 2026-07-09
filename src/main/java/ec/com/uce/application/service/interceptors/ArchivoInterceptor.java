package ec.com.uce.application.service.interceptors;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Archivo
@Interceptor
@Priority(2)
public class ArchivoInterceptor {

    @AroundInvoke
    public Object crear(InvocationContext context) throws Exception {
        String metodo = context.getMethod().getName();
        
        File archivo = new File( metodo + ".txt");

        FileWriter escritor = new FileWriter(archivo, true);

        String fecha = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));


        escritor.write("Fecha: " + fecha + " - Método: " + metodo + "\n");

        escritor.close();

        return context.proceed();
    }
}