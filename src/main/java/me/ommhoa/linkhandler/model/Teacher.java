package me.ommhoa.linkhandler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    String name;
    String telNum;
    String email;
    @OneToMany
    List<Language> languages;

    public Teacher(String name) {
        this.name = name;
    }
}
