package com.example.bullying.controllers;

import com.example.bullying.dto.MediaDTO;
import com.example.bullying.services.IServiceMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.bullying.models.Media;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    private IServiceMedia serviceMedia;

    @GetMapping("/")
    public List<MediaDTO> getAllMedia() {
        return serviceMedia.getAllMedia();
    }

    @PostMapping("/")
   public Media addMedia(@RequestBody MediaDTO dto) {
        return serviceMedia.addMedia(dto);
   }
}
