package ai.persona.store.dao;

import ai.persona.store.model.Brain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrainRepository extends CrudRepository<Brain, Integer> {

    List<Brain> findByPersonaNameAndAge(final String personaName, final int age);
}
