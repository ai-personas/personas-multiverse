package ai.persona.store.controller;

import ai.persona.store.dao.BrainRepository;
import ai.persona.store.dao.PersonaDefRepository;
import ai.persona.store.dao.StoreRepository;
import ai.persona.store.model.Brain;
import ai.persona.store.model.Persona;
import ai.persona.store.model.PersonaAge;
import ai.persona.store.model.PersonaDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Services {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private PersonaDefRepository personaDefRepository;

    @Autowired
    private BrainRepository brainRepository;

    @RequestMapping(value="/get-persona-age/{personaName}/{age}", method=RequestMethod.GET,
            produces = "application/json")
    public PersonaAge getPersonaAge(@PathVariable String personaName, @PathVariable int age) {
        List<Persona> personaList = storeRepository.findByName(personaName);
        System.out.println("size:" + personaList.size());
        return personaList.stream().findFirst().get()
                .getAges().stream().filter(a-> a.getAge() == age).findFirst().get();
    }

    @RequestMapping(value="/get-persona/{personaName}", method=RequestMethod.GET,
            produces = "application/json")
    public Persona getPersona(@PathVariable String personaName) {
        List<Persona> personaList = storeRepository.findByName(personaName);
        System.out.println("///////////////" + personaList.size() );
        return personaList.stream().findFirst().orElse(null);
    }

    @RequestMapping(value="/save-new-persona", method = RequestMethod.POST,
                consumes = "application/json", produces = "application/json")
    public void putNewPersona(@RequestBody Persona persona) {
        Persona p = new Persona();
        p.setName(persona.getName());
        p.setDescription(persona.getDescription());
        storeRepository.save(p);
        p.addAges(persona.getAges());
        storeRepository.save(p);
    }

    @RequestMapping(value = "/save-new-age/{personaName}", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public void putNewAge(@PathVariable String personaName, @RequestBody PersonaAge newAge) {
        List<Persona> personaList = storeRepository.findByName(personaName);
        Persona p= personaList.stream().findFirst().get();
        p.addAge(newAge);
        storeRepository.save(p);
    }

    @RequestMapping(value = "/save-persona-def/{personaName}", method = RequestMethod.POST)
    public void savePersonaDef(@PathVariable String personaName, @RequestBody String personaDef) {
        PersonaDef newPersonaDef = PersonaDef.builder()
                .personaName(personaName)
                .personaDef(personaDef)
                .build();
        personaDefRepository.save(newPersonaDef);
    }

    @RequestMapping(value = "/save-brain/{personaName}/{age}", method = RequestMethod.POST)
    public void saveBrain(@PathVariable String personaName, @PathVariable int age,
                          @RequestBody String personaBrain) {
        Brain brain = Brain.builder()
                .personaName(personaName)
                .age(age)
                .personaBrain(personaBrain)
                .build();
        brainRepository.save(brain);
    }
}
