package ai.persona.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tags")
    private String[] tags;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty("ages")
    private List<PersonaAge> ages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public List<PersonaAge> getAges() {
        return ages;
    }

    public void setAges(List<PersonaAge> ages) {
        this.ages = ages;
    }

    public void addAges(List<PersonaAge> ages) {
        ages.forEach(a -> a.setPersona(this));
        if (this.getAges() == null)
            this.setAges(new ArrayList<>());
        this.getAges().addAll(ages);
    }

    public void addAge(PersonaAge age) {
        age.setPersona(this);
        if (this.getAges() == null)
            this.setAges(new ArrayList<>());
        this.getAges().add(age);
    }
}
