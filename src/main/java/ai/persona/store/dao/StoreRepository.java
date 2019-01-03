package ai.persona.store.dao;

import ai.persona.store.model.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends CrudRepository<Persona, Integer> {

    List<Persona> findByName(final String personaName);
}
