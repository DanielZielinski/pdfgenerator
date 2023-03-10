package daniel.zielinski.pdfgenerator.pdf.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalDataDTO {

    private String firstName;
    private String lastName;
    private String birth;
    private String email;
    private String jobPosition;
    private String firstAddressLine;
    private String secondAddressLine;
    private String phoneNumber;
}