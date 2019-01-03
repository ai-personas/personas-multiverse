package ai.persona.store.dao;

import ai.persona.store.model.PersonaDef;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaDefRepository extends CrudRepository<PersonaDef, Integer> {

    List<PersonaDef> findByPersonaName(final String personaName);
}
