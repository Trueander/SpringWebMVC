/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.idat;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //indica que esta clase es de configuración
@EnableWebMvc //habilito el uso de spring mvc
@ComponentScan //para escanear(funcionen) los beans (@Component)
@EnableTransactionManagement //habilita el uso de transacciones
public class WebConfig extends WebMvcConfigurerAdapter
{
    //bean que configura la ruta en donde se guardará las páginas jsp
    @Bean
    public ViewResolver viewResolver()
    {
        //objeto para resolver la ruta de las páginas
        InternalResourceViewResolver resolver=
                new InternalResourceViewResolver();
        
        //ruta de la carpeta(views) de las páginas jsp
        resolver.setPrefix("/WEB-INF/views/");
        
        //el tipo de archivo debe ser de extensión .jsp
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        
        return resolver;
    }
    
    //bean para conexión a BD
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException
    {
        //objeto conexión
        ComboPooledDataSource cpds=new ComboPooledDataSource();
        
        //driver MySQL
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        
        //url conexión MySQL
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/bd_spring_tesla?createDatabaseIfNotExist=true");
        
        cpds.setUser("root"); //usuario
        cpds.setPassword("12345678"); //password
        
        cpds.setMinPoolSize(10); //min cantidad conexiones
        cpds.setMaxPoolSize(20); //max cantidad conexiones
        cpds.setMaxStatements(10); //max cantidad consultas
        cpds.setTestConnectionOnCheckout(true);
        
        return cpds;
    }
    
    //bean para adaptar JPA Hibernate con Spring
    @Bean
    public JpaVendorAdapter jpaVendorAdapter()
    {
        //objeto adaptador
        HibernateJpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        
        adapter.setDatabase(Database.MYSQL); //con MySQL
        adapter.setShowSql(true); //uso de SQL
        adapter.setGenerateDdl(true); //uso de creación de tablas,etc
        
        //dialecto MySQL
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        
        return adapter;
    }
    
    //bean contenedor (dataSource con jpaVendorAdapter)
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter)
    {
        //objeto contenedor
        LocalContainerEntityManagerFactoryBean emfb=
                new LocalContainerEntityManagerFactoryBean();
        
        //agregamos al contendor
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        
        //el contenedor escaneará dicho paquete
        //para la creación del modelo del BD
        emfb.setPackagesToScan("pe.idat.model");
        
        return emfb;
    }
    
    //bean para el uso del @PersistenceContext
    //esta anotación permitirá crear al entityManager
    //entityManager-> es el manejador de entidades 
    //(nos permitirá crear el CRUD de manera sencilla)
    @Bean
    public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }
    
    //bean para el manejo de excepciones
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    //bean para el manejo de transacciones
    //los servicios(@Service) necesitan transacciones para su funcionamiento
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource,EntityManagerFactory entityManagerFactory)
    {
        //objeto transaccion
        JpaTransactionManager transactionManager=
                new JpaTransactionManager();

        transactionManager.setDataSource(dataSource);
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}
