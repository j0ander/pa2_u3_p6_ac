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

        try {
            resultado = context.proceed();
        } finally {
            long fin = System.currentTimeMillis();

            Auditoria auditoria = new Auditoria();
            auditoria.setNombreMetodo(context.getMethod().getName());
            auditoria.setFechaHoraEjecucion(fechaHora);
            auditoria.setTiempoEjecucionMs(fin - inicio); // <--- Ahora sí tendrá los milisegundos reales

            auditoriaService.guardar(auditoria);
        }

        return resultado;
    }
}