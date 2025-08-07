package com.example.bullying.services;

import com.example.bullying.Exceptions.NameException;
import com.example.bullying.dao.IBullyDAO;
import com.example.bullying.dao.IRevengePlanDAO;
import com.example.bullying.dto.RevengePlanDTO;
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
                revengePlan -> {
                    return new RevengePlanDTO(
                            revengePlan.getTitle(),
                            revengePlan.getDescription(),
                            revengePlan.getIsExecuted(),
                            revengePlan.getDatePlanned(),
                            revengePlan.getSuccessLevel()
                    );
                }
        ).toList();


    }

    @Override
    public RevengePlan addRevengePlan(RevengePlanDTO dto) {
        RevengePlan plan = new RevengePlan();
        plan.setTitle(dto.title());
        plan.setDescription(dto.description());
        plan.setIsExecuted(dto.isExecuted());
        plan.setDatePlanned(dto.datePlanned());
        plan.setSuccessLevel(dto.successLevel());
        RevengePlan busqueda =
                 revengePlanDAO.findRevengePlanById(plan.getId()).orElse(null);
        if (busqueda != null) {
            throw new NameException("RevengePlan already exists");
        }
        return revengePlanDAO.save(plan);

    }


    @Override
    public Optional<RevengePlan> removeRevengePlan(Long id) {
        Optional<RevengePlan> plan = revengePlanDAO.findById(id);
        plan.ifPresent(revengePlanDAO::delete);
        return plan;
    }

    @Override
    public Optional<RevengePlan> getRevengePlansByBullyId(Long BullyId) {
        return revengePlanDAO.findById(BullyId);
    }



}
