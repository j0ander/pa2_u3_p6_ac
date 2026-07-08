package ec.com.uce.domain.repository;

import ec.com.uce.domain.model.Estudiante;

public interface EstudianteRepository {

    void crear(Estudiante estudiante);
    void actualizar(Estudiante estudiante);
    void eliminar(Integer id);
    Estudiante buscarPorId(Integer id);

}
