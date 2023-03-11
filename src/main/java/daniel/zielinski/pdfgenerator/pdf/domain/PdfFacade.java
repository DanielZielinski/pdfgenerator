package daniel.zielinski.pdfgenerator.pdf.domain;

import daniel.zielinski.pdfgenerator.CvDocumentType;
import daniel.zielinski.pdfgenerator.pdf.domain.dto.cv.CvDocumentDTO;
import daniel.zielinski.pdfgenerator.pdf.infrastructure.mapper.PdfDocumentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.fop.apps.FOPException;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PdfFacade {
    private final PdfProcessor pdfProcessor;

    public File generatePdf(CvDocumentDTO cvDocumentDTO) throws FOPException, JAXBException, IOException, TransformerException {
        CvDocumentType cvDocumentType = PdfDocumentMapper.INSTANCE.map(cvDocumentDTO);
        return pdfProcessor.generatePdf(cvDocumentType);
    }
}
