package pe.idat.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.edu.dto.EstudianteDTORequest;
import pe.idat.edu.dto.EstudianteDTOResponse;
import pe.idat.edu.model.Estudiante;
import pe.idat.edu.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	
	@Autowired
	private EstudianteRepository repository;

	@Override
	public void guardarEstudiante(EstudianteDTORequest estudiante) {
		// TODO Auto-generated method stub
		Estudiante e = new Estudiante();
		e.setNombre(estudiante.getNombreEstudiante());
		e.setApellido(e.getApellido());
		e.setCorreo(estudiante.getCorreoEstudiante());
		e.setDni(estudiante.getDniEstudiante());
		repository.save(e);
		

	}

	@Override
	public void actualizarEstudiante(EstudianteDTORequest estudiante) {
		// TODO Auto-generated method stub
		Estudiante e = new Estudiante();
		e.setId(estudiante.getId());
		e.setNombre(estudiante.getNombreEstudiante());
		e.setApellido(e.getApellido());
		e.setCorreo(estudiante.getCorreoEstudiante());
		e.setDni(estudiante.getDniEstudiante());
		repository.saveAndFlush(e);

	}

	@Override
	public void eliminarEstudiante(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public List<EstudianteDTOResponse> listarEstudiante() {
		// TODO Auto-generated method stub
		List<EstudianteDTOResponse> listar = new ArrayList<>();
		EstudianteDTOResponse dto = null;
		List<Estudiante> e = repository.findAll();
		for(Estudiante estudiante : e) {
			dto = new EstudianteDTOResponse();
			listar.add(dto);
		}
		return listar;
	}

	@Override
	public EstudianteDTOResponse obtenerEstudianteId(Integer id) {
		// TODO Auto-generated method stub
		Estudiante estudiante = repository.findById(id).orElse(null);
		EstudianteDTOResponse dto = new EstudianteDTOResponse();
		
		dto.setId(estudiante.getId());
		dto.setNombreEstudiante(estudiante.getNombre());
		dto.setApellidoEstudiante(estudiante.getApellido());
		dto.setCorreoEstudiante(estudiante.getCorreo());
		dto.setDniEstudiante(estudiante.getDni());
		
		return dto;
	}

}
