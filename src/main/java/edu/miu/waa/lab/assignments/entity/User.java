package edu.miu.waa.lab.assignments.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    // ID indicates that table has primary key
    @Id
    // automatic increment works here
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
}
