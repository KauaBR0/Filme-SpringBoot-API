package com.estudo.filme.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.filme.Model.FilmeDTO;
import com.estudo.filme.Service.FilmeService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping
	public List<FilmeDTO> listar() {
		return filmeService.listar();
	}
	
	@GetMapping("/{nome}")
	public List<FilmeDTO> listarNome(@PathVariable String nome) {
		return filmeService.listarNome(nome);
	}
	
	@PostMapping
	public void cadastrar (@RequestBody FilmeDTO filmedto) {
		filmeService.cadastrar(filmedto);
	}
	
	@DeleteMapping("/{id}")
	public void Delete (@PathVariable Long id) {
		filmeService.Delete(id);
	}
	
	@PutMapping("/{id}")
	public FilmeDTO atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO) {
	    FilmeDTO filmeAtualizado = filmeService.atualizar(id, filmeDTO);
	    return filmeAtualizado;
	}
	
}
