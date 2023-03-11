package daniel.zielinski.pdfgenerator.pdf.domain;

import daniel.zielinski.pdfgenerator.CvDocumentType;

import javax.xml.bind.JAXBException;
import java.io.File;


public interface XmlGenerator {

    File generateXml(CvDocumentType cvDocument, File resultXmlFile) throws JAXBException;
}
