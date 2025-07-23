package com.digi.service;

import com.digi.entity.PlanCategory;
import com.digi.entity.TravelPlan;
import com.digi.repository.IPlanCategoryRepository;
import com.digi.repository.ITravelPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {

    @Autowired
    private ITravelPlanRepository travelPlanRepo;
    @Autowired
    private IPlanCategoryRepository planCategoryRepo;

    @Override
    public String registerTravelPlan(TravelPlan plan) {
        // Save the travel plan to the repository
        TravelPlan saved=travelPlanRepo.save(plan);
//        //novice code
//        if(saved.getPlanId() != null) {
//            return "Travel plan registered successfully with ID: " + saved.getPlanId();
//        }
//        else {
//            return "Failed to register travel plan.";
//        }
        return saved.getPlanId()!= null ? "Travel plan registered successfully with ID: " + saved.getPlanId() : "Failed to register travel plan.";
    }

    @Override
    public Map<Integer, String> getTravelPlanCategories() {
        // Fetch all plan categories from the repository
        List<PlanCategory> list = planCategoryRepo.findAll();
        Map<Integer, String> categoriesMap = new HashMap<>();
        list.forEach(category->{
            categoriesMap.put(category.getCategoryId(), category.getCategoryName());
        });

        return categoriesMap;
    }

    @Override
    public List<TravelPlan> showAllTravelPlans() {
        return travelPlanRepo.findAll();
    }

    @Override
    public TravelPlan showTravelPlanById(Integer planId) {
        return travelPlanRepo.findById(planId).orElseThrow(()-> new IllegalArgumentException("Travel plan with ID " + planId + " not found"));
    // Fetch the travel plan by ID from the repository
//        Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
//        if (opt.isPresent()) {
//            return opt.get();
//        }else {
//            // Handle the case where the travel plan is not found
//            throw new IllegalArgumentException("Travel plan with ID " + planId + " not found");
//        }
    }

    @Override
    public String updateTravelPlan(TravelPlan plan) {
        Optional<TravelPlan> opt = travelPlanRepo.findById(plan.getPlanId());
        if(opt.isPresent()) {
            //updated the object
            travelPlanRepo.save(plan);
            return "Travel plan updated successfully with ID: " + plan.getPlanId();
        }else{
            return "Travel plan not found with ID: " + plan.getPlanId();
        }
    }

    @Override
    public String deleteTravelPlan(Integer planId) {
        Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
        if(opt.isPresent()) {
            travelPlanRepo.deleteById(planId);
            return "Travel plan deleted successfully with ID: " + planId;
        }
        else {
            return "Travel plan not found with ID: " + planId;
        }
    }

    @Override
    public String changeTavelPlanStatus(Integer planId, String status) {
        Optional<TravelPlan> opt = travelPlanRepo.findById(planId);
        if(opt.isPresent()) {
            TravelPlan plan = opt.get();
            // Assuming 'status' is a field in TravelPlan to indicate active/inactive
            plan.setActiveSW(status);
            travelPlanRepo.save(plan);
            return "Travel plan status changed successfully to: " + status + " for ID: " + planId;
        }
        else {
            return "Travel plan not found with ID for Updation: " + planId;
        }
    }
}
