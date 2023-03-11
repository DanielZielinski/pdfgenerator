package daniel.zielinski.pdfgenerator.pdf.infrastructure.service;

import daniel.zielinski.pdfgenerator.CvDocumentType;
import daniel.zielinski.pdfgenerator.pdf.domain.PdfGenerator;
import daniel.zielinski.pdfgenerator.pdf.domain.XmlGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PdfGeneratorImpl implements PdfGenerator {

    private final FopFactory fopFactory;

    private final TransformerFactory transformerFactory;

    private final XmlGenerator generator;

    @Override
    public File generatePdf(CvDocumentType cvDocument) throws IOException, FOPException, TransformerException, JAXBException {

        File inputDataFile = generator.generateXml(cvDocument);

        File xsltTransformationFile = new File("src/main/resources/cv-document.xsl");
        File resultPdfFile = new File("/tmp/test.pdf");

        try (BufferedOutputStream resultPdfStream = new BufferedOutputStream(Files.newOutputStream(resultPdfFile.toPath()))) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, fopFactory.newFOUserAgent(), resultPdfStream);
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(xsltTransformationFile));
            transformer.setParameter("versionParam", "2.0");
            transformer.transform(new StreamSource(inputDataFile), new SAXResult(fop.getDefaultHandler()));
        }
        return resultPdfFile;
    }

}
