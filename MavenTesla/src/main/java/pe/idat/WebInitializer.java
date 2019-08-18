/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.idat;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    //método para uso de app web
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //método que indica la clase configuración
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    //método que indica la lectura por URL "/"
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }        
}
