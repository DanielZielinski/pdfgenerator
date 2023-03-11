package daniel.zielinski.pdfgenerator.pdf.domain;

import daniel.zielinski.pdfgenerator.CvDocumentType;
import org.apache.fop.apps.FOPException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public interface PdfProcessor {

     File generatePdf(CvDocumentType cvDocumentType) throws IOException, FOPException, TransformerException, JAXBException;

}
