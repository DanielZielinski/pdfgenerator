package daniel.zielinski.pdfgenerator.pdf.infrastructure.service;


import daniel.zielinski.pdfgenerator.CvDocumentType;
import daniel.zielinski.pdfgenerator.pdf.domain.XmlGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Service
public class XmlGeneratorImpl implements XmlGenerator {

    private final JAXBContext jaxbContext;

    @Override
    public File generateXml(CvDocumentType cvDocument) throws JAXBException, IOException {

//        if(getCvJaxbContext() == null){
//            setCvJaxbContext(JAXBContext.newInstance("pdfgenerator.zielinski.daniel"));
//        }

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();

        marshaller.marshal(cvDocument, writer);

        File cvFile = new File("/tmp/cv-document.xml");

        Files.write(Paths.get(cvFile.getAbsolutePath()), writer.toString().getBytes());

        return cvFile;

    }
}
