package com.atl.tutorialtask.mapper;


import com.atl.tutorialtask.dto.TutorialsDto;
import com.atl.tutorialtask.model.Tutorials;
import com.atl.tutorialtask.service.TutorialsService1;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper
public interface TutorialsMapper {
    TutorialsMapper MAPPER = Mappers.getMapper(TutorialsMapper.class);

    @Mappings({
            @Mapping(target = "title"),
            @Mapping(target = "description"),
            @Mapping(target = "published")})
    TutorialsDto tutorialsToTutorialsDto(Tutorials tutorials);



    @Mappings({
            @Mapping(target = "title"),
            @Mapping(target = "description"),
            @Mapping(target = "published")})
    Tutorials tutorialsDtoToTutorials(TutorialsDto tutorialsDto);
}


