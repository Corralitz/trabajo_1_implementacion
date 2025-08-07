package com.example.bullying.services;

import com.example.bullying.dto.CliqueDTO;
import com.example.bullying.models.Bully;
import com.example.bullying.models.Clique;

import java.util.List;
import java.util.Optional;

public interface IServiceClique {
    public List<CliqueDTO> getCliques();
    public void addClique(CliqueDTO cliqueDTO);
    public void removeClique(String name);
    public Optional<Clique> getCliqueById(Long Id);
    public Clique getCliqueByName(String name);
}
