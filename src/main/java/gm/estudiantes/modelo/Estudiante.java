package gm.estudiantes.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEstudiante; //gracias a hibernate cuando esto vaya a mi db se generara en  snake_case o id_estudiante
    String nombre;
    String materia;
    Double nota;
}
