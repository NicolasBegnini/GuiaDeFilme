package br.senai.sp.FelipeNicolas.guiadefilmes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.senai.sp.FelipeNicolas.guiadefilmes.model.Filme;
import br.senai.sp.FelipeNicolas.guiadefilmes.repository.FilmeRepository;
import br.senai.sp.FelipeNicolas.guiadefilmes.repository.TipoFilmeRepository;

@Controller
public class FilmeController {
	
	@Autowired
	private TipoFilmeRepository repFilmeTipo;

	@Autowired
	private FilmeRepository repFilme;
	
	@RequestMapping("cadastreFilme")
	public String form(Model model) {
		model.addAttribute("genero", repFilmeTipo.findAllByOrderByGeneroAsc());
		return "filme/formFilme";
	}
	
	@RequestMapping(value = "salvarfilme", method = RequestMethod.POST)
	public String salvar(Filme filme, @RequestParam("filefotos") MultipartFile fileFotos){
		repFilme.save(filme);
		return"redirect:filme/formFilme";
	}
}
