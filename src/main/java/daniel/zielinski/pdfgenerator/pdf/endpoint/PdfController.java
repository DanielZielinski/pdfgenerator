package daniel.zielinski.pdfgenerator.pdf.endpoint;

import daniel.zielinski.pdfgenerator.pdf.domain.PdfFacade;
import daniel.zielinski.pdfgenerator.pdf.domain.dto.CvDocumentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pdf")
public class PdfController {

    private final PdfFacade pdfFacade;

    @PostMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public FileSystemResource generateDocument(@RequestBody CvDocumentDTO cvDocument) throws Exception {
        return new FileSystemResource(pdfFacade.generatePdf(cvDocument));


    }

}
