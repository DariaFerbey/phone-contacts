package software.chiacademy.phonecontacts.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long id;


    @Column
    private String name;

    @ElementCollection
    @CollectionTable
    //@Pattern(regexp = "^(.+)@(.+)$")
    //@Email
    private List<String> emails;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean enabled;

    @ElementCollection
    @CollectionTable
    //@Pattern(regexp = "^\\+?3?8?0?\\d{2}?\\d{3}\\d{2}\\d{2}$")
    public List<String> phones;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Role> roles = new HashSet<>();
}
