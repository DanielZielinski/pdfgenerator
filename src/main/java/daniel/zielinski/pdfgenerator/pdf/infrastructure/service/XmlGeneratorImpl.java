package daniel.zielinski.pdfgenerator.pdf.infrastructure.service;


import daniel.zielinski.pdfgenerator.CvDocumentType;
import daniel.zielinski.pdfgenerator.pdf.domain.XmlGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

@RequiredArgsConstructor
@Service
class XmlGeneratorImpl implements XmlGenerator {

    private final JAXBContext jaxbContext;

    public File generateXml(CvDocumentType cvDocument, File resultXmlFile) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(cvDocument, resultXmlFile);
        return resultXmlFile;
    }
}
