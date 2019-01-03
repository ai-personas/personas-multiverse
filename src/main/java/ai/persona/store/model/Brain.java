package ai.persona.store.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Brain {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @JsonProperty("name")
    private String personaName;

    @JsonProperty("age")
    private int age;

    @Lob
    @JsonProperty("personaBrain")
    private String personaBrain;
}
