package com.footballobzor.demo.persistance.entity;

import com.footballobzor.demo.api.enums.Country;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
@SQLDelete(sql = "UPDATE teams SET deleted = false WHERE id = ?")
@Data
public class Team {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private String id;
    private String name;
    private String imageUrl;
    private String description;
    private Boolean deleted;

    @Enumerated(EnumType.STRING)
    private Country country;

    @OneToMany(mappedBy="team1", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Match> matchFirstTeam;

    @OneToMany(mappedBy="team2", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Match> matchSecondTeam;
}
