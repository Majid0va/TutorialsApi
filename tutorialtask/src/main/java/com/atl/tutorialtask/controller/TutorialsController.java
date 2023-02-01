package com.atl.tutorialtask.controller;

import com.atl.tutorialtask.dto.TutorialsDto;
import com.atl.tutorialtask.service.impl.TutorialsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1")
@Validated
public class TutorialsController {
    @Autowired
    TutorialsServiceImpl tutorialsService;


    //    @ApiOperation(value = "Get all tutorials", notes = "Returns all tutorials")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved"),
//            @ApiResponse(code = 404, message = "Not found - The tutorials were not found")})
    @GetMapping()
    public String getAllTutorials(Model model) {
        model.addAttribute("tutorials", tutorialsService.getAllTutorials());
        return "homePage";
    }


//    @ApiOperation(value = "Get a tutorial by id", notes = "Returns a tutorial as per the id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved"),
//            @ApiResponse(code = 404, message = "Not found - The tutorial was not found")})
//    @GetMapping("/tutorials/{id}")
//    public TutorialsDto getTutorialById(@PathVariable  Long id) {
//        return tutorialsService.getTutorialById(id);
//    }

    @GetMapping("/tutorials/new")
    public String createPlayersForm(Model model) {
        TutorialsDto tutorial = new TutorialsDto();
        model.addAttribute("tutorial", tutorial);
        return "insert";

    }

    //    @ApiOperation(value = "Create new tutorial", notes = "Return new tutorial")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved"),
//            @ApiResponse(code = 404, message = "Tutorial already Exist")})
    @PostMapping("/tutorials")
    public String createTutorial(@Valid @ModelAttribute("tutorial") TutorialsDto tutorialsDto) {
        tutorialsService.createTutorial(tutorialsDto);
        return "redirect:/";
    }


    //    @ApiOperation(value = "Update a tutorial by id", notes = "Returns the tutorial that was update")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved"),
//            @ApiResponse(code = 404, message = "Not found - The tutorial was not found")})
//    @PutMapping("/tutorials/{id}")
//    public String updateTutorial(@PathVariable("id") Long id, @RequestBody TutorialsDto tutorialsDto2) {
//        return tutorialsService.updateTutorial(id, tutorialsDto2);
//    }
    @GetMapping("/tutorials/edit/{id}")
    public String editPlayerForm(@PathVariable Long id, Model model) {
        model.addAttribute("tutorial", tutorialsService.getTutorialById(id));
        return "update";
    }

    @PostMapping("/tutorials/{id}")
    public String updatePlayer(@PathVariable Long id, @ModelAttribute("tutorial") TutorialsDto tutorial, Model model) {

        TutorialsDto existingTutorial = tutorialsService.getTutorialById(id);
        existingTutorial.setId(id);
        existingTutorial.setTitle(tutorial.getTitle());
        existingTutorial.setDescription(tutorial.getDescription());
        existingTutorial.setPublished(tutorial.isPublished());

        tutorialsService.updateTutorial(existingTutorial);
        return "redirect:/";
    }

    //    @ApiOperation(value = "Delete the tutorial by id")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved"),
//            @ApiResponse(code = 404, message = "Not found - The tutorial was not found")})
    @GetMapping("/tutorials/{id}")
    public String deleteTutorialById(@PathVariable Long id) {
        tutorialsService.deleteTutorialById(id);
        return "redirect:/";
    }


//    @ApiOperation(value = "Delete All Tutorials")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved"),
//            @ApiResponse(code = 404, message = "Not found - The tutorials was not found")})
//    @DeleteMapping("/tutorialsDelete")
//    public ResponseEntity<String> deleteAllTutorials() {
//        return tutorialsService.deleteAllTutorials();
//    }


//    @ApiOperation(value = "Get  tutorials that were published", notes = "Returns published tutorials ")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved"),
//            @ApiResponse(code = 404, message = "Not found - The tutorials was not found")})
//    @GetMapping("/tutorials/published")
//    public ResponseEntity<Page<TutorialsDto>> findByPublished(@RequestParam(value = "page", defaultValue = PAGE) int page,
//                                                              @RequestParam(value = "size", defaultValue = SIZE) int size) {
//        Page<TutorialsDto> tutorialsDto = tutorialsService.findByPublished(true, page, size);
//        return ResponseEntity.ok(tutorialsDto);
//    }
}