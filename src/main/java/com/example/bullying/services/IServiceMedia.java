package com.example.bullying.services;

import com.example.bullying.dto.MediaDTO;
import com.example.bullying.models.Media;

import java.util.List;
import java.util.Optional;

public interface IServiceMedia {
    public List<MediaDTO> getAllMedia();
    public Media addMedia(MediaDTO dto);
    public Optional<Media> removeMedia(Long id);
    public Optional<Media> getMediaById(Long id);
}
