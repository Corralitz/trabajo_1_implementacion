package com.example.bullying.services;
import com.example.bullying.dao.IBullyDAO;
import com.example.bullying.exceptions.NameException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bullying.dto.BullyDTO;
import org.springframework.stereotype.Service;
import com.example.bullying.models.Bully;

import java.util.Optional;
import java.util.List;

@Service
public class ServiceBully implements IServiceBully {
    @Autowired
    private IBullyDAO bullyDAO;

    @Override
    public List<BullyDTO> getBullies() {
        return bullyDAO.findAll().stream().map(
               bully -> new BullyDTO(
                           bully.getName(),
                           bully.getNickname(),
                           bully.getHighSchoolRole(),
                           bully.getBullyingReason(),
                           bully.getLevelOfAnnoyance()
               )
        ).toList();
    }

    @Override
    public void addBully(BullyDTO b) {
        Bully newBully = new Bully();
        newBully.setName(b.name());
        newBully.setNickname(b.nickname());
        newBully.setHighSchoolRole(b.highSchoolRole());
        newBully.setBullyingReason(b.bullyingReason());

        Bully busqueda = bullyDAO.findBullyByName(newBully.getName())
                .orElse(null);
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
