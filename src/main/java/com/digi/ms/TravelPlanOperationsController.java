package com.digi.ms;

import com.digi.entity.TravelPlan;
import com.digi.service.ITravelPlanMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/travelplans/api")//Global request mapping for all methods in this controller
public class TravelPlanOperationsController {
    @Autowired
    private ITravelPlanMgmtService planService;

    @GetMapping("/categories")
    public ResponseEntity<?> showTravelPlanCategories() {
        // Fetch travel plan categories from the service and return as a response entity
        try {
            Map<Integer,String> mapCategories=planService.getTravelPlanCategories();
            return new ResponseEntity<Map<Integer,String>>(mapCategories, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/register")
    public ResponseEntity<String> saveTourPlan(@RequestBody TravelPlan plan){
        try{
            // Call the service to register the travel plan
            String msg = planService.registerTravelPlan(plan);
            return new ResponseEntity<String>(msg, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllTravelPlans(){
        try{
            //fetch all travel plans from the service
            List<TravelPlan> list = planService.showAllTravelPlans();
            return new ResponseEntity<List<TravelPlan>>(list, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{planId}")
    public ResponseEntity<?> getTravelPlanById(@PathVariable Integer planId){
        try{
            TravelPlan plan = planService.showTravelPlanById(planId);
            return new ResponseEntity<TravelPlan>(plan, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateTraelPlan(@RequestBody TravelPlan plan){
        try{
            String msg = planService.updateTravelPlan(plan);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<?> removeTravelPlanById(@PathVariable Integer planId){
        try{
            String msg = planService.deleteTravelPlan(planId);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<?> changeTravelPlanStatus(@PathVariable Integer planId, @PathVariable String status) {
        try {
            String msg = planService.changeTavelPlanStatus(planId, status);
            return new ResponseEntity<String>(msg, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
