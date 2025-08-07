package com.example.bullying.controllers;

import com.example.bullying.dto.CliqueDTO;
import com.example.bullying.models.Clique;
import com.example.bullying.services.IServiceClique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliques")
public class CliqueController {
    @Autowired
    private IServiceClique serviceClique;

    @GetMapping("/")
    public List<CliqueDTO> getAllCliques() {
        return serviceClique.getCliques();
    }

    @PostMapping("/")
    public void addClique(@RequestBody CliqueDTO clique) {
        serviceClique.addClique(clique);
    }

    @DeleteMapping("/{name}")
    public void deleteClique(@PathVariable String name) {
        serviceClique.removeClique(name);
    }

    @GetMapping("/{name}")
    public Clique searchCliqueByName(@PathVariable String name) {
        return serviceClique.getCliqueByName(name);
    }
}
