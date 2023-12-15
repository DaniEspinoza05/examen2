package com.caso2.controller;

import com.caso2.domain.Carro;
import com.caso2.service.CarroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CarroController {

    @Autowired
    private CarroService carroService;

    
    @GetMapping("/carro/agregar/{idCarro}")
    public String agregarCarro(Model model,  Carro carro) {
        carroService.save(carro);
        var lista=carroService.getCarros();
        model.addAttribute("listaCarros",lista);
        
        return "";
    }

    @GetMapping("/carro/listado")
    public String listado(Model model) {
        var carros = carroService.getCarros();
        model.addAttribute("carros", carros);
        model.addAttribute("totalCarros",carros.size());
        return "/carro/listado";
    }
    
     @PostMapping("/carro/guardar")
    public String guardarCarro(Carro carro, Model model) {
        carroService.save(carro);
        var carros = carroService.getCarros();
        model.addAttribute("carros", carros);
        model.addAttribute("totalCarros",carros.size());
        return "redirect:/carro/listado";
    }
    
    @GetMapping("/carro/modificar/{idCarro}")
    public String modificarCarro(Carro carro, Model model) {
        carro = carroService.getCarro(carro);
        model.addAttribute("carro",carro);
        return "/carro/modificar";
    }
 
    @GetMapping("/carro/eliminar/{idCarro}")
    public String eliminarCarro(Carro carro, Model model) {
        carroService.delete(carro);        
        var carros=carroService.getCarros();
        model.addAttribute("carros",carros);
        model.addAttribute("totalCarros",carros.size());
        return "redirect:/carro/listado";
    }
}
