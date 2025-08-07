package com.example.bullying.controllers;

import com.example.bullying.dto.BullyDTO;
import com.example.bullying.models.Bully;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.bullying.services.IServiceBully;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bullies")
public class BullyController {
    @Autowired
    private IServiceBully serviceBully;

    @GetMapping("/")
    public List<BullyDTO> getBullies() {
       return serviceBully.getBullies();
    }

    @PostMapping("/")
    public void addBully(@RequestBody @Valid BullyDTO bully) {
       serviceBully.addBully(bully);
    }

    @DeleteMapping("/{name}")
    public void removeBully(@PathVariable String name) {
        serviceBully.removeBully(name);
    }

    @GetMapping("/{name}")
    public Bully getBullyByName(@PathVariable String name) {
        return serviceBully.getBullyByName(name);
    }
}