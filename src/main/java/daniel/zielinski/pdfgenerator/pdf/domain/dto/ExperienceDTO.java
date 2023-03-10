package daniel.zielinski.pdfgenerator.pdf.domain.dto;

import lombok.Data;


@Data
public class ExperienceDTO {

    private String dateFrom;
    private String dateTo;
    private String companyName;
    private String jobPosition;
    private String jobDescription;
}
