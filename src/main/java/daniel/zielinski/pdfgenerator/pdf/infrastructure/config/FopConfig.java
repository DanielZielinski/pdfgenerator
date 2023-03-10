package daniel.zielinski.pdfgenerator.pdf.infrastructure.config;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.configuration.DefaultConfigurationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.transform.TransformerFactory;
import java.io.File;

@Configuration
public class FopConfig {

    @Bean
    public org.apache.fop.configuration.Configuration getFopConfiguration() throws Exception {
        DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
        return cfgBuilder.buildFromFile(new File("src/main/resources/fop.xconf"));
    }

    @Bean
    public FopFactory getFopFactory(org.apache.fop.configuration.Configuration cfg) {
        FopFactoryBuilder builder = new FopFactoryBuilder(new File(".").toURI());
        builder.setConfiguration(cfg);
        return builder.build();

    }

    @Bean
    public TransformerFactory getTransformerFactory()  {
        return TransformerFactory.newInstance();

    }
}
