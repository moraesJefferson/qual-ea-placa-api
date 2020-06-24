package br.com.gerenciador.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.gerenciador.entity.Foto;
import br.com.gerenciador.responses.Responses;
import br.com.gerenciador.services.QualEaPlacaService;

@RestController
public class QualEaPlacaController {

	@Autowired
	private QualEaPlacaService service;

	@ResponseBody
	@RequestMapping(value = "/api/qualeaplaca/buscar", method = RequestMethod.POST)
	public ResponseEntity<Responses<List<Foto>>> buscarFoto() {
		Responses<List<Foto>> response = new Responses<List<Foto>>();
		List<Foto> listaFotos = service.buscarPlaca();
		response.setData(listaFotos);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/api/qualeaplaca/upload", method = RequestMethod.POST)
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile file) {
		Responses<String> response = new Responses<String>();
		HttpHeaders httpHeaders = new HttpHeaders();
		try {
			String path = service.upload(file);
			response.setData(path);
			URI uri = new URI("http://localhost:8080/qual-e-a-placa/buscaPlaca");
			httpHeaders.setLocation(uri);
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(httpHeaders,HttpStatus.SEE_OTHER);
	}
}

