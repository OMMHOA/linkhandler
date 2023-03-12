package me.ommhoa.linkhandler.service;

import com.google.common.collect.ImmutableList;
import me.ommhoa.linkhandler.model.Language;
import me.ommhoa.linkhandler.repository.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LanguageService {
    private static final Logger logger = LoggerFactory.getLogger(LanguageService.class);

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getLanguages() {
        return ImmutableList.copyOf(languageRepository.findAll());
    }

    public void saveLanguage(Language language) {
        logger.info("Saving language " + language);
        languageRepository.save(language);
    }

    public void deleteLanguageByName(String languageName) {
        logger.info("Deleting language " + languageName);
        languageRepository.delete(new Language(languageName));
    }
}
