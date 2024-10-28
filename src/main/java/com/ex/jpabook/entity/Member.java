package com.ex.jpabook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {
    @Id
    private String id;
    @Column(name = "NAME")
    private String userName;
    private Integer age;
}
