package pe.idat.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.idat.edu.dto.EstudianteDTOResponse;
import pe.idat.edu.service.EstudianteService;

@Controller
@RequestMapping(path = "/estudiante/v1")
public class EstudianteController {
	
	@Autowired
	private EstudianteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<EstudianteDTOResponse>> listar(){
		return new ResponseEntity<List<EstudianteDTOResponse>>(service.listarEstudiante(), HttpStatus.OK);
	}

}
