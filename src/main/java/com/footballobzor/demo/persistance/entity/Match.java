package com.footballobzor.demo.persistance.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "matchs")
@SQLDelete(sql = "UPDATE matchs SET deleted = false WHERE id = ?")
@Data
public class Match {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "broadcasts_matchs",
            joinColumns = { @JoinColumn(name = "match_id") },
            inverseJoinColumns = { @JoinColumn(name = "broadcast_id") })
    private Set<BroadcastEntity> broadcasts = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team1_id", nullable = false)
    private Team team1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team2_id", nullable = false)
    private Team team2;

    private Boolean deleted;
}
