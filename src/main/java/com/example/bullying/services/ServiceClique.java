package com.example.bullying.services;
import com.example.bullying.dao.ICliqueDAO;
import com.example.bullying.dto.CliqueDTO;
import com.example.bullying.exceptions.NameException;
import com.example.bullying.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClique implements IServiceClique {
    @Autowired
    public ICliqueDAO cliqueDAO;

    @Override
    public List<CliqueDTO> getCliques() {
        return cliqueDAO.findAll().stream().map(
                clique -> new CliqueDTO(
                        clique.getName(),
                        clique.getDescription()
                )
        ).toList();
    }

    public Clique addClique(CliqueDTO c) {
        Clique newClique = new Clique();
        newClique.setName(c.name());
        newClique.setDescription(c.description());

        Clique foo = cliqueDAO.findCliqueByName(newClique.getName()).orElse(null);
        if (foo == null)
            throw new NameException("El grupo ya existe");
        return null;
    }

    public Optional<Clique> removeClique(Long id) {
        Clique foo = cliqueDAO.findById(id).orElse(null);
        if (foo == null)
            throw new NameException("El grupo no existe");
        cliqueDAO.deleteById(id);
        return null;
    }

    public Optional<Clique> getCliqueById(Long id) {
        return null;
    }

    public Optional<Clique> getCliqueByName(String name) {
        return null;
    }
}
