package com.estudo.filme.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.filme.Model.Filme;
import com.estudo.filme.Model.FilmeDTO;
import com.estudo.filme.Repository.FilmeRepository;

@Service
public class FilmeService {
	
	
	
	@Autowired
	private FilmeRepository repository;
	
	public List<FilmeDTO> listar () {
		return repository.findAll().stream().map(FilmeDTO::new).toList();
	}
	
	public void cadastrar (FilmeDTO filmedto) {
		repository.save(new Filme(filmedto));
	}
	
	public List<FilmeDTO> listarNome (String nome) {
		
		return repository.findByNomeContains(nome).stream().map(FilmeDTO::new).toList();
		
	}
	
	public void Delete (Long id) {
		repository.deleteById(id);
	}
	
	public FilmeDTO atualizar(Long id, FilmeDTO filmedto) {
		
		Filme filme = new Filme();
		
		filme = repository.findById(id).get();

		filme.setNome(filmedto.nome());
		filme.setSinopse(filmedto.sinopse());
		filme.setCategoria(filmedto.categoria());
		
		Filme filmeatualizado = repository.save(filme);
		
		return new FilmeDTO (filmeatualizado);
		
	}
	
	

}
