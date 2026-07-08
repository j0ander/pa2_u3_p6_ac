package ec.com.uce.application.service.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditable
@Interceptor
public class AuditoriaInterceptor {
    @AroundInvoke
      public Object medir(InvocationContext context) throws Exception {

        long inicio = System.currentTimeMillis();

        System.out.println("Inicio del método: " + context.getMethod().getName());

        Object resultado = context.proceed();

        long fin = System.currentTimeMillis();

        System.out.println("Fín del método: " + context.getMethod().getName());
        System.out.println("Tiempo de ejecución: " + (fin - inicio) + " ms");

        return resultado;
    }
       
}
