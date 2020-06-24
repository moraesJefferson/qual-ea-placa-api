package br.com.gerenciador.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Foto implements Serializable{

	private static final long serialVersionUID = -8362083230852586939L;
	
	private Long id;
	private String foto;
	private String placa;

	public Foto() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = "data:image/png;base64," + foto;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
