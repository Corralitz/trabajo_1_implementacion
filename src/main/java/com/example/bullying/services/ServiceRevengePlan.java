package com.example.bullying.services;

import com.example.bullying.dao.IBullyDAO;
import com.example.bullying.dao.IMoodLevelDAO;
import com.example.bullying.dao.IRevengePlanDAO;
import com.example.bullying.dto.RevengePlanDTO;
import com.example.bullying.models.Bully;
import com.example.bullying.models.RevengePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRevengePlan implements IServiceRevengePlan {

    @Autowired
    private IRevengePlanDAO revengePlanDAO;

    @Autowired
    private IBullyDAO bullyDAO;

    @Override
    public List<RevengePlan> getRevengePlans() {
        return revengePlanDAO.findAll();
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

        if (busqueda != null){

        }

    }


    @Override
    public Optional<RevengePlan> removeRevengePlan(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<RevengePlan> getRevengePlansByBullyId(Long BullyId) {
        return Optional.empty();
    }

    @Override
    public Optional<RevengePlan> getRevengePlanByTittle(String title) {
        return Optional.empty();
    }


}
