package pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.configuration;

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
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet
            (ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
    @Bean(name = "autor")
    public DefaultWsdl11Definition autorWsdl11Definition(XsdSchema autorSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AutorPort");
        wsdl11Definition.setLocationUri("/ws/autor");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(autorSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema autorSchema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/autor.xsd"));
    }

    @Bean(name = "publicacion")
    public DefaultWsdl11Definition publicacionWsdl11Definition(XsdSchema publicacionSchema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PublicacionPort");
        wsdl11Definition.setLocationUri("/ws/publicacion");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(publicacionSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema publicacionSchema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/publicacion.xsd"));
    }

}
