package com.example.bullying.services;

import com.example.bullying.dto.BullyDTO;
import com.example.bullying.models.Bully;

import java.util.List;
import java.util.Optional;

public interface IServiceBully {
    public List<BullyDTO> getBullies();
    public void addBully(BullyDTO bully);
    public void removeBully(String name);
    public Optional<Bully> getBullyById(Long id);
    public Bully getBullyByName(String name);
}
