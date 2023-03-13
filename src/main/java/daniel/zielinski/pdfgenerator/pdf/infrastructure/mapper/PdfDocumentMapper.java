package daniel.zielinski.pdfgenerator.pdf.infrastructure.mapper;


import daniel.zielinski.pdfgenerator.*;
import daniel.zielinski.pdfgenerator.pdf.domain.dto.cv.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
@SuppressWarnings("java:S1214")
public interface PdfDocumentMapper {

    PdfDocumentMapper INSTANCE = Mappers.getMapper(PdfDocumentMapper.class);

    CvDocumentType map(CvDocumentDTO cvDocumentDTO);

    default ExperienceListType mapExperienceList(List<ExperienceDTO> value) {
        ExperienceListType experienceListType = new ExperienceListType();
        if(value == null){
            return null;
        }
        experienceListType.setExperience(mapExperience(value));
        return experienceListType;
    }

     List<ExperienceType> mapExperience(List<ExperienceDTO> value);


    default EducationListType mapEducationList(List<EducationDTO> value) {
        EducationListType educationListType = new EducationListType();
        if(value == null){
            return null;
        }
        educationListType.setEducation(mapEducation(value));
        return educationListType;
    }

    List<EducationType> mapEducation(List<EducationDTO> value);


    default SkillListType mapSkillList(List<SkillDTO> value) {
    SkillListType skillListType = new SkillListType();
        if(value == null){
            return null;
        }
        skillListType.setSkill(mapSkills(value));
        return skillListType;
    }

    List<SkillType> mapSkills(List<SkillDTO> value);


    default String mapSkills(SkillDTO value) {
        return value.getName();
    }

    default LanguageListType mapLanguageList(List<LanguageDTO> value){
    LanguageListType languageListType = new LanguageListType();
        if(value == null){
            return null;
        }
        languageListType.setLanguage(mapLanguage(value));
        return languageListType;
    }

    List<LanguageType> mapLanguage(List<LanguageDTO> value);



    default  InterestListType mapInterestList(List<InterestDTO> value){
        InterestListType interestListType = new InterestListType();
        if(value == null){
            return null;
        }
        interestListType.setName(mapInterest(value));
        return interestListType;
    }

    List<String> mapInterest(List<InterestDTO> value);

    default String mapSkills(InterestDTO value) {
        return value.getName();
    }

    default String map(ConfidentialityClauseDTO value) {
        return value.getContent();
    }

}
