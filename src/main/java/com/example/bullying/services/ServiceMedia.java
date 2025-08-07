package com.example.bullying.services;

import com.example.bullying.dao.IRevengePlanDAO;
import com.example.bullying.exceptions.NameException;
import com.example.bullying.dao.IMediaDAO;
import com.example.bullying.dto.MediaDTO;
import com.example.bullying.models.Media;
import com.example.bullying.models.RevengePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMedia implements IServiceMedia {
    @Autowired
    private IMediaDAO mediaDao;

    @Autowired
    private IRevengePlanDAO revengePlanDao;

    @Override
    public List<MediaDTO> getAllMedia() {
        return mediaDao.findAll().stream().map(
                media -> new MediaDTO(
                        media.getType(),
                        media.getUrl(),
                        media.getCaption(),
                        media.getRevengePlan() != null ? media.getRevengePlan().getId() : null
                )
        ).toList();
    }

    @Override
    public Media addMedia(MediaDTO dto) {
        Media media = new Media();
        media.setType(dto.type());
        media.setUrl(dto.url());
        media.setCaption(dto.caption());

        // Buscar el RevengePlan al que se asignará el media
        RevengePlan revengePlan = revengePlanDao.findById(dto.revengePlanId())
                .orElseThrow(() -> new NameException("No se encontró el plan de venganza con ese ID"));

        media.setRevengePlan(revengePlan);

        return mediaDao.save(media);
    }

    @Override
    public Optional<Media> removeMedia(Long id) {
        Optional<Media> media = mediaDao.findById(id);
        media.ifPresent(mediaDao::delete);
        return media;
    }

    @Override
    public Optional<Media> getMediaById(Long id) {
        return mediaDao.findById(id);
    }
}
