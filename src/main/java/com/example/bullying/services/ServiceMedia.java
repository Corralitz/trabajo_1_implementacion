package com.example.bullying.services;

import com.example.bullying.Exceptions.NameException;
import com.example.bullying.dao.IMediaDAO;
import com.example.bullying.dto.MediaDTO;
import com.example.bullying.models.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMedia implements IServiceMedia {
    @Autowired
    private IMediaDAO mediaDao;


    @Override
    public List<MediaDTO> getMoodLevels() {
        return mediaDao.findAll().stream().map(
                media -> {
                    return new MediaDTO(
                            media.getType(),
                            media.getUrl(),
                            media.getCaption()
                    );
                }
        ).toList();
    }

    @Override
    public Media addMoodLevel(MediaDTO dto) {
        Media media = new Media();
        media.setType(dto.type());
        media.setUrl(dto.url());
        media.setCaption(dto.caption());
        Media busqueda = mediaDao.findById(media.getId())
                .orElse(null);
        if (busqueda != null) {
            throw new NameException("Media existente");
        }

        return mediaDao.save(media);
    }

    @Override
    public Optional<Media> removeMoodLevel(Long id) {
        Optional<Media> media = mediaDao.findById(id);
        media.ifPresent(mediaDao::delete);
        return media;
    }

    @Override
    public Optional<Media> getMoodLevelById(Long id) {
        return mediaDao.findById(id);
    }
}
