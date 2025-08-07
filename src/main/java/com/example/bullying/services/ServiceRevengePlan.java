package com.example.bullying.services;

import com.example.bullying.exceptions.NameException;
import com.example.bullying.dao.IBullyDAO;
import com.example.bullying.dao.IRevengePlanDAO;
import com.example.bullying.dto.RevengePlanDTO;
import com.example.bullying.models.Bully;
import com.example.bullying.models.RevengePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRevengePlan implements IServiceRevengePlan {

    @Autowired
    private IRevengePlanDAO revengePlanDAO;

    @Autowired
    private IBullyDAO bullyDAO;

    @Override
    public List<RevengePlanDTO> getRevengePlans() {
        return revengePlanDAO.findAll().stream().map(
                revengePlan -> new RevengePlanDTO(
                        revengePlan.getTitle(),
                        revengePlan.getDescription(),
                        revengePlan.getBully() != null ? revengePlan.getBully().getId() : null,
                        revengePlan.getIsExecuted(),
                        revengePlan.getDatePlanned(),
                        revengePlan.getSuccessLevel()
                )
        ).toList();
    }

    @Override
    public void addRevengePlan(RevengePlanDTO dto) {
        // Buscar al Bully
        Bully bully = bullyDAO.findById(dto.bullyId())
                .orElseThrow(() -> new RuntimeException("Bully no encontrado"));

        // Crear el plan
        RevengePlan plan = new RevengePlan();
        plan.setTitle(dto.title());
        plan.setDescription(dto.description());
        plan.setIsExecuted(dto.isExecuted());
        plan.setDatePlanned(dto.datePlanned());
        plan.setSuccessLevel(dto.successLevel());
        plan.setBully(bully);

        // Validar existencia por título (puedes cambiar la lógica si el título no es único)
        RevengePlan busqueda =
                revengePlanDAO.findRevengePlanByTitle(plan.getTitle()).orElse(null);
        if (busqueda != null) {
            throw new NameException("RevengePlan already exists");
        }

        revengePlanDAO.save(plan);
    }


    @Override
    public void removeRevengePlan(String title) {
        Optional<RevengePlan> plan = revengePlanDAO.findRevengePlanByTitle(title);
        plan.ifPresent(revengePlanDAO::delete);
    }

    @Override
    public List<RevengePlan> getRevengePlansByBullyName(String bullyName) {
        return revengePlanDAO.findByBully_Name(bullyName);
    }



}
