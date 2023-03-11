package daniel.zielinski.pdfgenerator.pdf.infrastructure.service;

import daniel.zielinski.pdfgenerator.pdf.domain.PdfInitializer;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
class PdfInitializerImpl implements PdfInitializer {

    @Override
    public File initPdf() {
        return new File("/tmp/test.pdf");
    }
}
