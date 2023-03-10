package daniel.zielinski.pdfgenerator.pdf.domain;

import daniel.zielinski.pdfgenerator.CvDocumentType;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;


public interface XmlGenerator {

    File generateXml(CvDocumentType cvDocument) throws JAXBException, IOException;
}
