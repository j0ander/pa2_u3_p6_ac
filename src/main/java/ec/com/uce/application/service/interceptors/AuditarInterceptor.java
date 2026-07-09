package ec.com.uce.application.service.interceptors;

import java.time.LocalDateTime;

import ec.com.uce.application.service.AuditoriaService;
import ec.com.uce.domain.model.Auditoria;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Auditar
@Interceptor
@Priority(1)
public class AuditarInterceptor {

    @Inject
    private AuditoriaService auditoriaService;

    @AroundInvoke
    public Object auditar(InvocationContext context) throws Exception {

        long inicio = System.currentTimeMillis();
        LocalDateTime fechaHora = LocalDateTime.now();

        Object resultado = null;

        long fin = System.currentTimeMillis();

        Auditoria auditoria = new Auditoria();

        auditoria.setNombreMetodo(context.getMethod().getName());

        //auditoria.setArgumentos(Arrays.toString(context.getParameters()));

        auditoria.setFechaHoraEjecucion(fechaHora);

        auditoria.setTiempoEjecucionMs(fin - inicio);

        auditoriaService.guardar(auditoria);

        resultado = context.proceed();

        return resultado;

    }
}