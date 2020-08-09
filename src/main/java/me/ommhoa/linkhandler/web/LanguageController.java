package me.ommhoa.linkhandler.web;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Language;
import me.ommhoa.linkhandler.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/languages")
    public String getLanguages(Model model) {
        List<Language> languages = ImmutableList.copyOf(languageRepository.findAll());
        model.addAttribute("languages", languages);
        model.addAttribute("newLanguage", new Language());
        return "languages";
    }

    @PostMapping("/languages")
    public String addLanguage(@ModelAttribute Language language) {
        languageRepository.save(language);
        return "redirect:/languages";
    }

    @GetMapping("/languages/{language}/delete")
    public String deleteLanguage(@PathVariable String language) {
        languageRepository.delete(new Language(language));
        return "redirect:/languages";
    }
}
