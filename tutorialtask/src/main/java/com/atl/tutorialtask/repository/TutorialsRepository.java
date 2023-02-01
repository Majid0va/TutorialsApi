package com.atl.tutorialtask.repository;

import com.atl.tutorialtask.dto.TutorialsDto;
import com.atl.tutorialtask.model.Tutorials;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialsRepository extends JpaRepository<Tutorials, Long> {
//    @Query(value = "insert tutorialstable value(title,description,published)", nativeQuery = true)
//    @Modifying
//    int save(TutorialsDto t2); //*

    //    @Modifying
//    @Query(value = "update tutorialstable set Tut= ?2 where id = ?1", nativeQuery = true)
//    int update(Long id, TutorialsDto t2);
//
//    @Query(value = "select * from tutorialstable where id = ?1", nativeQuery = true)
//    Tutorials findById(Long id);
//
//    @Modifying
//    @Query(value = "delete from tutorialstabe t where t.id= :id", nativeQuery = true)
//    int deleteById(Long id);
//
////    @Query(value = "Select * from tutorialstable", nativeQuery = true)
////    List<Tutorials> findAll();
//
//    @Query(value = "select * from tutorialstable where published = ?1", countQuery = "SELECT count(*) FROM tutorialstable", nativeQuery = true)
//    Page<TutorialsDto> findByPublished(boolean published, Pageable pageable);
//
//    @Query(value = "select * from tutorialstable where title = ?1", nativeQuery = true)
//    List<TutorialsDto> findByTitleContaining(String title);
    Page<Tutorials> findTutorialsByPublished(boolean published,Pageable pageable);

//    Tutorials findTutorialsById(Long id);
//
//    @Modifying
//    @Query(value = "Delete * from tutorialstable", nativeQuery = true)
//    void deleteAll();

//    List<Tutorials> findTutorialsByDeleteFalse();
}
