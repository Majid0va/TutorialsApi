package com.atl.tutorialtask.dto;

import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Setter
@Getter
@Builder
@AllArgsConstructor
@ToString

public class TutorialsDto {
    @NotNull(message = "Id is not be null")
    private Long id;
    @Size(min = 2, message = "Required")
    private String title;
    private String description;
    @AssertTrue(message = "Only true")
    private boolean published;

    public TutorialsDto() {
    }


    public TutorialsDto(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }


}