package com.estudo.filme.Model;

public record FilmeDTO(
		Long id,
		String nome,
		String sinopse,
		Categoria categoria
		) {
	
	public FilmeDTO (Filme filme) {
		this(filme.getId(), filme.getNome(), filme.getSinopse(), filme.getCategoria() );
	}

}
