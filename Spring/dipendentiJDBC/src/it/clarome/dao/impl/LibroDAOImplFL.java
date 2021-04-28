package it.clarome.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import it.clarome.dao.LibroDAO;
import it.clarome.model.Libro;

public class LibroDAOImplFL implements LibroDAO{
	
	private final String DIRECTORY = "libreria";

	@Override
	public int salvaLibro(Libro l) {
		int res = 0;
		int code = new Random().nextInt(100-1)+1;

		String nomeFile = code+"_"+l.getAutore()+".book";
		Path path = Paths.get(DIRECTORY);
		
		try {
			Files.createDirectories(DIRECTORY);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (FileWriter fw = new FileWriter(DIRECTORY+"/"+nomeFile, true); 
				BufferedWriter bw = new BufferedWriter(fw)){
			
			String line = "titolo: "+l.getTitolo();
			line += "- autore: "+l.getAutore();
			line += "- numero oagine: "+l.getNumP();
			line += "- pagine: "+l.getPrezzo()+"\n";
			
			bw.write(line);
			
			res = 1;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return res;
	}

	@Override
	public Libro cercaLibro(int id) {
		Libro res = null;
				
		File f = new File(DIRECTORY);
		String[] cont = f.list();
		
		String fileDaLeggere = "";
		
		for (String nomeFile : cont) {
			if(nomeFile.startsWith(Integer.toString(id))) {
				fileDaLeggere = nomeFile;
				break;
			}
		}
		
		if(fileDaLeggere.equals("")) {
			
		}

		return res;
	}

}
