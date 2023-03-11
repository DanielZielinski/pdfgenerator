package daniel.zielinski.pdfgenerator.pdf.domain;

import org.apache.fop.apps.FOPException;

import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

public interface PdfGenerator {

     File generatePdf(File xml, File xsl) throws IOException, FOPException, TransformerException;

}
