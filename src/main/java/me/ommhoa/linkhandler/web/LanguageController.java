package me.ommhoa.linkhandler.web;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Language;
import me.ommhoa.linkhandler.repository.LanguageRepository;
import me.ommhoa.linkhandler.service.LanguageService;
import me.ommhoa.linkhandler.view.LanguageView;
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
    private LanguageService languageService;

    @Autowired
    private LanguageView languageView;

    @GetMapping("/languages")
    public String getLanguages(Model model) {
        return languageView.renderPage(
                model,
                new LanguageView.Parameters()
                        .setNewLanguage(new Language())
                        .setLanguages(languageService.getLanguages())
        );
    }

    @PostMapping("/languages")
    public String addLanguage(@ModelAttribute Language language) {
        languageService.saveLanguage(language);
        return "redirect:/languages";
    }

    @GetMapping("/languages/{language}/delete")
    public String deleteLanguage(@PathVariable String language) {
        languageService.deleteLanguageByName(language);
        return "redirect:/languages";
    }
}
