package com.example.bullying.services;
import com.example.bullying.dao.IBullyDAO;
import com.example.bullying.dao.ICliqueDAO;
import com.example.bullying.exceptions.NameException;
import com.example.bullying.models.Clique;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bullying.dto.BullyDTO;
import org.springframework.stereotype.Service;
import com.example.bullying.models.Bully;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ServiceBully implements IServiceBully {
    @Autowired
    private IBullyDAO bullyDAO;

    @Autowired
    private ICliqueDAO cliqueDAO;

    @Override
    public List<BullyDTO> getBullies() {
        return bullyDAO.findAll().stream()
                .map(bully -> new BullyDTO(
                        bully.getName(),
                        bully.getNickname(),
                        bully.getHighSchoolRole(),
                        bully.getBullyingReason(),
                        bully.getLevelOfAnnoyance(),
                        bully.getClique() != null ? bully.getClique().getName() : null
                ))
                .collect(Collectors.toList());
    }


    @Override
    public void addBully(BullyDTO b) {
        Bully newBully = new Bully();
        newBully.setName(b.name());
        newBully.setNickname(b.nickname());
        newBully.setHighSchoolRole(b.highSchoolRole());
        newBully.setBullyingReason(b.bullyingReason());
        newBully.setLevelOfAnnoyance(b.levelOfAnnoyance());

        // Buscar el clique por nombre
        Clique clique = cliqueDAO.findCliqueByName(b.cliqueName())
                .orElseThrow(() -> new RuntimeException("El clique no existe"));

        newBully.setClique(clique);

        Bully busqueda = bullyDAO.findBullyByName(newBully.getName()).orElse(null);
        if (busqueda != null)
            throw new NameException("El bully con este nombre ya existe");

        bullyDAO.save(newBully);
    }



    public void removeBully(String name) {
        Bully b = bullyDAO.findBullyByName(name).orElse(null);
        if (b == null)
            throw new NameException("No se encontro el bully");
        bullyDAO.delete(b);
    }

    public Bully getBullyByName(String name) {
        Bully b = bullyDAO.findBullyByName(name).orElse(null);
        if (b == null)
            throw new NameException("No se encontro el bully");
        return b;
    }

    public Optional<Bully> getBullyById(Long id) {
        return null;
    }
}
