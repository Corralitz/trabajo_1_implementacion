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
    public Bully addBully(BullyDTO b) {
        Bully newBully = new Bully();
        newBully.setName(b.name());
        newBully.setNickname(b.nickname());
        newBully.setHighSchoolRole(b.highSchoolRole());
        newBully.setBullyingReason(b.bullyingReason());

        Bully busqueda = bullyDAO.findBullyByName(newBully.getName())
                .orElse(null);
        if (busqueda == null)
            throw new NameException("El bully con este nombre ya existe");

        return bullyDAO.save(newBully);
    }

    public Optional<Bully> removeBully(Long id) {
        Bully b = bullyDAO.findById(id).orElse(null);
        if (b == null) {
            throw new NameException("No se encontro el bully");
        }
        bullyDAO.deleteById(id);
        return null;
    }

    public Optional<Bully> getBullyByName(String name) {
        return null;
    }

    public Optional<Bully> getBullyById(Long id) {
        return null;
    }
}
