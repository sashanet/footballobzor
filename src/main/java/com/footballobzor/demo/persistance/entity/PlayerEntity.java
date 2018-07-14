package com.footballobzor.demo.persistance.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "players")
@SQLDelete(sql = "UPDATE users SET ACTIVE_FLAG = false WHERE id = ?")
@Data
public class PlayerEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    private String name;
    private String fullName;
    private Date birthDate;
    private String imageUrl;
}
