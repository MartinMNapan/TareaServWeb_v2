package pe.idat.edu.service;

import java.util.List;

import pe.idat.edu.dto.EstudianteDTORequest;
import pe.idat.edu.dto.EstudianteDTOResponse;

public interface EstudianteService {
	
	void guardarEstudiante(EstudianteDTORequest estudiante);
	void actualizarEstudiante(EstudianteDTORequest estudiante);
	void eliminarEstudiante(Integer id);
	List<EstudianteDTOResponse> listarEstudiante();
	EstudianteDTOResponse obtenerEstudianteId(Integer id);

}
