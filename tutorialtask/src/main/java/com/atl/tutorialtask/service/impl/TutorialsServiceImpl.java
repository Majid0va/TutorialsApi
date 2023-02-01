package com.atl.tutorialtask.service.impl;

import com.atl.tutorialtask.dto.TutorialsDto;
import com.atl.tutorialtask.exception.NoSuchElementException;
import com.atl.tutorialtask.exception.TutorialAlreadyExistsException;
import com.atl.tutorialtask.mapper.TutorialsMapper;
import com.atl.tutorialtask.model.Tutorials;
import com.atl.tutorialtask.repository.TutorialsRepository;
import com.atl.tutorialtask.service.TutorialsService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class TutorialsServiceImpl implements TutorialsService1 {

    @Autowired
    TutorialsRepository tutorialsRepository;


    TutorialsMapper tutorialsMapper;

    @Override
    public List<TutorialsDto> getAllTutorials() {
        try {
            log.info("Request was sent to DataBase");
            List<Tutorials> employees = tutorialsRepository.findAll();
            return employees.stream()
                    .map(TutorialsMapper.MAPPER::tutorialsToTutorialsDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Exception caught { }", e);
            throw new RuntimeException();
        }
    }


    @Override
    public TutorialsDto getTutorialById(Long id) {
        log.info("Get Request was sent to DataBase");
        Optional<Tutorials> existingTutorial = tutorialsRepository.findById(id);

        TutorialsDto tutorialsDto = TutorialsMapper.MAPPER.tutorialsToTutorialsDto(existingTutorial.get());


        if (existingTutorial != null) {
            return tutorialsDto;
        } else {
            throw new NoSuchElementException("No  tutorial present with id=" + id);
        }

    }


    @Override
    public TutorialsDto createTutorial(TutorialsDto t) {
        try {

            log.info("Post Request was sent to DataBase");

            Tutorials tutorials = TutorialsMapper.MAPPER.tutorialsDtoToTutorials(t);

            tutorialsRepository.save(new Tutorials(tutorials.getTitle(),tutorials.getDescription(),t.isPublished()));
            return t;

        } catch (Exception e) {
            log.error("Exception catched");
            e.printStackTrace();
            throw new TutorialAlreadyExistsException("Tutorial already exists!");

        }

    }

    @Override
    public TutorialsDto updateTutorial(TutorialsDto tutorialsDto) {

        Tutorials players1 = tutorialsRepository.save(TutorialsMapper.MAPPER.tutorialsDtoToTutorials(tutorialsDto));
        TutorialsDto tutorialsDto1 = TutorialsMapper.MAPPER.tutorialsToTutorialsDto(players1);
        return tutorialsDto1;
    }
//    @Override
//    public String updateTutorial(Long id, TutorialsDto t2) {
//        log.info("Put Request was sent to DataBase");
//
//        Optional<Tutorials> tutorials = tutorialsRepository.findById(id);
//        TutorialsDto tutorialsDto = tutorialsMapper.tutorialsToTutorialsDto(tutorials.get());
//
//        if (tutorialsDto != null) {
//            tutorialsDto.setId(Long.valueOf(id));
//            tutorialsDto.setTitle(t2.getTitle());
//            tutorialsDto.setDescription(t2.getDescription());
//            tutorialsDto.setPublished(t2.isPublished());
//            tutorialsRepository.update(id, tutorialsDto);
//            return "Tutorial was updated successfully.";
//        } else {
//            throw new NoSuchTutorialExistsException("Cannot find Tutorial with id=" + id);
//        }
//    }


    @Override
    public ResponseEntity<String> deleteAllTutorials() {
        try {
            log.info("Delete Request was sent to DataBase");

            tutorialsRepository.deleteAll();
            return new ResponseEntity<>("Deleted " + " Tutorials successfully.", HttpStatus.OK);
        } catch (
                Exception e) {
            log.error("Exception catched");
            e.printStackTrace();
            return new ResponseEntity<>("Cannot delete tutorials.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public ResponseEntity<String> deleteTutorialById(Long id) {
        try {
            log.info("Delete Request was sent to DataBase");

            tutorialsRepository.deleteById(id);
            return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception catched");
            e.printStackTrace();
            return new ResponseEntity<>("Cannot delete tutorial.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public Page<TutorialsDto> findByPublished(boolean published, int page, int size) {
        try {
            log.info("Get Request was sent to DataBase");
            Page<Tutorials> t = tutorialsRepository.findTutorialsByPublished(published, PageRequest.of(page, size));
            List<Tutorials> tutorialsList = t.toList();

            List<TutorialsDto> tutorialsDtoList = tutorialsList.stream()
                    .map(TutorialsMapper.MAPPER::tutorialsToTutorialsDto)
                    .collect(Collectors.toList());

            Page<TutorialsDto> tutorialsDtoPage = new PageImpl<>(tutorialsDtoList);

            return tutorialsDtoPage;

        } catch (Exception e) {
            log.error("Exception catched");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
