package edu.miu.waa.lab.assignments.entity;

//import javax.persistence.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    // ID indicates that table has primary key
    @Id
    // automatic increment works here
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
//    private List<Post> posts;
}
