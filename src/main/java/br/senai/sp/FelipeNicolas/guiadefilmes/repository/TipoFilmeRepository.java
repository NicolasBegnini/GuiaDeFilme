package br.senai.sp.FelipeNicolas.guiadefilmes.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.senai.sp.FelipeNicolas.guiadefilmes.model.TipoFilme;

public interface TipoFilmeRepository extends PagingAndSortingRepository<TipoFilme, Long>{

	public List<TipoFilme> findAllByOrderByGeneroAsc();
	
}
