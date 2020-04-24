package br.com.gerenciador.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gerenciador.dto.FotoDto;
import br.com.gerenciador.entity.Foto;
import br.com.gerenciador.responses.Response;
import br.com.gerenciador.services.QualEaPlacaService;

@RestController
@RequestMapping("/api/qualeaplaca")
public class QualEaPlacaController {

	@Autowired
	private QualEaPlacaService service;

	@PostMapping(path = "/buscar")
	public ResponseEntity<Response<Foto>> buscarFoto(@Valid @RequestBody FotoDto fotoDto, BindingResult result) {
		Response<Foto> response = new Response<Foto>();
		Foto foto = service.buscarPlaca(fotoDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fotoDto.getId())
				.toUri();
		response.setData(foto);
		return ResponseEntity.created(location).body(response);
	}
}

