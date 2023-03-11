package daniel.zielinski.pdfgenerator.pdf.infrastructure.service;

import daniel.zielinski.pdfgenerator.CvDocumentType;
import daniel.zielinski.pdfgenerator.pdf.domain.PdfGenerator;
import daniel.zielinski.pdfgenerator.pdf.domain.PdfProcessor;
import daniel.zielinski.pdfgenerator.pdf.domain.XmlGenerator;
import daniel.zielinski.pdfgenerator.pdf.domain.XslResolver;
import lombok.RequiredArgsConstructor;
import org.apache.fop.apps.FOPException;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
class PdfProcessorImpl implements PdfProcessor {

    private final XmlGenerator xmlGenerator;

    private final XslResolver xslResolver;

    private final PdfGenerator pdfGenerator;

    @Override
    public File generatePdf(CvDocumentType cvDocument) throws IOException, FOPException, TransformerException, JAXBException {
        File xmlFile = xmlGenerator.generateXml(cvDocument, new File("/tmp/cv-document.xml"));
        File xslFile = xslResolver.getXslFile();
        return pdfGenerator.generatePdf(xmlFile, xslFile);

    }

}
