package mx.edu.utez.marketplace.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mx.edu.utez.marketplace.user.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 20)
    String description;
    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private Set<User> users;

    public Role() {
    }

    public Role(String description) {
        this.description = description;
    }

    public Role(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
