//package com.atl.tutorialtask.repository.impl;
//
//import com.atl.tutorialtask.dto.TutorialsDto;
//import com.atl.tutorialtask.model.Tutorials;
//import com.atl.tutorialtask.repository.TutorialsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.IncorrectResultSizeDataAccessException;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class JdbcTutorialRepository implements TutorialsRepository {
//    @Autowired
//
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public int save(TutorialsDto tutorial) {
//        return jdbcTemplate.update("INSERT INTO tutorialsTable (title, description, published) VALUES(?,?,?)",
//                new Object[]{tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished()});
//    }
//
//    @Override
//    public int update(TutorialsDto tutorial) {
//        return jdbcTemplate.update("UPDATE tutorialsTable SET title=?, description=?, published=? WHERE id=?",
//                new Object[]{tutorial.getTitle(), tutorial.getDescription(), tutorial.isPublished(), tutorial.getId()});
//
//    }
//
//    @Override
//    public Tutorials findById(Long id) {
//        try {
//            Tutorials tutorial = jdbcTemplate.queryForObject("SELECT * FROM tutorialsTable WHERE id=?",
//                    BeanPropertyRowMapper.newInstance(Tutorials.class), id);
//            return tutorial;
//        } catch (IncorrectResultSizeDataAccessException e) {
//            return null;
//        }
//    }
//
//    @Override
//    public int deleteById(Long id) {
//        return jdbcTemplate.update("DELETE FROM tutorialsTable WHERE id=?", id);
//    }
//
//    @Override
//    public List<TutorialsDto> findAll() {
//        return jdbcTemplate.query("SELECT * from tutorialsTable", BeanPropertyRowMapper.newInstance(TutorialsDto.class));
//    }
//
//    @Override
//    public List<TutorialsDto> findByPublished(boolean published) {
//        return jdbcTemplate.query("SELECT * from tutorialsTable WHERE published=?",
//                BeanPropertyRowMapper.newInstance(TutorialsDto.class), published);
//    }
//
//    @Override
//    public List<TutorialsDto> findByTitleContaining(String title) {
//        String q = "SELECT * from tutorialsTable WHERE title LIKE '%" + title + "%'";
//
//        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(TutorialsDto.class));
//    }
//
//    @Override
//    public int deleteAll() {
//        return jdbcTemplate.update("DELETE from tutorialsTable");
//    }
//}
