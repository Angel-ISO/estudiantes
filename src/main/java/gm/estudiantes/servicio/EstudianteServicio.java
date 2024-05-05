package gm.estudiantes.servicio;

import gm.estudiantes.modelo.Estudiante;
import gm.estudiantes.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio {

    //implementacion para conectarse con mi capa de servicio

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    @Override
    public Estudiante buscarEstudiantePorId(Integer idEstudiante) {
        return estudianteRepositorio.findById(idEstudiante).orElse(null);
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        estudianteRepositorio.delete(estudiante);
    }
}
