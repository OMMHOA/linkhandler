package me.ommhoa.linkhandler.view;

import me.ommhoa.linkhandler.model.Language;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Component
public class LanguageView {
    static final String PAGE = "languages";
    public static class Parameters {
        private Language newLanguage;
        private List<Language> languages;

        public Parameters setNewLanguage(Language newLanguage) {
            this.newLanguage = newLanguage;
            return this;
        }

        public Parameters setLanguages(List<Language> languages) {
            this.languages = languages;
            return this;
        }
    }

    public String renderPage(Model model, Parameters params) {
        model.addAttribute("newLanguage", params.newLanguage);
        model.addAttribute("languages", params.languages);
        return PAGE;
    }
}
