package com.seannavery.languages.controllers;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.seannavery.languages.models.Language;
import com.seannavery.languages.services.LanguageService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class LanguageController {
	private final LanguageService languageService;
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }
    
    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
    	List<Language> languages = languageService.allLanguages();
    	model.addAttribute("languages", languages);
    	return "index.jsp";
    }
    
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
    
    @RequestMapping(value="/languages/create", method=RequestMethod.POST)
    public String create(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
        	List<Language> languages = languageService.allLanguages();
        	model.addAttribute("languages", languages);
            return "index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    } 
    
    @RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
    
}
