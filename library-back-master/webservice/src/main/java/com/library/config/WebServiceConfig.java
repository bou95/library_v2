package com.library.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition DefinitionUsers(XsdSchema usersSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("UsersPort");
        definition.setTargetNamespace("http://libraryservice/users");
        definition.setLocationUri("/ws");
        definition.setSchema(usersSchema);
        return definition;
    }

    @Bean(name = "books")
    public DefaultWsdl11Definition DefinitionBooks(XsdSchema booksSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("BooksPort");
        definition.setTargetNamespace("http://libraryservice/books");
        definition.setLocationUri("/ws");
        definition.setSchema(booksSchema);
        return definition;
    }
    
    @Bean(name ="employees")
    public DefaultWsdl11Definition DefinitionEmployees(XsdSchema employeesSchema) {
    	 DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
         definition.setPortTypeName("EmployeesPort");
         definition.setTargetNamespace("http://libraryservice/employees");
         definition.setLocationUri("/ws");
         definition.setSchema(employeesSchema);
         return definition;
     }

    @Bean(name = "borrows")
    public DefaultWsdl11Definition DefinitionBorrow(XsdSchema borrowsSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("BorrowPort");
        definition.setTargetNamespace("http://libraryservice/borrows");
        definition.setLocationUri("/ws");
        definition.setSchema(borrowsSchema);
        return definition;
    }
    

    @Bean
    public XsdSchema usersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsds/users/users.xsd"));
    }

    @Bean
    public XsdSchema booksSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsds/books/books.xsd"));
    }
    
    @Bean
    public XsdSchema employeesSchema() {
    	return new SimpleXsdSchema(new ClassPathResource("xsds/employees/employees.xsd"));
    }

    @Bean
    public XsdSchema borrowsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsds/borrows/borrows.xsd"));
    }
    
}