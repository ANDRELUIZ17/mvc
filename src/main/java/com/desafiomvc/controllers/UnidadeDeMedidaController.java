package com.desafiomvc.controllers;

import com.desafiomvc.entities.UnidadeDeMedida;
import com.desafiomvc.services.UnidadeDeMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("unidade")
public class UnidadeDeMedidaController {

    @Autowired
    private UnidadeDeMedidaService unidadeDeMedidaService;

    @RequestMapping(path = "novo")
    public ModelAndView novaUnidadeMedida(){
        ModelAndView mv = new ModelAndView("unidade/form.html");
        mv.addObject("unidade", new UnidadeDeMedida());

        return mv;
    }
    @RequestMapping(method = RequestMethod.POST, path = "novo")
    public ModelAndView salvarUnidadeMedida(@Valid UnidadeDeMedida unidadeDeMedida, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("unidade/form.html");

        boolean novo = true;

        if (unidadeDeMedida.getId() != null) {
            novo = false;
        }

        if (bindingResult.hasErrors()) {
            mv.addObject("unidade", unidadeDeMedida);
            return mv;
        }
        UnidadeDeMedida unidadeDeMedidaSalva = unidadeDeMedidaService.salvarUnidadeDeMedida(unidadeDeMedida);

        if (novo) {
            mv.addObject("unidade", new UnidadeDeMedida());
        }
        else {
            mv.addObject("unidade", unidadeDeMedidaSalva);
        }
        mv.addObject("mensagem", "Unidade de Medida salva com sucesso.");

        return mv;
    }
    @RequestMapping
    public ModelAndView listarUnidadeDeMedidas(){

        ModelAndView mv = new ModelAndView("unidade/listar.html");
        mv.addObject("lista", unidadeDeMedidaService.listarUnidadeDeMedida());

        return mv;
    }
    @RequestMapping("editar")
    public ModelAndView editarUnidadeDeMedida(@RequestParam Long id) {
        ModelAndView mv = new ModelAndView("unidade/form.html");
        UnidadeDeMedida unidadeDeMedida;

        try{
            unidadeDeMedida = unidadeDeMedidaService.obterUnidadeDeMedida(id);
        } catch (Exception e) {
            unidadeDeMedida = new UnidadeDeMedida();
            mv.addObject("mensagem", e.getMessage());
        }
        mv.addObject("unidade", unidadeDeMedida);
        return mv;
    }
    @RequestMapping("/excluir")
    public ModelAndView excluirUnidadeDeMedida(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("redirect:/unidade");

        try {
            unidadeDeMedidaService.excluirUnidadeDeMedida(id);
            redirectAttributes.addFlashAttribute("mensagem", "Unidade de Medida excluida com sucesso.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir unidade de medida");
        }
        return mv;
    }
}
