package com.example.examdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "groupp")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group {
    @javax.persistence.Id
    @Id
    @Column(name = "groupId")
    int id;
    @Column(name = "groupName", length = 50)
    private String groupName;
    @Column(name = "member")
    private int member;
    @Column(name = "createDate")
    private Date createDate;
    @OneToOne
    @JoinColumn(name = "userId")
    private User creator;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // LAZY để tránh truy xuất dữ liệu không cần thiết, khi nào cần thì mới query
    @JoinTable(name = "group_user",
            joinColumns = @JoinColumn(name = "groupId"), // khóa ngoại trỏ đến class hiện tại (Group)
            inverseJoinColumns = @JoinColumn(name = "userId")) //khóa ngoại trỏ đến thuộc tính dươi db
    private List<User> users;
}
