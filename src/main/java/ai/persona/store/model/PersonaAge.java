package ai.persona.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class PersonaAge {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @JsonProperty("age")
    private int age;

    @JsonProperty("storageType")
    private String storageType;

    @JsonProperty("storageParam")
    private String storageParam;

    @JsonProperty("timestamp")
    private long timestamp;

    @ManyToOne
    @JoinColumn(name="persona_id", nullable = false)
    @JsonIgnore
    private Persona persona;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageParam() {
        return storageParam;
    }

    public void setStorageParam(String storageParam) {
        this.storageParam = storageParam;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
