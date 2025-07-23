package com.digi.service;

import com.digi.entity.TravelPlan;

import java.util.List;
import java.util.Map;

public interface ITravelPlanMgmtService {
    public String registerTravelPlan(TravelPlan travelPlan);//save operation
    public Map<Integer,String> getTravelPlanCategories();//for select operation
    public List<TravelPlan> showAllTravelPlans();//for select operation
    public TravelPlan showTravelPlanById(Integer planId);//for edit operation form loading
    public String updateTravelPlan(TravelPlan plan);//for update operation form submission
    public String deleteTravelPlan(Integer planId);//for delete operation(hard delete)
    public String changeTavelPlanStatus(Integer planId, String status);//for changing travel plan status as soft deletion activity

}
