package com.example.bullying.services;

import com.example.bullying.dto.RevengePlanDTO;
import com.example.bullying.models.RevengePlan;

import java.util.List;
import java.util.Optional;

public interface IServiceRevengePlan {
    public List<RevengePlan> getRevengePlans();
    public RevengePlan addRevengePlan(RevengePlanDTO dto);
    public Optional<RevengePlan> removeRevengePlan(Long id);
    public Optional<RevengePlan> getRevengePlansByBullyId(Long BullyId);
    public Optional<RevengePlan> getRevengePlanByTittle(String title);
}
