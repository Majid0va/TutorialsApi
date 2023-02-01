package com.atl.tutorialtask.service.impl;

import com.atl.tutorialtask.dto.TutorialsDto;
import com.atl.tutorialtask.model.Tutorials;
import com.atl.tutorialtask.repository.TutorialsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TutorialsServiceImplTest {
    @InjectMocks
    private TutorialsServiceImpl tutorialsService;

    @Mock
    private TutorialsRepository tutorialsRepository;


    @Test
    void getAllTutorials() {
        tutorialsService.getAllTutorials();
        verify(tutorialsRepository).findAll();
    }

    @Test
    void getTutorialById() {
//        TutorialsDto tutorialsDto = new TutorialsDto("Testt", "Testt2", true);
//        when(tutorialsRepository.findById(1L)).thenReturn();
//
//        long tutorialId = 1L;
//        when(tutorialsService.getTutorialById(tutorialId)).thenReturn(Optional.of(tutorialsDto));

        Long id = 1L;

        TutorialsDto tutorialsDto = tutorialsService.getTutorialById(id);

        assertEquals("Back-end", tutorialsDto.getTitle());
    }

    @Test
    void createTutorialTest() {
        TutorialsDto tutorialsDto = new TutorialsDto();
        tutorialsDto.setTitle("Test");
        tutorialsDto.setDescription("Test2");
        tutorialsDto.setPublished(true);
//        Tutorials tutorialsMock = mock(Tutorials.class);
//
//        when(tutorialsMock.getId()).thenReturn(1L);
//        when(tutorialsRepository.save(ArgumentMatchers.any(Tutorials.class))).thenReturn(tutorialsMock);
//        TutorialsDto result = tutorialsService.createTutorial(tutorialsDto);
//
//        assertEquals(result.getTitle(), tutorialsDto.getTitle());
//        assertEquals(result.getId(), 1L);

        tutorialsService.createTutorial(tutorialsDto);
        ArgumentCaptor<Tutorials> argumentCaptor = ArgumentCaptor.forClass(Tutorials.class);
        verify(tutorialsRepository).save(argumentCaptor.capture());
        Tutorials tutorials = argumentCaptor.getValue();

        assertEquals(tutorials, tutorialsDto);
    }

    @Test
    void deleteTutorialById() {
        TutorialsDto tutorialsDto = new TutorialsDto();
        tutorialsDto.setTitle("Test");
        tutorialsDto.setDescription("Test2");
        tutorialsDto.setPublished(true);
        Tutorials tutorialsMock = mock(Tutorials.class);
        when(tutorialsMock.getId()).thenReturn(1L);
        when(tutorialsRepository.save(ArgumentMatchers.any(Tutorials.class))).thenReturn(tutorialsMock);
        TutorialsDto result = tutorialsService.createTutorial(tutorialsDto);
        tutorialsService.deleteTutorialById(result.getId());

        assertNull(tutorialsRepository.findById(result.getId()));
    }
}