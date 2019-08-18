/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller //esta es ahora un controlador
public class HomeController 
{
   
    
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String indexGET() {
        return "index";
    }
}
