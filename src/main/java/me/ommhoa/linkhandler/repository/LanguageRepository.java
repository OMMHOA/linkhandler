package me.ommhoa.linkhandler.repository;

import me.ommhoa.linkhandler.model.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends CrudRepository<Language, String> {}
