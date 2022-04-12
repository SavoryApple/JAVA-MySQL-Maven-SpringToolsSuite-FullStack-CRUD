package com.seannavery.languages.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.seannavery.languages.models.Language;
import com.seannavery.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
   
    private final LanguageRepository languageRepository;
    
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }

    public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
    
    
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
    
    
    public Language updateLanguage(Language language) {
    	Long languageId = language.getId();
    	String languageName = language.getName();
    	String languageCreator = language.getCreator();
    	String languageVersion = language.getVersion();
    	
    	Language languageToUpdate = this.findLanguage(languageId);   	
    	languageToUpdate.setName(languageName);
    	languageToUpdate.setCreator(languageCreator);
    	languageToUpdate.setVersion(languageVersion);
    	languageRepository.save(languageToUpdate);
        return languageToUpdate;
    }
  
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
}