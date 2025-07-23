package com.digi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name= "TRAVEL_PLAN")
public class TravelPlan {
    @Id
    @Column(name="PLAN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer planId;

    @Column(name="Plan_Name", length=50)
    private String planName;

    @Column(name="PLAN_MIN_BUDGET")
    private Double planMinBudget;

    @Column(name="PLAN_DESCRIPTION", length=55)
    private String planDescription;

    @Column(name="PLAN_CATEGORY_ID")
    private Integer planCategoryId;

    @Column(name="ACTIVE_SW", length=15)
    private String activeSW="active";

    @Column(name="CREATED_DATE",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name="UPDATED_DATE",updatable = true,insertable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @Column(name="CREATED_BY", length=30)
    private String createdBy;

    @Column(name="UPDATED_BY", length=30)
    private String updatedBy;


    // Additional fields can be added as per requirements
}
