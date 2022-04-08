package br.senai.sp.FelipeNicolas.guiadefilmes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.senai.sp.FelipeNicolas.guiadefilmes.model.TipoFilme;
import br.senai.sp.FelipeNicolas.guiadefilmes.repository.TipoFilmeRepository;

@Controller
public class TipoFilmeController {

	@Autowired
	private TipoFilmeRepository tfrepository;

	@RequestMapping("filmeCadastro")
	public String formFilme(Model model) {
		model.addAttribute("tipoFilme");
		return "cadFilme";
	}

	@RequestMapping(value = "cadastraTipoFilme", method = RequestMethod.POST)
	public String cadastraFilme(@Valid TipoFilme tpFilme, RedirectAttributes attr) {

		tfrepository.save(tpFilme);
		attr.addFlashAttribute("mensagemSucesso", "Filme ID:" + tpFilme.getId() + ", cadastrado com sucesso!");

		return "redirect:cadFilme";
	}

	@RequestMapping("listaFilmes/{page}")
	public String listaFilmes(Model model, @PathVariable("page") int page) {

		PageRequest pageable = PageRequest.of(page - 1, 6, Sort.by(Sort.Direction.ASC, "genero"));

		Page<TipoFilme> pagina = tfrepository.findAll(pageable);

		model.addAttribute("filme", pagina.getContent());

		int totalPages = pagina.getTotalPages();

		List<Integer> numPaginas = new ArrayList<Integer>();

		for (int i = 1; i <= totalPages; i++) {
			numPaginas.add(i);
		}

		model.addAttribute("numPaginas", numPaginas);
		model.addAttribute("totalPags", totalPages);
		model.addAttribute("pagAtual", page);
		return "listaFilme";
	}

	@RequestMapping("alterarFilme")
	public String alteraFilme(Long id, Model model) {
		TipoFilme tpFilme = tfrepository.findById(id).get();
		model.addAttribute("filmes", tpFilme);
		return "forward:cadFilme";
	}

	@RequestMapping("excluirFilme")
	public String excluirFilme(Long id) {
		tfrepository.deleteById(id);
		return "redirect:listaFilme";

	}

}
