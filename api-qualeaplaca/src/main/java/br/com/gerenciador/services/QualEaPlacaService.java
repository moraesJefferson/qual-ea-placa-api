package br.com.gerenciador.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.gerenciador.base64.ConverterBase64;
import br.com.gerenciador.entity.Foto;



@Service
public class QualEaPlacaService {

	public List<Foto> buscarPlaca() {

		List<Foto> listaFotos = new ArrayList<Foto>();
		
		try {
			
			String caminho = getCaminho();
			caminho = caminho + "main.py";
			
			ProcessBuilder bp = new ProcessBuilder("python", caminho);
			
			bp.redirectErrorStream(true);
			Process p = bp.start();
			bp.redirectError();
			
			InputStream stderr = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
			    System.out.println(line);
			}
			p.waitFor();
			System.out.println("Waiting ...");
			System.out.println("Returned Value :" + p.exitValue());
			
			List<String> listaNomeImg = getImgs(getCaminho() + "outputs"+File.separator+ "images"+ File.separator);
			for(String name : listaNomeImg) {
				Foto foto = new Foto();
				foto.setFoto(ConverterBase64.encodeImage(getCaminho()+ "outputs"+File.separator+ "images"+ File.separator +name));
				foto.setPlaca(name.replaceAll(".png", "").replaceAll(".PNG", "").replaceAll(".JPG", "").replaceAll(".jpg", ""));
				listaFotos.add(foto);
			}		
			
			} catch (Exception e) {
						
			e.printStackTrace();
		}
			return listaFotos;	
	}

	public String upload(MultipartFile file) throws IOException{
		
		String caminho = new File(".").getCanonicalPath();
		caminho = caminho+ File.separator+"src"+File.separator+ 
				"main"+File.separator+"webapp"+File.separator+"resource"+
				File.separator+"script_detectar"+  File.separator +"inputs"+File.separator+file.getOriginalFilename();
		try {
			if (!file.isEmpty()) {
		        byte[] bytes = file.getBytes();
		        Path path = Paths.get(caminho);
				Files.write(path, bytes);
			}
	    }catch(IOException e) {
	    	e.printStackTrace();
	    }
	   return caminho;
	}
	
	public String getCaminho() {
		String caminho = "";
		try {
			caminho = new File(".").getCanonicalPath();
			caminho = caminho+ File.separator+"src"+File.separator+ 
					"main"+File.separator+"webapp"+File.separator+"resource"+
					File.separator+"script_detectar"+  File.separator;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return caminho;
	}
	
	public List<String> getImgs(String path){
		List<String> listaNomeImg = new ArrayList<String>();
	    File file = new File(path);
	    File[] arquivos = file.listFiles();

	    for (File arquivo : arquivos) {
	        listaNomeImg.add(arquivo.getName());
	    }
	    return listaNomeImg;
	}
	
}
