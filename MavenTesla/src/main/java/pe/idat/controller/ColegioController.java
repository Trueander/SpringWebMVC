
package pe.idat.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.idat.model.Colegio;
import pe.idat.service.ColegioService;

@Controller
public class ColegioController {
    
    @Autowired
    @Qualifier("colegioServiceImpl")
    private ColegioService colegioService;
    
    @GetMapping(value = "/colegio_findAll")
    public String findAll_GET(Map map){
        
        map.put("bColegios", colegioService.findAll());
        
        return "colegio_findAll";
    }
    
    @GetMapping(value = "/colegio_insert")
    public String insert_GET(Model model){
        
        Colegio colegioModel = new Colegio();
        model.addAttribute("colegio", colegioModel);
        
        return "colegio_insert";
    }
    
    @PostMapping(value = "/colegio_insert")
    public String insert_POST(Colegio colegio){
        
        colegioService.insert(colegio);
        
        return "redirect:/colegio_findAll";
    }
    
    @GetMapping(value = "/colegio_update/{id_colegio}")
    public String update_GET(Model model,@PathVariable Integer id_colegio){
        
        Colegio colegioModel = colegioService.findById(id_colegio);
        model.addAttribute("colegio", colegioModel);
        
        return "colegio_update";
    }
    
    @PostMapping(value = "/colegio_update/{id_colegio}")
    public String update_POST(Colegio colegio){
        
        colegioService.update(colegio);
        
        return "redirect:/colegio_findAll";
    }
    
    
    @GetMapping(value = "/colegio_delete/{id_colegio}")
    public String delete_GET(Model model, @PathVariable Integer id_colegio){
        
        Colegio colegioModel = colegioService.findById(id_colegio);
        model.addAttribute("colegio", colegioModel);
        
        return "colegio_delete";
    }
    
    @PostMapping(value = "/colegio_delete/{id_colegio}")
    public String delete_POST(Colegio colegio){
        
        
        
        colegioService.delete(colegio.getId_colegio());
        
        return "redirect:/colegio_findAll";
    }
}
