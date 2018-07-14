package com.footballobzor.demo.persistance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
public class FileEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    private String url;

    private String name;

    public FileEntity(String url, String name) {
        this.url = url;
        this.name = name;
    }
}
