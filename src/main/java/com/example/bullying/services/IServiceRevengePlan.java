package com.example.bullying.services;

import com.example.bullying.dto.RevengePlanDTO;
import com.example.bullying.models.RevengePlan;

import java.util.List;
import java.util.Optional;

public interface IServiceRevengePlan {
    public List<RevengePlanDTO> getRevengePlans();
    public void addRevengePlan(RevengePlanDTO dto);
    public void removeRevengePlan(String title);
    public List<RevengePlan> getRevengePlansByBullyName(String BullyName);
}
