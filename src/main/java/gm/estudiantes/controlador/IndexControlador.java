package gm.estudiantes.controlador;
import gm.estudiantes.modelo.Estudiante;
import gm.estudiantes.servicio.EstudianteServicio;
import java.util.List;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexControlador {
    private  static  final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    EstudianteServicio estudianteServicio;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String iniciar(ModelMap modelo){
         List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
        estudiantes.forEach((estudiante -> logger.info(estudiante.toString())));

        // ahora debo compartir la informacion del modelo en la vista
        modelo.put("estudiantes", estudiantes);
        return  "index"; //mi index.jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String mostraragregar(){
        return "add"; //esta peticion solo redirecciona a mi add.jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String agregar(@ModelAttribute("estudianteForma") Estudiante estudiante){
        logger.info("Estudiante a agregar"+ estudiante);
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/"; //me redirige al context path
    }



    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String mostrarEditar(@RequestParam int idEstudiante , ModelMap modelo){
        Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
        logger.info("estudiante a editar"+ estudiante);
        modelo.put("estudiante", estudiante);
                return "edit"; //me redirecciona a mi edit.jsp
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editarEstudiante(@ModelAttribute("estudianteForma") Estudiante estudiante){
        logger.info("empleado a guardar"+ estudiante);
        estudianteServicio.guardarEstudiante(estudiante);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String eliminar (@RequestParam int idEstudiante){
       Estudiante estudiante = new Estudiante();
       estudiante.setIdEstudiante(idEstudiante);
       estudianteServicio.eliminarEstudiante(estudiante);
       return "redirect:/";
    }


}
