package com.atl.tutorialtask.mapper;

import com.atl.tutorialtask.dto.TutorialsDto;
import com.atl.tutorialtask.model.Tutorials;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-29T08:00:55-0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4.1 (JetBrains s.r.o.)"
)
public class TutorialsMapperImpl implements TutorialsMapper {

    @Override
    public TutorialsDto tutorialsToTutorialsDto(Tutorials tutorials) {
        if ( tutorials == null ) {
            return null;
        }

        TutorialsDto.TutorialsDtoBuilder tutorialsDto = TutorialsDto.builder();

        tutorialsDto.title( tutorials.getTitle() );
        tutorialsDto.description( tutorials.getDescription() );
        tutorialsDto.published( tutorials.isPublished() );
        tutorialsDto.id( tutorials.getId() );

        return tutorialsDto.build();
    }

    @Override
    public Tutorials tutorialsDtoToTutorials(TutorialsDto tutorialsDto) {
        if ( tutorialsDto == null ) {
            return null;
        }

        Tutorials.TutorialsBuilder tutorials = Tutorials.builder();

        tutorials.title( tutorialsDto.getTitle() );
        tutorials.description( tutorialsDto.getDescription() );
        tutorials.published( tutorialsDto.isPublished() );
        if ( tutorialsDto.getId() != null ) {
            tutorials.id( tutorialsDto.getId() );
        }

        return tutorials.build();
    }
}
