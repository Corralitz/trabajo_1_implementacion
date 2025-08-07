package com.example.bullying.services;

import com.example.bullying.dto.CliqueDTO;
import com.example.bullying.models.Bully;
import com.example.bullying.models.Clique;

import java.util.List;
import java.util.Optional;

public interface IServiceClique {
    public List<CliqueDTO> getCliques();
    public Clique addClique(CliqueDTO cliqueDTO);
    public Optional<Clique> removeClique(Long id);
    public Optional<Clique> getCliqueById(Long Id);
    public Optional<Clique> getCliqueByName(String name);
}
