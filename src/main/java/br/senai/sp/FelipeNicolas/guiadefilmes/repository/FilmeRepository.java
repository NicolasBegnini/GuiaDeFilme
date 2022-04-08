package br.senai.sp.FelipeNicolas.guiadefilmes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.senai.sp.FelipeNicolas.guiadefilmes.model.Filme;

public interface FilmeRepository extends PagingAndSortingRepository<Filme, Long>{

	
	
}
