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
		int i = 0;
		String [] t = new String[4];
		try {
			Process p = Runtime.getRuntime().exec("python C:\\Users\\jeffe\\Documents\\python.py");
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((s = in.readLine()) != null) {
				t[i] = s;
				i++;
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 Foto foto = new Foto();
		 foto.setFoto(fotoDto.getFoto());
		 foto.setSucess(Boolean.valueOf(t[0]));
		 foto.setPlaca(t[1]);
		 foto.setProbability(t[2]);
		 foto.setCode(t[3]);
		 return foto;	
	}
}
