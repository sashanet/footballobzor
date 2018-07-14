package com.footballobzor.demo.persistance.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "broadcasts")
@SQLDelete(sql = "UPDATE broadcasts SET ACTIVE_FLAG = false WHERE id = ?")
@Data
public class BroadcastEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    private String imageUrl;

    private String bitrate;

    private String language;

    private String link;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "broadcasts")
    private Set<Match> matches = new HashSet<>();

}
