package com.atl.tutorialtask.service;

import com.atl.tutorialtask.dto.TutorialsDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface TutorialsService1 {
    List<TutorialsDto> getAllTutorials();

    TutorialsDto getTutorialById(Long id);

    TutorialsDto createTutorial(TutorialsDto t);

     TutorialsDto updateTutorial(TutorialsDto t2);

    ResponseEntity<String> deleteAllTutorials();

    ResponseEntity<String> deleteTutorialById(Long id);

    Page<TutorialsDto> findByPublished(boolean published, int page, int size);


}
