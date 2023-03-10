package daniel.zielinski.pdfgenerator.pdf.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;

@Configuration
public class JaxbConfig {

    @Bean
    public JAXBContext getJaxbContext() throws Exception {
        return JAXBContext.newInstance("daniel.zielinski.pdfgenerator");
    }

}
