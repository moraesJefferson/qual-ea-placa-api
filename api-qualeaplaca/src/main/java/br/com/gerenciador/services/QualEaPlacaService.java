package br.com.gerenciador.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import br.com.gerenciador.dto.FotoDto;
import br.com.gerenciador.entity.Foto;


@Service
public class QualEaPlacaService {

	public Foto buscarPlaca(FotoDto fotoDto) {
		String s = null;
		try {
			Process p = Runtime.getRuntime().exec("python C:\\Users\\jeffe\\Documents\\python.py");
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((s = in.readLine()) != null) {
				System.out.println(s+"10");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 Foto foto = new Foto();
		 foto.setFoto("xcxcxcxcxcxc");
		 foto.setSucess(true);
		 foto.setPlaca("teste");
		 foto.setProbability("23%");
		 foto.setCode("AAA-1234");
		 return foto;	
	}
}
