package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TelevisionController {

    @Autowired
    private TelevisionRepository televisionRepository;

    @GetMapping("/televisions")
    public ResponseEntity<Object> getAllTelevisions() {

        // Return een String met een 200 status
        return ResponseEntity.ok("televisions");

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable("id") Long id) {
    Optional<Television> savedTelevision = televisionRepository.findById(id);
        // return een String met een 200 status
        return ResponseEntity.ok(savedTelevision.get());

    }

    @PostMapping("/televisions")
    public ResponseEntity<Television> addTelevision(@RequestBody Television television) {
    Television savedTelevision  = televisionRepository.save(television);
        // Return een String met een 201 status
        //De null van created zal over een paar weken vervangen worden door een gegenereerde url.
        return ResponseEntity.created(null).body(savedTelevision);

    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable int id) {

        //Return een 204 status
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {

        // Return een 204 status
        return ResponseEntity.noContent().build();

    }


}
