package com.neoris.controllers;

import com.neoris.repositories.PieRepository;
import com.neoris.models.Pie;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sergio.angulo on 22/02/2017.
 */

@RestController
@RequestMapping("/pies")
public class PieController {

    @Autowired
    private PieRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Pie>> getAllPies() {
        return new ResponseEntity<>((Collection<Pie>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Pie> getPieWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = { "name" })
    public ResponseEntity<Collection<Pie>> findPieWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPie(@RequestBody Pie input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
}
