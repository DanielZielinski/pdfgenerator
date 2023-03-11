package daniel.zielinski.pdfgenerator.pdf.infrastructure.service;

import daniel.zielinski.pdfgenerator.pdf.domain.XslResolver;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
class XslResolverImpl implements XslResolver {

    @Override
    public File getXslFile() {
        return new File("src/main/resources/cv-document.xsl");
    }
}
