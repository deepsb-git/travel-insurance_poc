package com.digi.repository;

import com.digi.entity.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory,Integer> {
}
