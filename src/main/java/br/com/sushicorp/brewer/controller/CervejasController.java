package br.com.sushicorp.brewer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sushicorp.brewer.model.Cerveja;

@Controller
public class CervejasController {

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.GET)
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value= "/cervejas/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes atributes) {
		
		System.out.println(cerveja.toString());
		
		List<ObjectError> erros = result.getAllErrors();
		
		for (ObjectError objectError : erros) {
			System.out.println("objectError.getObjectName() " + objectError.getObjectName());
			System.out.println(objectError.getCodes().toString());
			System.out.println(objectError.getCode().toString());
		}
		
		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Erro no formulario");
			return "cerveja/CadastroCerveja";
		}
		
		atributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		return "redirect:/cervejas/novo";
	}
}
