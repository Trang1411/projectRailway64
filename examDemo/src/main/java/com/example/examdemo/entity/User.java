package com.example.examdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity(name = "userr")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "userId")
    private Integer id;
    @Column(name = "userName", length = 50)
    private String userName;

    //mappedby trỏ tới tên biến user trong bảng Group
    @ManyToMany(mappedBy = "users")
    private List<Group> groups;

    public User(Integer id, String userName){
        this.id = id;
        this.userName = userName;
    }
}
