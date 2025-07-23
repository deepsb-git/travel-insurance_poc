package com.digi.repository;

import com.digi.entity.TravelPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {
    // Additional query methods can be defined here if needed
}
