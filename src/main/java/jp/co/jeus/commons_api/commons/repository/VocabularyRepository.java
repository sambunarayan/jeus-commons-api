package jp.co.jeus.commons_api.commons.repository;

import jp.co.jeus.commons_api.commons.repository.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {

}
