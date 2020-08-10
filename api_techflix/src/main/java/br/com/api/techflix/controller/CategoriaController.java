package br.com.api.techflix.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.api.techflix.dao.CategoriaDAO;
import br.com.api.techflix.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@GetMapping	(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> get() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		Gson gson = new Gson();
		String json;
		
		CategoriaDAO dao = new CategoriaDAO();
		categorias = dao.listaCategoria();
		json = gson.toJson(categorias);
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
}
