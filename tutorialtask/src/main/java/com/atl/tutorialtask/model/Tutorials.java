package com.atl.tutorialtask.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tutorials")
public class Tutorials {
    @ApiModelProperty(notes = "Tutorial ID", example = "1", required = true)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @ApiModelProperty(notes = "Tutorial title", example = "A", required = false)
    @Column(name = "title")
    private String title;

//    @ApiModelProperty(notes = "Tutorial description", example = "Back-end", required = true)
    @Column(name = "description")
    private String description;

//    @ApiModelProperty(notes = "Tutorial published", example = "true", required = true)
    @Column(name = "published")
    private boolean published;

    public Tutorials() {
    }


    public Tutorials(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }


}

