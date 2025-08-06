package com.example.bullying.services;

import com.example.bullying.dto.BullyDTO;
import com.example.bullying.models.Bully;

import java.util.List;
import java.util.Optional;

public interface IServiceBully {
    public List<BullyDTO> getBullies();
    public Bully addBully(BullyDTO bully);
    public Optional<Bully> removeBully(Long id);
    public Optional<Bully> getBullyById(Long id);
    public Optional<Bully> getBullyByName(String name);
}
