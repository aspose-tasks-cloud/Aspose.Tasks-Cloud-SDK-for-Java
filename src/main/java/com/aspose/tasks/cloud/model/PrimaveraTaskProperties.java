/*
 * --------------------------------------------------------------------------------
 * <copyright company="Aspose">
 *   Copyright (c) 2021 Aspose.Tasks Cloud
 * </copyright>
 * <summary>
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 * 
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 * 
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 * </summary>
 * --------------------------------------------------------------------------------
 */

package com.aspose.tasks.cloud.model;

import java.util.Objects;
import java.util.Arrays;
import com.aspose.tasks.cloud.model.PrimaveraActivityType;
import com.aspose.tasks.cloud.model.PrimaveraConstraintType;
import com.aspose.tasks.cloud.model.PrimaveraDurationType;
import com.aspose.tasks.cloud.model.PrimaveraPercentCompleteType;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import org.threeten.bp.OffsetDateTime;

/**
 * Represents Primavera-specific properties for a task read from Primavera format (XER of P6XML).
 */
@ApiModel(description = "Represents Primavera-specific properties for a task read from Primavera format (XER of P6XML).")

public class PrimaveraTaskProperties {
  @SerializedName("SequenceNumber")
  private Integer sequenceNumber = null;

  @SerializedName("ActivityId")
  private String activityId = null;

  @SerializedName("RemainingEarlyFinish")
  private OffsetDateTime remainingEarlyFinish = null;

  @SerializedName("RemainingEarlyStart")
  private OffsetDateTime remainingEarlyStart = null;

  @SerializedName("RemainingLateStart")
  private OffsetDateTime remainingLateStart = null;

  @SerializedName("RemainingLateFinish")
  private OffsetDateTime remainingLateFinish = null;

  @SerializedName("RawDurationType")
  private String rawDurationType = null;

  @SerializedName("RawActivityType")
  private String rawActivityType = null;

  @SerializedName("RawCompletePercentType")
  private String rawCompletePercentType = null;

  @SerializedName("RawStatus")
  private String rawStatus = null;

  @SerializedName("DurationPercentComplete")
  private Double durationPercentComplete = null;

  @SerializedName("PhysicalPercentComplete")
  private Double physicalPercentComplete = null;

  @SerializedName("ActualNonLaborUnits")
  private Double actualNonLaborUnits = null;

  @SerializedName("ActualLaborUnits")
  private Double actualLaborUnits = null;

  @SerializedName("UnitsPercentComplete")
  private Double unitsPercentComplete = null;

  @SerializedName("RemainingLaborUnits")
  private Double remainingLaborUnits = null;

  @SerializedName("RemainingNonLaborUnits")
  private Double remainingNonLaborUnits = null;

  @SerializedName("DurationType")
  private PrimaveraDurationType durationType = null;

  @SerializedName("ActivityType")
  private PrimaveraActivityType activityType = null;

  @SerializedName("PercentCompleteType")
  private PrimaveraPercentCompleteType percentCompleteType = null;

  @SerializedName("ActualLaborCost")
  private BigDecimal actualLaborCost = null;

  @SerializedName("ActualNonlaborCost")
  private BigDecimal actualNonlaborCost = null;

  @SerializedName("ActualMaterialCost")
  private BigDecimal actualMaterialCost = null;

  @SerializedName("ActualExpenseCost")
  private BigDecimal actualExpenseCost = null;

  @SerializedName("RemainingExpenseCost")
  private BigDecimal remainingExpenseCost = null;

  @SerializedName("ActualTotalCost")
  private BigDecimal actualTotalCost = null;

  @SerializedName("BudgetedTotalCost")
  private BigDecimal budgetedTotalCost = null;

  @SerializedName("BudgetedLaborCost")
  private BigDecimal budgetedLaborCost = null;

  @SerializedName("BudgetedNonlaborCost")
  private BigDecimal budgetedNonlaborCost = null;

  @SerializedName("BudgetedMaterialCost")
  private BigDecimal budgetedMaterialCost = null;

  @SerializedName("BudgetedExpenseCost")
  private BigDecimal budgetedExpenseCost = null;

  @SerializedName("PrimaryConstraintType")
  private PrimaveraConstraintType primaryConstraintType = null;

  @SerializedName("PrimaryConstraintDate")
  private OffsetDateTime primaryConstraintDate = null;

  @SerializedName("SecondaryConstraintType")
  private PrimaveraConstraintType secondaryConstraintType = null;

  @SerializedName("SecondaryConstraintDate")
  private OffsetDateTime secondaryConstraintDate = null;

  @SerializedName("PlannedDuration")
  private String plannedDuration = null;

  public PrimaveraTaskProperties sequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
    return this;
  }

   /**
   * The sequence number of the WBS item (summary tasks). It is used to sort summary tasks in Primavera.
   * @return sequenceNumber
  **/
  @ApiModelProperty(required = true, value = "The sequence number of the WBS item (summary tasks). It is used to sort summary tasks in Primavera.")
  public Integer getSequenceNumber() {
    return sequenceNumber;
  }

  public void setSequenceNumber(Integer sequenceNumber) {
    this.sequenceNumber = sequenceNumber;
  }

  public PrimaveraTaskProperties activityId(String activityId) {
    this.activityId = activityId;
    return this;
  }

   /**
   * Activity id field - a task&#39;s unique identifier used by Primavera.
   * @return activityId
  **/
  @ApiModelProperty(value = "Activity id field - a task's unique identifier used by Primavera.")
  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public PrimaveraTaskProperties remainingEarlyFinish(OffsetDateTime remainingEarlyFinish) {
    this.remainingEarlyFinish = remainingEarlyFinish;
    return this;
  }

   /**
   * Remaining early finish date - the date when the remaining work for the activity is scheduled to be finished.
   * @return remainingEarlyFinish
  **/
  @ApiModelProperty(required = true, value = "Remaining early finish date - the date when the remaining work for the activity is scheduled to be finished.")
  public OffsetDateTime getRemainingEarlyFinish() {
    return remainingEarlyFinish;
  }

  public void setRemainingEarlyFinish(OffsetDateTime remainingEarlyFinish) {
    this.remainingEarlyFinish = remainingEarlyFinish;
  }

  public PrimaveraTaskProperties remainingEarlyStart(OffsetDateTime remainingEarlyStart) {
    this.remainingEarlyStart = remainingEarlyStart;
    return this;
  }

   /**
   * Remaining early start date - the date when the remaining work for the activity is scheduled to begin.
   * @return remainingEarlyStart
  **/
  @ApiModelProperty(required = true, value = "Remaining early start date - the date when the remaining work for the activity is scheduled to begin.")
  public OffsetDateTime getRemainingEarlyStart() {
    return remainingEarlyStart;
  }

  public void setRemainingEarlyStart(OffsetDateTime remainingEarlyStart) {
    this.remainingEarlyStart = remainingEarlyStart;
  }

  public PrimaveraTaskProperties remainingLateStart(OffsetDateTime remainingLateStart) {
    this.remainingLateStart = remainingLateStart;
    return this;
  }

   /**
   * Remaining late start date.
   * @return remainingLateStart
  **/
  @ApiModelProperty(required = true, value = "Remaining late start date.")
  public OffsetDateTime getRemainingLateStart() {
    return remainingLateStart;
  }

  public void setRemainingLateStart(OffsetDateTime remainingLateStart) {
    this.remainingLateStart = remainingLateStart;
  }

  public PrimaveraTaskProperties remainingLateFinish(OffsetDateTime remainingLateFinish) {
    this.remainingLateFinish = remainingLateFinish;
    return this;
  }

   /**
   * Remaining late finish date.
   * @return remainingLateFinish
  **/
  @ApiModelProperty(required = true, value = "Remaining late finish date.")
  public OffsetDateTime getRemainingLateFinish() {
    return remainingLateFinish;
  }

  public void setRemainingLateFinish(OffsetDateTime remainingLateFinish) {
    this.remainingLateFinish = remainingLateFinish;
  }

  public PrimaveraTaskProperties rawDurationType(String rawDurationType) {
    this.rawDurationType = rawDurationType;
    return this;
  }

   /**
   * Raw text representation (as in source file) of &#39;Duration Type&#39; field of the activity.
   * @return rawDurationType
  **/
  @ApiModelProperty(value = "Raw text representation (as in source file) of 'Duration Type' field of the activity.")
  public String getRawDurationType() {
    return rawDurationType;
  }

  public void setRawDurationType(String rawDurationType) {
    this.rawDurationType = rawDurationType;
  }

  public PrimaveraTaskProperties rawActivityType(String rawActivityType) {
    this.rawActivityType = rawActivityType;
    return this;
  }

   /**
   * Raw text representation (as in source file) of &#39;Activity Type&#39; field of the activity.
   * @return rawActivityType
  **/
  @ApiModelProperty(value = "Raw text representation (as in source file) of 'Activity Type' field of the activity.")
  public String getRawActivityType() {
    return rawActivityType;
  }

  public void setRawActivityType(String rawActivityType) {
    this.rawActivityType = rawActivityType;
  }

  public PrimaveraTaskProperties rawCompletePercentType(String rawCompletePercentType) {
    this.rawCompletePercentType = rawCompletePercentType;
    return this;
  }

   /**
   * Raw text representation (as in source file) of &#39;% Complete Type&#39; field of the activity.
   * @return rawCompletePercentType
  **/
  @ApiModelProperty(value = "Raw text representation (as in source file) of '% Complete Type' field of the activity.")
  public String getRawCompletePercentType() {
    return rawCompletePercentType;
  }

  public void setRawCompletePercentType(String rawCompletePercentType) {
    this.rawCompletePercentType = rawCompletePercentType;
  }

  public PrimaveraTaskProperties rawStatus(String rawStatus) {
    this.rawStatus = rawStatus;
    return this;
  }

   /**
   * Raw text representation (as in source file) of &#39;Status&#39; field of the activity.
   * @return rawStatus
  **/
  @ApiModelProperty(value = "Raw text representation (as in source file) of 'Status' field of the activity.")
  public String getRawStatus() {
    return rawStatus;
  }

  public void setRawStatus(String rawStatus) {
    this.rawStatus = rawStatus;
  }

  public PrimaveraTaskProperties durationPercentComplete(Double durationPercentComplete) {
    this.durationPercentComplete = durationPercentComplete;
    return this;
  }

   /**
   * Gets the value of duration percent complete.
   * @return durationPercentComplete
  **/
  @ApiModelProperty(required = true, value = "Gets the value of duration percent complete.")
  public Double getDurationPercentComplete() {
    return durationPercentComplete;
  }

  public void setDurationPercentComplete(Double durationPercentComplete) {
    this.durationPercentComplete = durationPercentComplete;
  }

  public PrimaveraTaskProperties physicalPercentComplete(Double physicalPercentComplete) {
    this.physicalPercentComplete = physicalPercentComplete;
    return this;
  }

   /**
   * Gets the value of Physical Percent Complete.
   * @return physicalPercentComplete
  **/
  @ApiModelProperty(required = true, value = "Gets the value of Physical Percent Complete.")
  public Double getPhysicalPercentComplete() {
    return physicalPercentComplete;
  }

  public void setPhysicalPercentComplete(Double physicalPercentComplete) {
    this.physicalPercentComplete = physicalPercentComplete;
  }

  public PrimaveraTaskProperties actualNonLaborUnits(Double actualNonLaborUnits) {
    this.actualNonLaborUnits = actualNonLaborUnits;
    return this;
  }

   /**
   * Gets the value of actual non labor units.
   * @return actualNonLaborUnits
  **/
  @ApiModelProperty(required = true, value = "Gets the value of actual non labor units.")
  public Double getActualNonLaborUnits() {
    return actualNonLaborUnits;
  }

  public void setActualNonLaborUnits(Double actualNonLaborUnits) {
    this.actualNonLaborUnits = actualNonLaborUnits;
  }

  public PrimaveraTaskProperties actualLaborUnits(Double actualLaborUnits) {
    this.actualLaborUnits = actualLaborUnits;
    return this;
  }

   /**
   * Gets the value of actual labor units.
   * @return actualLaborUnits
  **/
  @ApiModelProperty(required = true, value = "Gets the value of actual labor units.")
  public Double getActualLaborUnits() {
    return actualLaborUnits;
  }

  public void setActualLaborUnits(Double actualLaborUnits) {
    this.actualLaborUnits = actualLaborUnits;
  }

  public PrimaveraTaskProperties unitsPercentComplete(Double unitsPercentComplete) {
    this.unitsPercentComplete = unitsPercentComplete;
    return this;
  }

   /**
   * Gets the value of units percent complete.
   * @return unitsPercentComplete
  **/
  @ApiModelProperty(required = true, value = "Gets the value of units percent complete.")
  public Double getUnitsPercentComplete() {
    return unitsPercentComplete;
  }

  public void setUnitsPercentComplete(Double unitsPercentComplete) {
    this.unitsPercentComplete = unitsPercentComplete;
  }

  public PrimaveraTaskProperties remainingLaborUnits(Double remainingLaborUnits) {
    this.remainingLaborUnits = remainingLaborUnits;
    return this;
  }

   /**
   * Gets the value of remaining labor units.
   * @return remainingLaborUnits
  **/
  @ApiModelProperty(required = true, value = "Gets the value of remaining labor units.")
  public Double getRemainingLaborUnits() {
    return remainingLaborUnits;
  }

  public void setRemainingLaborUnits(Double remainingLaborUnits) {
    this.remainingLaborUnits = remainingLaborUnits;
  }

  public PrimaveraTaskProperties remainingNonLaborUnits(Double remainingNonLaborUnits) {
    this.remainingNonLaborUnits = remainingNonLaborUnits;
    return this;
  }

   /**
   * Gets the value of remaining non labor units.
   * @return remainingNonLaborUnits
  **/
  @ApiModelProperty(required = true, value = "Gets the value of remaining non labor units.")
  public Double getRemainingNonLaborUnits() {
    return remainingNonLaborUnits;
  }

  public void setRemainingNonLaborUnits(Double remainingNonLaborUnits) {
    this.remainingNonLaborUnits = remainingNonLaborUnits;
  }

  public PrimaveraTaskProperties durationType(PrimaveraDurationType durationType) {
    this.durationType = durationType;
    return this;
  }

   /**
   * Gets the value of &#39;Duration Type&#39; field of the activity.
   * @return durationType
  **/
  @ApiModelProperty(required = true, value = "Gets the value of 'Duration Type' field of the activity.")
  public PrimaveraDurationType getDurationType() {
    return durationType;
  }

  public void setDurationType(PrimaveraDurationType durationType) {
    this.durationType = durationType;
  }

  public PrimaveraTaskProperties activityType(PrimaveraActivityType activityType) {
    this.activityType = activityType;
    return this;
  }

   /**
   * Gets the value of &#39;Activity Type&#39; field.
   * @return activityType
  **/
  @ApiModelProperty(required = true, value = "Gets the value of 'Activity Type' field.")
  public PrimaveraActivityType getActivityType() {
    return activityType;
  }

  public void setActivityType(PrimaveraActivityType activityType) {
    this.activityType = activityType;
  }

  public PrimaveraTaskProperties percentCompleteType(PrimaveraPercentCompleteType percentCompleteType) {
    this.percentCompleteType = percentCompleteType;
    return this;
  }

   /**
   * Gets the value of &#39;% Complete Type&#39; field of the activity.
   * @return percentCompleteType
  **/
  @ApiModelProperty(required = true, value = "Gets the value of '% Complete Type' field of the activity.")
  public PrimaveraPercentCompleteType getPercentCompleteType() {
    return percentCompleteType;
  }

  public void setPercentCompleteType(PrimaveraPercentCompleteType percentCompleteType) {
    this.percentCompleteType = percentCompleteType;
  }

  public PrimaveraTaskProperties actualLaborCost(BigDecimal actualLaborCost) {
    this.actualLaborCost = actualLaborCost;
    return this;
  }

   /**
   * Gets the value of actual labor cost.
   * @return actualLaborCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of actual labor cost.")
  public BigDecimal getActualLaborCost() {
    return actualLaborCost;
  }

  public void setActualLaborCost(BigDecimal actualLaborCost) {
    this.actualLaborCost = actualLaborCost;
  }

  public PrimaveraTaskProperties actualNonlaborCost(BigDecimal actualNonlaborCost) {
    this.actualNonlaborCost = actualNonlaborCost;
    return this;
  }

   /**
   * Gets the value of actual non labor cost.
   * @return actualNonlaborCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of actual non labor cost.")
  public BigDecimal getActualNonlaborCost() {
    return actualNonlaborCost;
  }

  public void setActualNonlaborCost(BigDecimal actualNonlaborCost) {
    this.actualNonlaborCost = actualNonlaborCost;
  }

  public PrimaveraTaskProperties actualMaterialCost(BigDecimal actualMaterialCost) {
    this.actualMaterialCost = actualMaterialCost;
    return this;
  }

   /**
   * Gets the value of actual material cost.             
   * @return actualMaterialCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of actual material cost.             ")
  public BigDecimal getActualMaterialCost() {
    return actualMaterialCost;
  }

  public void setActualMaterialCost(BigDecimal actualMaterialCost) {
    this.actualMaterialCost = actualMaterialCost;
  }

  public PrimaveraTaskProperties actualExpenseCost(BigDecimal actualExpenseCost) {
    this.actualExpenseCost = actualExpenseCost;
    return this;
  }

   /**
   * Gets the value of actual expense cost.
   * @return actualExpenseCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of actual expense cost.")
  public BigDecimal getActualExpenseCost() {
    return actualExpenseCost;
  }

  public void setActualExpenseCost(BigDecimal actualExpenseCost) {
    this.actualExpenseCost = actualExpenseCost;
  }

  public PrimaveraTaskProperties remainingExpenseCost(BigDecimal remainingExpenseCost) {
    this.remainingExpenseCost = remainingExpenseCost;
    return this;
  }

   /**
   * Gets the value of remaining expense cost.
   * @return remainingExpenseCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of remaining expense cost.")
  public BigDecimal getRemainingExpenseCost() {
    return remainingExpenseCost;
  }

  public void setRemainingExpenseCost(BigDecimal remainingExpenseCost) {
    this.remainingExpenseCost = remainingExpenseCost;
  }

  public PrimaveraTaskProperties actualTotalCost(BigDecimal actualTotalCost) {
    this.actualTotalCost = actualTotalCost;
    return this;
  }

   /**
   * Gets the total value of actual costs.
   * @return actualTotalCost
  **/
  @ApiModelProperty(required = true, value = "Gets the total value of actual costs.")
  public BigDecimal getActualTotalCost() {
    return actualTotalCost;
  }

  public void setActualTotalCost(BigDecimal actualTotalCost) {
    this.actualTotalCost = actualTotalCost;
  }

  public PrimaveraTaskProperties budgetedTotalCost(BigDecimal budgetedTotalCost) {
    this.budgetedTotalCost = budgetedTotalCost;
    return this;
  }

   /**
   * Gets the total value of budgeted (or planned) costs.
   * @return budgetedTotalCost
  **/
  @ApiModelProperty(required = true, value = "Gets the total value of budgeted (or planned) costs.")
  public BigDecimal getBudgetedTotalCost() {
    return budgetedTotalCost;
  }

  public void setBudgetedTotalCost(BigDecimal budgetedTotalCost) {
    this.budgetedTotalCost = budgetedTotalCost;
  }

  public PrimaveraTaskProperties budgetedLaborCost(BigDecimal budgetedLaborCost) {
    this.budgetedLaborCost = budgetedLaborCost;
    return this;
  }

   /**
   * Gets the value of budgeted (or planned) labor cost.
   * @return budgetedLaborCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of budgeted (or planned) labor cost.")
  public BigDecimal getBudgetedLaborCost() {
    return budgetedLaborCost;
  }

  public void setBudgetedLaborCost(BigDecimal budgetedLaborCost) {
    this.budgetedLaborCost = budgetedLaborCost;
  }

  public PrimaveraTaskProperties budgetedNonlaborCost(BigDecimal budgetedNonlaborCost) {
    this.budgetedNonlaborCost = budgetedNonlaborCost;
    return this;
  }

   /**
   * Gets the value of budgeted (or planned) non labor cost.
   * @return budgetedNonlaborCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of budgeted (or planned) non labor cost.")
  public BigDecimal getBudgetedNonlaborCost() {
    return budgetedNonlaborCost;
  }

  public void setBudgetedNonlaborCost(BigDecimal budgetedNonlaborCost) {
    this.budgetedNonlaborCost = budgetedNonlaborCost;
  }

  public PrimaveraTaskProperties budgetedMaterialCost(BigDecimal budgetedMaterialCost) {
    this.budgetedMaterialCost = budgetedMaterialCost;
    return this;
  }

   /**
   * Gets the value of of budgeted (or planned) material cost.
   * @return budgetedMaterialCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of of budgeted (or planned) material cost.")
  public BigDecimal getBudgetedMaterialCost() {
    return budgetedMaterialCost;
  }

  public void setBudgetedMaterialCost(BigDecimal budgetedMaterialCost) {
    this.budgetedMaterialCost = budgetedMaterialCost;
  }

  public PrimaveraTaskProperties budgetedExpenseCost(BigDecimal budgetedExpenseCost) {
    this.budgetedExpenseCost = budgetedExpenseCost;
    return this;
  }

   /**
   * Gets the value of budgeted (or planned) expense cost.
   * @return budgetedExpenseCost
  **/
  @ApiModelProperty(required = true, value = "Gets the value of budgeted (or planned) expense cost.")
  public BigDecimal getBudgetedExpenseCost() {
    return budgetedExpenseCost;
  }

  public void setBudgetedExpenseCost(BigDecimal budgetedExpenseCost) {
    this.budgetedExpenseCost = budgetedExpenseCost;
  }

  public PrimaveraTaskProperties primaryConstraintType(PrimaveraConstraintType primaryConstraintType) {
    this.primaryConstraintType = primaryConstraintType;
    return this;
  }

   /**
   * Gets a type of primary constraint.
   * @return primaryConstraintType
  **/
  @ApiModelProperty(required = true, value = "Gets a type of primary constraint.")
  public PrimaveraConstraintType getPrimaryConstraintType() {
    return primaryConstraintType;
  }

  public void setPrimaryConstraintType(PrimaveraConstraintType primaryConstraintType) {
    this.primaryConstraintType = primaryConstraintType;
  }

  public PrimaveraTaskProperties primaryConstraintDate(OffsetDateTime primaryConstraintDate) {
    this.primaryConstraintDate = primaryConstraintDate;
    return this;
  }

   /**
   * Gets the date of primary constraint.
   * @return primaryConstraintDate
  **/
  @ApiModelProperty(required = true, value = "Gets the date of primary constraint.")
  public OffsetDateTime getPrimaryConstraintDate() {
    return primaryConstraintDate;
  }

  public void setPrimaryConstraintDate(OffsetDateTime primaryConstraintDate) {
    this.primaryConstraintDate = primaryConstraintDate;
  }

  public PrimaveraTaskProperties secondaryConstraintType(PrimaveraConstraintType secondaryConstraintType) {
    this.secondaryConstraintType = secondaryConstraintType;
    return this;
  }

   /**
   * Gets a type of secondary constraint.
   * @return secondaryConstraintType
  **/
  @ApiModelProperty(required = true, value = "Gets a type of secondary constraint.")
  public PrimaveraConstraintType getSecondaryConstraintType() {
    return secondaryConstraintType;
  }

  public void setSecondaryConstraintType(PrimaveraConstraintType secondaryConstraintType) {
    this.secondaryConstraintType = secondaryConstraintType;
  }

  public PrimaveraTaskProperties secondaryConstraintDate(OffsetDateTime secondaryConstraintDate) {
    this.secondaryConstraintDate = secondaryConstraintDate;
    return this;
  }

   /**
   * Gets the date of secondary constraint.
   * @return secondaryConstraintDate
  **/
  @ApiModelProperty(required = true, value = "Gets the date of secondary constraint.")
  public OffsetDateTime getSecondaryConstraintDate() {
    return secondaryConstraintDate;
  }

  public void setSecondaryConstraintDate(OffsetDateTime secondaryConstraintDate) {
    this.secondaryConstraintDate = secondaryConstraintDate;
  }

  public PrimaveraTaskProperties plannedDuration(String plannedDuration) {
    this.plannedDuration = plannedDuration;
    return this;
  }

   /**
   * Gets the original or planned duration -- the total working time from the task planned start date to the planned finish date.
   * @return plannedDuration
  **/
  @ApiModelProperty(required = true, value = "Gets the original or planned duration -- the total working time from the task planned start date to the planned finish date.")
  public String getPlannedDuration() {
    return plannedDuration;
  }

  public void setPlannedDuration(String plannedDuration) {
    this.plannedDuration = plannedDuration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PrimaveraTaskProperties primaveraTaskProperties = (PrimaveraTaskProperties) o;
    return Objects.equals(this.sequenceNumber, primaveraTaskProperties.sequenceNumber) &&
        Objects.equals(this.activityId, primaveraTaskProperties.activityId) &&
        Objects.equals(this.remainingEarlyFinish, primaveraTaskProperties.remainingEarlyFinish) &&
        Objects.equals(this.remainingEarlyStart, primaveraTaskProperties.remainingEarlyStart) &&
        Objects.equals(this.remainingLateStart, primaveraTaskProperties.remainingLateStart) &&
        Objects.equals(this.remainingLateFinish, primaveraTaskProperties.remainingLateFinish) &&
        Objects.equals(this.rawDurationType, primaveraTaskProperties.rawDurationType) &&
        Objects.equals(this.rawActivityType, primaveraTaskProperties.rawActivityType) &&
        Objects.equals(this.rawCompletePercentType, primaveraTaskProperties.rawCompletePercentType) &&
        Objects.equals(this.rawStatus, primaveraTaskProperties.rawStatus) &&
        Objects.equals(this.durationPercentComplete, primaveraTaskProperties.durationPercentComplete) &&
        Objects.equals(this.physicalPercentComplete, primaveraTaskProperties.physicalPercentComplete) &&
        Objects.equals(this.actualNonLaborUnits, primaveraTaskProperties.actualNonLaborUnits) &&
        Objects.equals(this.actualLaborUnits, primaveraTaskProperties.actualLaborUnits) &&
        Objects.equals(this.unitsPercentComplete, primaveraTaskProperties.unitsPercentComplete) &&
        Objects.equals(this.remainingLaborUnits, primaveraTaskProperties.remainingLaborUnits) &&
        Objects.equals(this.remainingNonLaborUnits, primaveraTaskProperties.remainingNonLaborUnits) &&
        Objects.equals(this.durationType, primaveraTaskProperties.durationType) &&
        Objects.equals(this.activityType, primaveraTaskProperties.activityType) &&
        Objects.equals(this.percentCompleteType, primaveraTaskProperties.percentCompleteType) &&
        Objects.equals(this.actualLaborCost, primaveraTaskProperties.actualLaborCost) &&
        Objects.equals(this.actualNonlaborCost, primaveraTaskProperties.actualNonlaborCost) &&
        Objects.equals(this.actualMaterialCost, primaveraTaskProperties.actualMaterialCost) &&
        Objects.equals(this.actualExpenseCost, primaveraTaskProperties.actualExpenseCost) &&
        Objects.equals(this.remainingExpenseCost, primaveraTaskProperties.remainingExpenseCost) &&
        Objects.equals(this.actualTotalCost, primaveraTaskProperties.actualTotalCost) &&
        Objects.equals(this.budgetedTotalCost, primaveraTaskProperties.budgetedTotalCost) &&
        Objects.equals(this.budgetedLaborCost, primaveraTaskProperties.budgetedLaborCost) &&
        Objects.equals(this.budgetedNonlaborCost, primaveraTaskProperties.budgetedNonlaborCost) &&
        Objects.equals(this.budgetedMaterialCost, primaveraTaskProperties.budgetedMaterialCost) &&
        Objects.equals(this.budgetedExpenseCost, primaveraTaskProperties.budgetedExpenseCost) &&
        Objects.equals(this.primaryConstraintType, primaveraTaskProperties.primaryConstraintType) &&
        Objects.equals(this.primaryConstraintDate, primaveraTaskProperties.primaryConstraintDate) &&
        Objects.equals(this.secondaryConstraintType, primaveraTaskProperties.secondaryConstraintType) &&
        Objects.equals(this.secondaryConstraintDate, primaveraTaskProperties.secondaryConstraintDate) &&
        Objects.equals(this.plannedDuration, primaveraTaskProperties.plannedDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sequenceNumber, activityId, remainingEarlyFinish, remainingEarlyStart, remainingLateStart, remainingLateFinish, rawDurationType, rawActivityType, rawCompletePercentType, rawStatus, durationPercentComplete, physicalPercentComplete, actualNonLaborUnits, actualLaborUnits, unitsPercentComplete, remainingLaborUnits, remainingNonLaborUnits, durationType, activityType, percentCompleteType, actualLaborCost, actualNonlaborCost, actualMaterialCost, actualExpenseCost, remainingExpenseCost, actualTotalCost, budgetedTotalCost, budgetedLaborCost, budgetedNonlaborCost, budgetedMaterialCost, budgetedExpenseCost, primaryConstraintType, primaryConstraintDate, secondaryConstraintType, secondaryConstraintDate, plannedDuration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PrimaveraTaskProperties {\n");
    
    sb.append("    sequenceNumber: ").append(toIndentedString(sequenceNumber)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("    remainingEarlyFinish: ").append(toIndentedString(remainingEarlyFinish)).append("\n");
    sb.append("    remainingEarlyStart: ").append(toIndentedString(remainingEarlyStart)).append("\n");
    sb.append("    remainingLateStart: ").append(toIndentedString(remainingLateStart)).append("\n");
    sb.append("    remainingLateFinish: ").append(toIndentedString(remainingLateFinish)).append("\n");
    sb.append("    rawDurationType: ").append(toIndentedString(rawDurationType)).append("\n");
    sb.append("    rawActivityType: ").append(toIndentedString(rawActivityType)).append("\n");
    sb.append("    rawCompletePercentType: ").append(toIndentedString(rawCompletePercentType)).append("\n");
    sb.append("    rawStatus: ").append(toIndentedString(rawStatus)).append("\n");
    sb.append("    durationPercentComplete: ").append(toIndentedString(durationPercentComplete)).append("\n");
    sb.append("    physicalPercentComplete: ").append(toIndentedString(physicalPercentComplete)).append("\n");
    sb.append("    actualNonLaborUnits: ").append(toIndentedString(actualNonLaborUnits)).append("\n");
    sb.append("    actualLaborUnits: ").append(toIndentedString(actualLaborUnits)).append("\n");
    sb.append("    unitsPercentComplete: ").append(toIndentedString(unitsPercentComplete)).append("\n");
    sb.append("    remainingLaborUnits: ").append(toIndentedString(remainingLaborUnits)).append("\n");
    sb.append("    remainingNonLaborUnits: ").append(toIndentedString(remainingNonLaborUnits)).append("\n");
    sb.append("    durationType: ").append(toIndentedString(durationType)).append("\n");
    sb.append("    activityType: ").append(toIndentedString(activityType)).append("\n");
    sb.append("    percentCompleteType: ").append(toIndentedString(percentCompleteType)).append("\n");
    sb.append("    actualLaborCost: ").append(toIndentedString(actualLaborCost)).append("\n");
    sb.append("    actualNonlaborCost: ").append(toIndentedString(actualNonlaborCost)).append("\n");
    sb.append("    actualMaterialCost: ").append(toIndentedString(actualMaterialCost)).append("\n");
    sb.append("    actualExpenseCost: ").append(toIndentedString(actualExpenseCost)).append("\n");
    sb.append("    remainingExpenseCost: ").append(toIndentedString(remainingExpenseCost)).append("\n");
    sb.append("    actualTotalCost: ").append(toIndentedString(actualTotalCost)).append("\n");
    sb.append("    budgetedTotalCost: ").append(toIndentedString(budgetedTotalCost)).append("\n");
    sb.append("    budgetedLaborCost: ").append(toIndentedString(budgetedLaborCost)).append("\n");
    sb.append("    budgetedNonlaborCost: ").append(toIndentedString(budgetedNonlaborCost)).append("\n");
    sb.append("    budgetedMaterialCost: ").append(toIndentedString(budgetedMaterialCost)).append("\n");
    sb.append("    budgetedExpenseCost: ").append(toIndentedString(budgetedExpenseCost)).append("\n");
    sb.append("    primaryConstraintType: ").append(toIndentedString(primaryConstraintType)).append("\n");
    sb.append("    primaryConstraintDate: ").append(toIndentedString(primaryConstraintDate)).append("\n");
    sb.append("    secondaryConstraintType: ").append(toIndentedString(secondaryConstraintType)).append("\n");
    sb.append("    secondaryConstraintDate: ").append(toIndentedString(secondaryConstraintDate)).append("\n");
    sb.append("    plannedDuration: ").append(toIndentedString(plannedDuration)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

