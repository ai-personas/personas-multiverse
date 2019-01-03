package ai.persona.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class PersonaDef {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @JsonProperty("personaName")
    private String personaName;

    @Lob
    @JsonProperty("personaDef")
    private String personaDef;
}
