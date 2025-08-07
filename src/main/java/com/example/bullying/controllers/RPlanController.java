package com.example.bullying.controllers;

import com.example.bullying.dao.IRevengePlanDAO;
import com.example.bullying.dto.RevengePlanDTO;
import com.example.bullying.models.RevengePlan;
import com.example.bullying.services.IServiceRevengePlan;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/revenge-plan")
public class RPlanController {
    @Autowired
    private IServiceRevengePlan revengePlan;

    @GetMapping("/")
    public List<RevengePlanDTO> getRevengePlans(){
        return revengePlan.getRevengePlans();
    }

    @PostMapping("/")
    public ResponseEntity<?> addRevengePlan(@RequestBody @Valid RevengePlanDTO revengePlanDTO) {
        System.out.println(revengePlanDTO);
        revengePlan.addRevengePlan(revengePlanDTO);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{title}")
    public void removeRevengePlan(@PathVariable String title) {
        revengePlan.removeRevengePlan(title);

    }

    @GetMapping("/bully/{bullyName}")
    public ResponseEntity<List<RevengePlan>> getRevengePlanByBullyName(@PathVariable String bullyName) {
        List<RevengePlan> plans = revengePlan.getRevengePlansByBullyName(bullyName);
        if (plans.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(plans);
        }
    }

}
