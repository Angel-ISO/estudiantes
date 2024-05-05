package gm.estudiantes.servicio;

import gm.estudiantes.modelo.Estudiante;

import java.util.List;

public interface IEstudianteServicio {


        //metodos para interactuar con mi base de datos

        public List<Estudiante> listarEstudiantes();

        public Estudiante buscarEstudiantePorId(Integer idEstudiante);


        public void guardarEstudiante(Estudiante estudiante);


        public void eliminarEstudiante(Estudiante estudiante);


    }


