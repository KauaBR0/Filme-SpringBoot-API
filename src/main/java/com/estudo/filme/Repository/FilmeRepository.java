package com.estudo.filme.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.estudo.filme.Model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	
	
	public List<Filme> findByNomeContains (String nome);

}
