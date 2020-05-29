package br.com.gerenciador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.dto.FotoDto;
import br.com.gerenciador.entity.Foto;
import br.com.gerenciador.responses.Responses;
import br.com.gerenciador.services.QualEaPlacaService;

@RestController
public class QualEaPlacaController {

	@Autowired
	private QualEaPlacaService service;

	@ResponseBody
	@RequestMapping(value = "/api/qualeaplaca/buscar", method = RequestMethod.POST)
	public ResponseEntity<Responses<Foto>> buscarFoto(@Valid @RequestBody(required = true) FotoDto fotoDto) {
		Responses<Foto> response = new Responses<Foto>();
		Foto foto = service.buscarPlaca(fotoDto);
		response.setData(foto);
		return ResponseEntity.ok(response);
	}
}

