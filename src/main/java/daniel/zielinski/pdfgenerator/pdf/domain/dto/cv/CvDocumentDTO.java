package daniel.zielinski.pdfgenerator.pdf.domain.dto.cv;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CvDocumentDTO implements Serializable {

    private ConfidentialityClauseDTO confidentialityClause;
    private List<EducationDTO> educationList;
    private List<ExperienceDTO> experienceList;
    private List<InterestDTO> interestList;
    private List<LanguageDTO> languageList;
    private PersonalDataDTO personalData;
    private List<SkillDTO> skillList;

}
