package daniel.zielinski.pdfgenerator.pdf.infrastructure.service;

import daniel.zielinski.pdfgenerator.pdf.domain.PdfGenerator;
import daniel.zielinski.pdfgenerator.pdf.domain.PdfInitializer;
import lombok.RequiredArgsConstructor;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
class PdfGeneratorImpl implements PdfGenerator {

    private final FopFactory fopFactory;

    private final TransformerFactory transformerFactory;

    private final PdfInitializer pdfInitializer;

    @Override
    public File generatePdf(File xml, File xsl) throws IOException, FOPException, TransformerException {
        File pdf = pdfInitializer.initPdf();
        try (BufferedOutputStream pdfOutputStream = new BufferedOutputStream(Files.newOutputStream(pdf.toPath()))) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, fopFactory.newFOUserAgent(), pdfOutputStream);
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(xsl));
            transformer.setParameter("versionParam", "2.2");
            transformer.transform(new StreamSource(xml), new SAXResult(fop.getDefaultHandler()));
        }
        return pdf;
    }

}
