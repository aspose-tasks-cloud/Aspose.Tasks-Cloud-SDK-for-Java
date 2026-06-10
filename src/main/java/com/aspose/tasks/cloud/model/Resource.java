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
import com.aspose.tasks.cloud.model.Baseline;
import com.aspose.tasks.cloud.model.BookingType;
import com.aspose.tasks.cloud.model.CostAccrualType;
import com.aspose.tasks.cloud.model.ExtendedAttribute;
import com.aspose.tasks.cloud.model.OutlineCode;
import com.aspose.tasks.cloud.model.RateFormatType;
import com.aspose.tasks.cloud.model.ResourceType;
import com.aspose.tasks.cloud.model.WorkGroupType;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

/**
 * Represents a project resource.
 */
@ApiModel(description = "Represents a project resource.")

public class Resource {
  @SerializedName("IsRoot")
  private Boolean isRoot = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Uid")
  private Integer uid = null;

  @SerializedName("Id")
  private Integer id = null;

  @SerializedName("Guid")
  private String guid = null;

  @SerializedName("Type")
  private ResourceType type = null;

  @SerializedName("IsNull")
  private Boolean isNull = null;

  @SerializedName("Initials")
  private String initials = null;

  @SerializedName("Phonetics")
  private String phonetics = null;

  @SerializedName("NtAccount")
  private String ntAccount = null;

  @SerializedName("WindowsUserAccount")
  private String windowsUserAccount = null;

  @SerializedName("Workgroup")
  private WorkGroupType workgroup = null;

  @SerializedName("MaterialLabel")
  private String materialLabel = null;

  @SerializedName("Code")
  private String code = null;

  @SerializedName("Group")
  private String group = null;

  @SerializedName("EmailAddress")
  private String emailAddress = null;

  @SerializedName("Hyperlink")
  private String hyperlink = null;

  @SerializedName("HyperlinkAddress")
  private String hyperlinkAddress = null;

  @SerializedName("HyperlinkSubAddress")
  private String hyperlinkSubAddress = null;

  @SerializedName("MaxUnits")
  private Double maxUnits = 1.0d;

  @SerializedName("PeakUnits")
  private Double peakUnits = null;

  @SerializedName("OverAllocated")
  private Boolean overAllocated = null;

  @SerializedName("AvailableFrom")
  private OffsetDateTime availableFrom = null;

  @SerializedName("AvailableTo")
  private OffsetDateTime availableTo = null;

  @SerializedName("Start")
  private OffsetDateTime start = null;

  @SerializedName("Finish")
  private OffsetDateTime finish = null;

  @SerializedName("CanLevel")
  private Boolean canLevel = true;

  @SerializedName("AccrueAt")
  private CostAccrualType accrueAt = null;

  @SerializedName("Work")
  private String work = null;

  @SerializedName("RegularWork")
  private String regularWork = null;

  @SerializedName("OvertimeWork")
  private String overtimeWork = null;

  @SerializedName("ActualWork")
  private String actualWork = null;

  @SerializedName("RemainingWork")
  private String remainingWork = null;

  @SerializedName("ActualOvertimeWork")
  private String actualOvertimeWork = null;

  @SerializedName("RemainingOvertimeWork")
  private String remainingOvertimeWork = null;

  @SerializedName("PercentWorkComplete")
  private Integer percentWorkComplete = null;

  @SerializedName("StandardRate")
  private BigDecimal standardRate = null;

  @SerializedName("StandardRateFormat")
  private RateFormatType standardRateFormat = null;

  @SerializedName("Cost")
  private BigDecimal cost = null;

  @SerializedName("OvertimeRateFormat")
  private RateFormatType overtimeRateFormat = null;

  @SerializedName("OvertimeCost")
  private BigDecimal overtimeCost = null;

  @SerializedName("CostPerUse")
  private BigDecimal costPerUse = null;

  @SerializedName("ActualCost")
  private BigDecimal actualCost = null;

  @SerializedName("ActualOvertimeCost")
  private BigDecimal actualOvertimeCost = null;

  @SerializedName("RemainingCost")
  private BigDecimal remainingCost = null;

  @SerializedName("RemainingOvertimeCost")
  private BigDecimal remainingOvertimeCost = null;

  @SerializedName("WorkVariance")
  private Double workVariance = null;

  @SerializedName("CostVariance")
  private Double costVariance = null;

  @SerializedName("Sv")
  private Double sv = null;

  @SerializedName("Cv")
  private Double cv = null;

  @SerializedName("Acwp")
  private Double acwp = null;

  @SerializedName("CalendarUid")
  private Integer calendarUid = null;

  @SerializedName("NotesText")
  private String notesText = null;

  @SerializedName("Notes")
  private String notes = null;

  @SerializedName("NotesRTF")
  private String notesRTF = null;

  @SerializedName("Bcws")
  private Double bcws = null;

  @SerializedName("Bcwp")
  private Double bcwp = null;

  @SerializedName("IsGeneric")
  private Boolean isGeneric = null;

  @SerializedName("IsInactive")
  private Boolean isInactive = null;

  @SerializedName("IsEnterprise")
  private Boolean isEnterprise = null;

  @SerializedName("BookingType")
  private BookingType bookingType = null;

  @SerializedName("ActualWorkProtected")
  private String actualWorkProtected = null;

  @SerializedName("ActualOvertimeWorkProtected")
  private String actualOvertimeWorkProtected = null;

  @SerializedName("ActiveDirectoryGuid")
  private String activeDirectoryGuid = null;

  @SerializedName("CreationDate")
  private OffsetDateTime creationDate = null;

  @SerializedName("CostCenter")
  private String costCenter = null;

  @SerializedName("IsCostResource")
  private Boolean isCostResource = null;

  @SerializedName("TeamAssignmentPool")
  private Boolean teamAssignmentPool = null;

  @SerializedName("AssignmentOwner")
  private String assignmentOwner = null;

  @SerializedName("AssignmentOwnerGuid")
  private String assignmentOwnerGuid = null;

  @SerializedName("IsBudget")
  private Boolean isBudget = null;

  @SerializedName("BudgetWork")
  private String budgetWork = null;

  @SerializedName("BudgetCost")
  private BigDecimal budgetCost = null;

  @SerializedName("OvertimeRate")
  private BigDecimal overtimeRate = null;

  @SerializedName("Baselines")
  private List<Baseline> baselines = null;

  @SerializedName("ExtendedAttributes")
  private List<ExtendedAttribute> extendedAttributes = null;

  @SerializedName("OutlineCodes")
  private List<OutlineCode> outlineCodes = null;

  public Resource isRoot(Boolean isRoot) {
    this.isRoot = isRoot;
    return this;
  }

   /**
   *         Gets the flag indicating whether resource is a root resource. Root resource is         a special resource which is intended to support internals of MS Project&#39;s formats         and is not intended to be used directly from the user&#39;s code.     
   * @return isRoot
  **/
  @ApiModelProperty(required = true, value = "        Gets the flag indicating whether resource is a root resource. Root resource is         a special resource which is intended to support internals of MS Project's formats         and is not intended to be used directly from the user's code.     ")
  public Boolean isIsRoot() {
    return isRoot;
  }

  public void setIsRoot(Boolean isRoot) {
    this.isRoot = isRoot;
  }

  public Resource name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of a resource.
   * @return name
  **/
  @ApiModelProperty(value = "The name of a resource.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Resource uid(Integer uid) {
    this.uid = uid;
    return this;
  }

   /**
   * The unique identifier of a resource.
   * @return uid
  **/
  @ApiModelProperty(required = true, value = "The unique identifier of a resource.")
  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Resource id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * The position identifier of a resource within the list of resources.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "The position identifier of a resource within the list of resources.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Resource guid(String guid) {
    this.guid = guid;
    return this;
  }

   /**
   * Contains the generated unique identification code for the resource.             
   * @return guid
  **/
  @ApiModelProperty(value = "Contains the generated unique identification code for the resource.             ")
  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public Resource type(ResourceType type) {
    this.type = type;
    return this;
  }

   /**
   * The type of a resource.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "The type of a resource.")
  public ResourceType getType() {
    return type;
  }

  public void setType(ResourceType type) {
    this.type = type;
  }

  public Resource isNull(Boolean isNull) {
    this.isNull = isNull;
    return this;
  }

   /**
   * Determines whether a resource is null.
   * @return isNull
  **/
  @ApiModelProperty(required = true, value = "Determines whether a resource is null.")
  public Boolean isIsNull() {
    return isNull;
  }

  public void setIsNull(Boolean isNull) {
    this.isNull = isNull;
  }

  public Resource initials(String initials) {
    this.initials = initials;
    return this;
  }

   /**
   * The initials of a resource.
   * @return initials
  **/
  @ApiModelProperty(value = "The initials of a resource.")
  public String getInitials() {
    return initials;
  }

  public void setInitials(String initials) {
    this.initials = initials;
  }

  public Resource phonetics(String phonetics) {
    this.phonetics = phonetics;
    return this;
  }

   /**
   * The phonetic spelling of the resource name. For use with Japanese only.
   * @return phonetics
  **/
  @ApiModelProperty(value = "The phonetic spelling of the resource name. For use with Japanese only.")
  public String getPhonetics() {
    return phonetics;
  }

  public void setPhonetics(String phonetics) {
    this.phonetics = phonetics;
  }

  public Resource ntAccount(String ntAccount) {
    this.ntAccount = ntAccount;
    return this;
  }

   /**
   * The NT account associated with a resource.
   * @return ntAccount
  **/
  @ApiModelProperty(value = "The NT account associated with a resource.")
  public String getNtAccount() {
    return ntAccount;
  }

  public void setNtAccount(String ntAccount) {
    this.ntAccount = ntAccount;
  }

  public Resource windowsUserAccount(String windowsUserAccount) {
    this.windowsUserAccount = windowsUserAccount;
    return this;
  }

   /**
   * The NT account associated with a resource.
   * @return windowsUserAccount
  **/
  @ApiModelProperty(value = "The NT account associated with a resource.")
  public String getWindowsUserAccount() {
    return windowsUserAccount;
  }

  public void setWindowsUserAccount(String windowsUserAccount) {
    this.windowsUserAccount = windowsUserAccount;
  }

  public Resource workgroup(WorkGroupType workgroup) {
    this.workgroup = workgroup;
    return this;
  }

   /**
   * The type of a workgroup to which a resource belongs.  type.
   * @return workgroup
  **/
  @ApiModelProperty(required = true, value = "The type of a workgroup to which a resource belongs.  type.")
  public WorkGroupType getWorkgroup() {
    return workgroup;
  }

  public void setWorkgroup(WorkGroupType workgroup) {
    this.workgroup = workgroup;
  }

  public Resource materialLabel(String materialLabel) {
    this.materialLabel = materialLabel;
    return this;
  }

   /**
   * The unit of measure for the material resource. Read/write String.
   * @return materialLabel
  **/
  @ApiModelProperty(value = "The unit of measure for the material resource. Read/write String.")
  public String getMaterialLabel() {
    return materialLabel;
  }

  public void setMaterialLabel(String materialLabel) {
    this.materialLabel = materialLabel;
  }

  public Resource code(String code) {
    this.code = code;
    return this;
  }

   /**
   * The code or other information about a resource.
   * @return code
  **/
  @ApiModelProperty(value = "The code or other information about a resource.")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Resource group(String group) {
    this.group = group;
    return this;
  }

   /**
   * The group to which a resource belongs.
   * @return group
  **/
  @ApiModelProperty(value = "The group to which a resource belongs.")
  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public Resource emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

   /**
   * Get emailAddress
   * @return emailAddress
  **/
  @ApiModelProperty(value = "")
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Resource hyperlink(String hyperlink) {
    this.hyperlink = hyperlink;
    return this;
  }

   /**
   * The title of a hyperlink associated with a resource.
   * @return hyperlink
  **/
  @ApiModelProperty(value = "The title of a hyperlink associated with a resource.")
  public String getHyperlink() {
    return hyperlink;
  }

  public void setHyperlink(String hyperlink) {
    this.hyperlink = hyperlink;
  }

  public Resource hyperlinkAddress(String hyperlinkAddress) {
    this.hyperlinkAddress = hyperlinkAddress;
    return this;
  }

   /**
   * The hyperlink associated with a resource.
   * @return hyperlinkAddress
  **/
  @ApiModelProperty(value = "The hyperlink associated with a resource.")
  public String getHyperlinkAddress() {
    return hyperlinkAddress;
  }

  public void setHyperlinkAddress(String hyperlinkAddress) {
    this.hyperlinkAddress = hyperlinkAddress;
  }

  public Resource hyperlinkSubAddress(String hyperlinkSubAddress) {
    this.hyperlinkSubAddress = hyperlinkSubAddress;
    return this;
  }

   /**
   * The document bookmark of a hyperlink associated with a resource. Read/write String.
   * @return hyperlinkSubAddress
  **/
  @ApiModelProperty(value = "The document bookmark of a hyperlink associated with a resource. Read/write String.")
  public String getHyperlinkSubAddress() {
    return hyperlinkSubAddress;
  }

  public void setHyperlinkSubAddress(String hyperlinkSubAddress) {
    this.hyperlinkSubAddress = hyperlinkSubAddress;
  }

  public Resource maxUnits(Double maxUnits) {
    this.maxUnits = maxUnits;
    return this;
  }

   /**
   * The maximum number of units of a resource is available.
   * @return maxUnits
  **/
  @ApiModelProperty(required = true, value = "The maximum number of units of a resource is available.")
  public Double getMaxUnits() {
    return maxUnits;
  }

  public void setMaxUnits(Double maxUnits) {
    this.maxUnits = maxUnits;
  }

  public Resource peakUnits(Double peakUnits) {
    this.peakUnits = peakUnits;
    return this;
  }

   /**
   * The largest number of units assigned to a resource at any time.
   * @return peakUnits
  **/
  @ApiModelProperty(required = true, value = "The largest number of units assigned to a resource at any time.")
  public Double getPeakUnits() {
    return peakUnits;
  }

  public void setPeakUnits(Double peakUnits) {
    this.peakUnits = peakUnits;
  }

  public Resource overAllocated(Boolean overAllocated) {
    this.overAllocated = overAllocated;
    return this;
  }

   /**
   * Get overAllocated
   * @return overAllocated
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean isOverAllocated() {
    return overAllocated;
  }

  public void setOverAllocated(Boolean overAllocated) {
    this.overAllocated = overAllocated;
  }

  public Resource availableFrom(OffsetDateTime availableFrom) {
    this.availableFrom = availableFrom;
    return this;
  }

   /**
   * The first date when a resource is available.
   * @return availableFrom
  **/
  @ApiModelProperty(required = true, value = "The first date when a resource is available.")
  public OffsetDateTime getAvailableFrom() {
    return availableFrom;
  }

  public void setAvailableFrom(OffsetDateTime availableFrom) {
    this.availableFrom = availableFrom;
  }

  public Resource availableTo(OffsetDateTime availableTo) {
    this.availableTo = availableTo;
    return this;
  }

   /**
   * The last date when a resource is available.
   * @return availableTo
  **/
  @ApiModelProperty(required = true, value = "The last date when a resource is available.")
  public OffsetDateTime getAvailableTo() {
    return availableTo;
  }

  public void setAvailableTo(OffsetDateTime availableTo) {
    this.availableTo = availableTo;
  }

  public Resource start(OffsetDateTime start) {
    this.start = start;
    return this;
  }

   /**
   * The scheduled start date of a resource. This property is calculated on demand and cannot be set directly.
   * @return start
  **/
  @ApiModelProperty(required = true, value = "The scheduled start date of a resource. This property is calculated on demand and cannot be set directly.")
  public OffsetDateTime getStart() {
    return start;
  }

  public void setStart(OffsetDateTime start) {
    this.start = start;
  }

  public Resource finish(OffsetDateTime finish) {
    this.finish = finish;
    return this;
  }

   /**
   * The scheduled finish date of a resource. This property is calculated on demand and cannot be set directly.
   * @return finish
  **/
  @ApiModelProperty(required = true, value = "The scheduled finish date of a resource. This property is calculated on demand and cannot be set directly.")
  public OffsetDateTime getFinish() {
    return finish;
  }

  public void setFinish(OffsetDateTime finish) {
    this.finish = finish;
  }

  public Resource canLevel(Boolean canLevel) {
    this.canLevel = canLevel;
    return this;
  }

   /**
   * Determines whether a resource can be leveled.
   * @return canLevel
  **/
  @ApiModelProperty(required = true, value = "Determines whether a resource can be leveled.")
  public Boolean isCanLevel() {
    return canLevel;
  }

  public void setCanLevel(Boolean canLevel) {
    this.canLevel = canLevel;
  }

  public Resource accrueAt(CostAccrualType accrueAt) {
    this.accrueAt = accrueAt;
    return this;
  }

   /**
   * Determines how cost is accrued against the resource.
   * @return accrueAt
  **/
  @ApiModelProperty(required = true, value = "Determines how cost is accrued against the resource.")
  public CostAccrualType getAccrueAt() {
    return accrueAt;
  }

  public void setAccrueAt(CostAccrualType accrueAt) {
    this.accrueAt = accrueAt;
  }

  public Resource work(String work) {
    this.work = work;
    return this;
  }

   /**
   * The total work assigned to a resource across all assigned tasks.
   * @return work
  **/
  @ApiModelProperty(required = true, value = "The total work assigned to a resource across all assigned tasks.")
  public String getWork() {
    return work;
  }

  public void setWork(String work) {
    this.work = work;
  }

  public Resource regularWork(String regularWork) {
    this.regularWork = regularWork;
    return this;
  }

   /**
   * The amount of non-overtime work assigned to a resource.
   * @return regularWork
  **/
  @ApiModelProperty(required = true, value = "The amount of non-overtime work assigned to a resource.")
  public String getRegularWork() {
    return regularWork;
  }

  public void setRegularWork(String regularWork) {
    this.regularWork = regularWork;
  }

  public Resource overtimeWork(String overtimeWork) {
    this.overtimeWork = overtimeWork;
    return this;
  }

   /**
   * The amount of overtime work assigned to a resource.
   * @return overtimeWork
  **/
  @ApiModelProperty(required = true, value = "The amount of overtime work assigned to a resource.")
  public String getOvertimeWork() {
    return overtimeWork;
  }

  public void setOvertimeWork(String overtimeWork) {
    this.overtimeWork = overtimeWork;
  }

  public Resource actualWork(String actualWork) {
    this.actualWork = actualWork;
    return this;
  }

   /**
   * The amount of actual work performed by a resource.
   * @return actualWork
  **/
  @ApiModelProperty(required = true, value = "The amount of actual work performed by a resource.")
  public String getActualWork() {
    return actualWork;
  }

  public void setActualWork(String actualWork) {
    this.actualWork = actualWork;
  }

  public Resource remainingWork(String remainingWork) {
    this.remainingWork = remainingWork;
    return this;
  }

   /**
   * The amount of remaining work required to complete all assigned tasks.
   * @return remainingWork
  **/
  @ApiModelProperty(required = true, value = "The amount of remaining work required to complete all assigned tasks.")
  public String getRemainingWork() {
    return remainingWork;
  }

  public void setRemainingWork(String remainingWork) {
    this.remainingWork = remainingWork;
  }

  public Resource actualOvertimeWork(String actualOvertimeWork) {
    this.actualOvertimeWork = actualOvertimeWork;
    return this;
  }

   /**
   * The amount of actual overtime work performed by a resource.
   * @return actualOvertimeWork
  **/
  @ApiModelProperty(required = true, value = "The amount of actual overtime work performed by a resource.")
  public String getActualOvertimeWork() {
    return actualOvertimeWork;
  }

  public void setActualOvertimeWork(String actualOvertimeWork) {
    this.actualOvertimeWork = actualOvertimeWork;
  }

  public Resource remainingOvertimeWork(String remainingOvertimeWork) {
    this.remainingOvertimeWork = remainingOvertimeWork;
    return this;
  }

   /**
   * The amount of remaining overtime work required to complete all tasks.
   * @return remainingOvertimeWork
  **/
  @ApiModelProperty(required = true, value = "The amount of remaining overtime work required to complete all tasks.")
  public String getRemainingOvertimeWork() {
    return remainingOvertimeWork;
  }

  public void setRemainingOvertimeWork(String remainingOvertimeWork) {
    this.remainingOvertimeWork = remainingOvertimeWork;
  }

  public Resource percentWorkComplete(Integer percentWorkComplete) {
    this.percentWorkComplete = percentWorkComplete;
    return this;
  }

   /**
   * The percentage of work completed across all tasks.
   * @return percentWorkComplete
  **/
  @ApiModelProperty(required = true, value = "The percentage of work completed across all tasks.")
  public Integer getPercentWorkComplete() {
    return percentWorkComplete;
  }

  public void setPercentWorkComplete(Integer percentWorkComplete) {
    this.percentWorkComplete = percentWorkComplete;
  }

  public Resource standardRate(BigDecimal standardRate) {
    this.standardRate = standardRate;
    return this;
  }

   /**
   * The standard rate of a resource. This value retrieved from the current date if a rate table exists for a resource.
   * @return standardRate
  **/
  @ApiModelProperty(required = true, value = "The standard rate of a resource. This value retrieved from the current date if a rate table exists for a resource.")
  public BigDecimal getStandardRate() {
    return standardRate;
  }

  public void setStandardRate(BigDecimal standardRate) {
    this.standardRate = standardRate;
  }

  public Resource standardRateFormat(RateFormatType standardRateFormat) {
    this.standardRateFormat = standardRateFormat;
    return this;
  }

   /**
   * The units used by Microsoft Project to display the standard rate.
   * @return standardRateFormat
  **/
  @ApiModelProperty(required = true, value = "The units used by Microsoft Project to display the standard rate.")
  public RateFormatType getStandardRateFormat() {
    return standardRateFormat;
  }

  public void setStandardRateFormat(RateFormatType standardRateFormat) {
    this.standardRateFormat = standardRateFormat;
  }

  public Resource cost(BigDecimal cost) {
    this.cost = cost;
    return this;
  }

   /**
   * The total project cost for a resource across all assigned tasks.
   * @return cost
  **/
  @ApiModelProperty(required = true, value = "The total project cost for a resource across all assigned tasks.")
  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  public Resource overtimeRateFormat(RateFormatType overtimeRateFormat) {
    this.overtimeRateFormat = overtimeRateFormat;
    return this;
  }

   /**
   * The units used by Microsoft Project to display the overtime rate.
   * @return overtimeRateFormat
  **/
  @ApiModelProperty(required = true, value = "The units used by Microsoft Project to display the overtime rate.")
  public RateFormatType getOvertimeRateFormat() {
    return overtimeRateFormat;
  }

  public void setOvertimeRateFormat(RateFormatType overtimeRateFormat) {
    this.overtimeRateFormat = overtimeRateFormat;
  }

  public Resource overtimeCost(BigDecimal overtimeCost) {
    this.overtimeCost = overtimeCost;
    return this;
  }

   /**
   * The total overtime cost of a resource including actual and remaining overtime costs.
   * @return overtimeCost
  **/
  @ApiModelProperty(required = true, value = "The total overtime cost of a resource including actual and remaining overtime costs.")
  public BigDecimal getOvertimeCost() {
    return overtimeCost;
  }

  public void setOvertimeCost(BigDecimal overtimeCost) {
    this.overtimeCost = overtimeCost;
  }

  public Resource costPerUse(BigDecimal costPerUse) {
    this.costPerUse = costPerUse;
    return this;
  }

   /**
   * The cost per use of a resource. This value retrieved from the current date if a rate table exists for the resource.
   * @return costPerUse
  **/
  @ApiModelProperty(required = true, value = "The cost per use of a resource. This value retrieved from the current date if a rate table exists for the resource.")
  public BigDecimal getCostPerUse() {
    return costPerUse;
  }

  public void setCostPerUse(BigDecimal costPerUse) {
    this.costPerUse = costPerUse;
  }

  public Resource actualCost(BigDecimal actualCost) {
    this.actualCost = actualCost;
    return this;
  }

   /**
   * The actual cost incurred by the resource across all assigned tasks.
   * @return actualCost
  **/
  @ApiModelProperty(required = true, value = "The actual cost incurred by the resource across all assigned tasks.")
  public BigDecimal getActualCost() {
    return actualCost;
  }

  public void setActualCost(BigDecimal actualCost) {
    this.actualCost = actualCost;
  }

  public Resource actualOvertimeCost(BigDecimal actualOvertimeCost) {
    this.actualOvertimeCost = actualOvertimeCost;
    return this;
  }

   /**
   * The actual overtime cost incurred by the resource across all assigned tasks.
   * @return actualOvertimeCost
  **/
  @ApiModelProperty(required = true, value = "The actual overtime cost incurred by the resource across all assigned tasks.")
  public BigDecimal getActualOvertimeCost() {
    return actualOvertimeCost;
  }

  public void setActualOvertimeCost(BigDecimal actualOvertimeCost) {
    this.actualOvertimeCost = actualOvertimeCost;
  }

  public Resource remainingCost(BigDecimal remainingCost) {
    this.remainingCost = remainingCost;
    return this;
  }

   /**
   * The remaining projected cost of a resource to complete all assigned tasks.
   * @return remainingCost
  **/
  @ApiModelProperty(required = true, value = "The remaining projected cost of a resource to complete all assigned tasks.")
  public BigDecimal getRemainingCost() {
    return remainingCost;
  }

  public void setRemainingCost(BigDecimal remainingCost) {
    this.remainingCost = remainingCost;
  }

  public Resource remainingOvertimeCost(BigDecimal remainingOvertimeCost) {
    this.remainingOvertimeCost = remainingOvertimeCost;
    return this;
  }

   /**
   * The remaining projected overtime cost of a resource to complete all assigned tasks.
   * @return remainingOvertimeCost
  **/
  @ApiModelProperty(required = true, value = "The remaining projected overtime cost of a resource to complete all assigned tasks.")
  public BigDecimal getRemainingOvertimeCost() {
    return remainingOvertimeCost;
  }

  public void setRemainingOvertimeCost(BigDecimal remainingOvertimeCost) {
    this.remainingOvertimeCost = remainingOvertimeCost;
  }

  public Resource workVariance(Double workVariance) {
    this.workVariance = workVariance;
    return this;
  }

   /**
   * The difference between a baseline work and a work
   * @return workVariance
  **/
  @ApiModelProperty(required = true, value = "The difference between a baseline work and a work")
  public Double getWorkVariance() {
    return workVariance;
  }

  public void setWorkVariance(Double workVariance) {
    this.workVariance = workVariance;
  }

  public Resource costVariance(Double costVariance) {
    this.costVariance = costVariance;
    return this;
  }

   /**
   * The difference between a baseline cost and a cost.
   * @return costVariance
  **/
  @ApiModelProperty(required = true, value = "The difference between a baseline cost and a cost.")
  public Double getCostVariance() {
    return costVariance;
  }

  public void setCostVariance(Double costVariance) {
    this.costVariance = costVariance;
  }

  public Resource sv(Double sv) {
    this.sv = sv;
    return this;
  }

   /**
   * The earned value schedule variance, through the project status date.
   * @return sv
  **/
  @ApiModelProperty(required = true, value = "The earned value schedule variance, through the project status date.")
  public Double getSv() {
    return sv;
  }

  public void setSv(Double sv) {
    this.sv = sv;
  }

  public Resource cv(Double cv) {
    this.cv = cv;
    return this;
  }

   /**
   * The earned value cost variance, through the project status date.
   * @return cv
  **/
  @ApiModelProperty(required = true, value = "The earned value cost variance, through the project status date.")
  public Double getCv() {
    return cv;
  }

  public void setCv(Double cv) {
    this.cv = cv;
  }

  public Resource acwp(Double acwp) {
    this.acwp = acwp;
    return this;
  }

   /**
   * The actual cost of a work performed by a resource for the project to-date.
   * @return acwp
  **/
  @ApiModelProperty(required = true, value = "The actual cost of a work performed by a resource for the project to-date.")
  public Double getAcwp() {
    return acwp;
  }

  public void setAcwp(Double acwp) {
    this.acwp = acwp;
  }

  public Resource calendarUid(Integer calendarUid) {
    this.calendarUid = calendarUid;
    return this;
  }

   /**
   * The calendar of a resource.
   * @return calendarUid
  **/
  @ApiModelProperty(required = true, value = "The calendar of a resource.")
  public Integer getCalendarUid() {
    return calendarUid;
  }

  public void setCalendarUid(Integer calendarUid) {
    this.calendarUid = calendarUid;
  }

  public Resource notesText(String notesText) {
    this.notesText = notesText;
    return this;
  }

   /**
   * Notes&#39; plain text extracted from RTF data.
   * @return notesText
  **/
  @ApiModelProperty(value = "Notes' plain text extracted from RTF data.")
  public String getNotesText() {
    return notesText;
  }

  public void setNotesText(String notesText) {
    this.notesText = notesText;
  }

  public Resource notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * The text notes associated with a resource.
   * @return notes
  **/
  @ApiModelProperty(value = "The text notes associated with a resource.")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Resource notesRTF(String notesRTF) {
    this.notesRTF = notesRTF;
    return this;
  }

   /**
   * The text notes in RTF format. Supported for MPP formats only.
   * @return notesRTF
  **/
  @ApiModelProperty(value = "The text notes in RTF format. Supported for MPP formats only.")
  public String getNotesRTF() {
    return notesRTF;
  }

  public void setNotesRTF(String notesRTF) {
    this.notesRTF = notesRTF;
  }

  public Resource bcws(Double bcws) {
    this.bcws = bcws;
    return this;
  }

   /**
   * The budget cost of a work scheduled for a resource.
   * @return bcws
  **/
  @ApiModelProperty(required = true, value = "The budget cost of a work scheduled for a resource.")
  public Double getBcws() {
    return bcws;
  }

  public void setBcws(Double bcws) {
    this.bcws = bcws;
  }

  public Resource bcwp(Double bcwp) {
    this.bcwp = bcwp;
    return this;
  }

   /**
   * The budgeted cost of a work performed by a resource for the project to-date.
   * @return bcwp
  **/
  @ApiModelProperty(required = true, value = "The budgeted cost of a work performed by a resource for the project to-date.")
  public Double getBcwp() {
    return bcwp;
  }

  public void setBcwp(Double bcwp) {
    this.bcwp = bcwp;
  }

  public Resource isGeneric(Boolean isGeneric) {
    this.isGeneric = isGeneric;
    return this;
  }

   /**
   * Determines whether a resource is generic.
   * @return isGeneric
  **/
  @ApiModelProperty(required = true, value = "Determines whether a resource is generic.")
  public Boolean isIsGeneric() {
    return isGeneric;
  }

  public void setIsGeneric(Boolean isGeneric) {
    this.isGeneric = isGeneric;
  }

  public Resource isInactive(Boolean isInactive) {
    this.isInactive = isInactive;
    return this;
  }

   /**
   * Determines whether a resource is inactive.
   * @return isInactive
  **/
  @ApiModelProperty(required = true, value = "Determines whether a resource is inactive.")
  public Boolean isIsInactive() {
    return isInactive;
  }

  public void setIsInactive(Boolean isInactive) {
    this.isInactive = isInactive;
  }

  public Resource isEnterprise(Boolean isEnterprise) {
    this.isEnterprise = isEnterprise;
    return this;
  }

   /**
   * Determines whether a resource is an Enterprise resource.
   * @return isEnterprise
  **/
  @ApiModelProperty(required = true, value = "Determines whether a resource is an Enterprise resource.")
  public Boolean isIsEnterprise() {
    return isEnterprise;
  }

  public void setIsEnterprise(Boolean isEnterprise) {
    this.isEnterprise = isEnterprise;
  }

  public Resource bookingType(BookingType bookingType) {
    this.bookingType = bookingType;
    return this;
  }

   /**
   * The booking type of a resource.
   * @return bookingType
  **/
  @ApiModelProperty(required = true, value = "The booking type of a resource.")
  public BookingType getBookingType() {
    return bookingType;
  }

  public void setBookingType(BookingType bookingType) {
    this.bookingType = bookingType;
  }

  public Resource actualWorkProtected(String actualWorkProtected) {
    this.actualWorkProtected = actualWorkProtected;
    return this;
  }

   /**
   * The duration through which actual work is protected.
   * @return actualWorkProtected
  **/
  @ApiModelProperty(required = true, value = "The duration through which actual work is protected.")
  public String getActualWorkProtected() {
    return actualWorkProtected;
  }

  public void setActualWorkProtected(String actualWorkProtected) {
    this.actualWorkProtected = actualWorkProtected;
  }

  public Resource actualOvertimeWorkProtected(String actualOvertimeWorkProtected) {
    this.actualOvertimeWorkProtected = actualOvertimeWorkProtected;
    return this;
  }

   /**
   * The duration through which actual overtime work is protected.
   * @return actualOvertimeWorkProtected
  **/
  @ApiModelProperty(required = true, value = "The duration through which actual overtime work is protected.")
  public String getActualOvertimeWorkProtected() {
    return actualOvertimeWorkProtected;
  }

  public void setActualOvertimeWorkProtected(String actualOvertimeWorkProtected) {
    this.actualOvertimeWorkProtected = actualOvertimeWorkProtected;
  }

  public Resource activeDirectoryGuid(String activeDirectoryGuid) {
    this.activeDirectoryGuid = activeDirectoryGuid;
    return this;
  }

   /**
   * The Active Directory Guid for a resource.
   * @return activeDirectoryGuid
  **/
  @ApiModelProperty(value = "The Active Directory Guid for a resource.")
  public String getActiveDirectoryGuid() {
    return activeDirectoryGuid;
  }

  public void setActiveDirectoryGuid(String activeDirectoryGuid) {
    this.activeDirectoryGuid = activeDirectoryGuid;
  }

  public Resource creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * The date when a resource was created.
   * @return creationDate
  **/
  @ApiModelProperty(required = true, value = "The date when a resource was created.")
  public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public Resource costCenter(String costCenter) {
    this.costCenter = costCenter;
    return this;
  }

   /**
   * Indicates which cost center the costs accrued by the resource should be charged to.
   * @return costCenter
  **/
  @ApiModelProperty(value = "Indicates which cost center the costs accrued by the resource should be charged to.")
  public String getCostCenter() {
    return costCenter;
  }

  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
  }

  public Resource isCostResource(Boolean isCostResource) {
    this.isCostResource = isCostResource;
    return this;
  }

   /**
   * Determines whether a resource is a cost resource.
   * @return isCostResource
  **/
  @ApiModelProperty(required = true, value = "Determines whether a resource is a cost resource.")
  public Boolean isIsCostResource() {
    return isCostResource;
  }

  public void setIsCostResource(Boolean isCostResource) {
    this.isCostResource = isCostResource;
  }

  public Resource teamAssignmentPool(Boolean teamAssignmentPool) {
    this.teamAssignmentPool = teamAssignmentPool;
    return this;
  }

   /**
   * Determines whether the current resource is a team resource.             
   * @return teamAssignmentPool
  **/
  @ApiModelProperty(required = true, value = "Determines whether the current resource is a team resource.             ")
  public Boolean isTeamAssignmentPool() {
    return teamAssignmentPool;
  }

  public void setTeamAssignmentPool(Boolean teamAssignmentPool) {
    this.teamAssignmentPool = teamAssignmentPool;
  }

  public Resource assignmentOwner(String assignmentOwner) {
    this.assignmentOwner = assignmentOwner;
    return this;
  }

   /**
   * The name of an assignment owner.
   * @return assignmentOwner
  **/
  @ApiModelProperty(value = "The name of an assignment owner.")
  public String getAssignmentOwner() {
    return assignmentOwner;
  }

  public void setAssignmentOwner(String assignmentOwner) {
    this.assignmentOwner = assignmentOwner;
  }

  public Resource assignmentOwnerGuid(String assignmentOwnerGuid) {
    this.assignmentOwnerGuid = assignmentOwnerGuid;
    return this;
  }

   /**
   * The GUID of an assignment owner.
   * @return assignmentOwnerGuid
  **/
  @ApiModelProperty(value = "The GUID of an assignment owner.")
  public String getAssignmentOwnerGuid() {
    return assignmentOwnerGuid;
  }

  public void setAssignmentOwnerGuid(String assignmentOwnerGuid) {
    this.assignmentOwnerGuid = assignmentOwnerGuid;
  }

  public Resource isBudget(Boolean isBudget) {
    this.isBudget = isBudget;
    return this;
  }

   /**
   * Determines whether a resource is a budget resource.
   * @return isBudget
  **/
  @ApiModelProperty(required = true, value = "Determines whether a resource is a budget resource.")
  public Boolean isIsBudget() {
    return isBudget;
  }

  public void setIsBudget(Boolean isBudget) {
    this.isBudget = isBudget;
  }

  public Resource budgetWork(String budgetWork) {
    this.budgetWork = budgetWork;
    return this;
  }

   /**
   * The budget work for a budget work or material resource.
   * @return budgetWork
  **/
  @ApiModelProperty(required = true, value = "The budget work for a budget work or material resource.")
  public String getBudgetWork() {
    return budgetWork;
  }

  public void setBudgetWork(String budgetWork) {
    this.budgetWork = budgetWork;
  }

  public Resource budgetCost(BigDecimal budgetCost) {
    this.budgetCost = budgetCost;
    return this;
  }

   /**
   * The budget cost for a budget cost resource.
   * @return budgetCost
  **/
  @ApiModelProperty(required = true, value = "The budget cost for a budget cost resource.")
  public BigDecimal getBudgetCost() {
    return budgetCost;
  }

  public void setBudgetCost(BigDecimal budgetCost) {
    this.budgetCost = budgetCost;
  }

  public Resource overtimeRate(BigDecimal overtimeRate) {
    this.overtimeRate = overtimeRate;
    return this;
  }

   /**
   * The overtime rate of a resource. This value retrieved from the current date if a rate table exists for a resource.
   * @return overtimeRate
  **/
  @ApiModelProperty(required = true, value = "The overtime rate of a resource. This value retrieved from the current date if a rate table exists for a resource.")
  public BigDecimal getOvertimeRate() {
    return overtimeRate;
  }

  public void setOvertimeRate(BigDecimal overtimeRate) {
    this.overtimeRate = overtimeRate;
  }

  public Resource baselines(List<Baseline> baselines) {
    this.baselines = baselines;
    return this;
  }

  public Resource addBaselinesItem(Baseline baselinesItem) {
    if (this.baselines == null) {
      this.baselines = new ArrayList<Baseline>();
    }
    this.baselines.add(baselinesItem);
    return this;
  }

   /**
   * Gets or sets the collection of baseline values of the resource.
   * @return baselines
  **/
  @ApiModelProperty(value = "Gets or sets the collection of baseline values of the resource.")
  public List<Baseline> getBaselines() {
    return baselines;
  }

  public void setBaselines(List<Baseline> baselines) {
    this.baselines = baselines;
  }

  public Resource extendedAttributes(List<ExtendedAttribute> extendedAttributes) {
    this.extendedAttributes = extendedAttributes;
    return this;
  }

  public Resource addExtendedAttributesItem(ExtendedAttribute extendedAttributesItem) {
    if (this.extendedAttributes == null) {
      this.extendedAttributes = new ArrayList<ExtendedAttribute>();
    }
    this.extendedAttributes.add(extendedAttributesItem);
    return this;
  }

   /**
   * Resource extended attributes.
   * @return extendedAttributes
  **/
  @ApiModelProperty(value = "Resource extended attributes.")
  public List<ExtendedAttribute> getExtendedAttributes() {
    return extendedAttributes;
  }

  public void setExtendedAttributes(List<ExtendedAttribute> extendedAttributes) {
    this.extendedAttributes = extendedAttributes;
  }

  public Resource outlineCodes(List<OutlineCode> outlineCodes) {
    this.outlineCodes = outlineCodes;
    return this;
  }

  public Resource addOutlineCodesItem(OutlineCode outlineCodesItem) {
    if (this.outlineCodes == null) {
      this.outlineCodes = new ArrayList<OutlineCode>();
    }
    this.outlineCodes.add(outlineCodesItem);
    return this;
  }

   /**
   * Resource outline codes.
   * @return outlineCodes
  **/
  @ApiModelProperty(value = "Resource outline codes.")
  public List<OutlineCode> getOutlineCodes() {
    return outlineCodes;
  }

  public void setOutlineCodes(List<OutlineCode> outlineCodes) {
    this.outlineCodes = outlineCodes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resource resource = (Resource) o;
    return Objects.equals(this.isRoot, resource.isRoot) &&
        Objects.equals(this.name, resource.name) &&
        Objects.equals(this.uid, resource.uid) &&
        Objects.equals(this.id, resource.id) &&
        Objects.equals(this.guid, resource.guid) &&
        Objects.equals(this.type, resource.type) &&
        Objects.equals(this.isNull, resource.isNull) &&
        Objects.equals(this.initials, resource.initials) &&
        Objects.equals(this.phonetics, resource.phonetics) &&
        Objects.equals(this.ntAccount, resource.ntAccount) &&
        Objects.equals(this.windowsUserAccount, resource.windowsUserAccount) &&
        Objects.equals(this.workgroup, resource.workgroup) &&
        Objects.equals(this.materialLabel, resource.materialLabel) &&
        Objects.equals(this.code, resource.code) &&
        Objects.equals(this.group, resource.group) &&
        Objects.equals(this.emailAddress, resource.emailAddress) &&
        Objects.equals(this.hyperlink, resource.hyperlink) &&
        Objects.equals(this.hyperlinkAddress, resource.hyperlinkAddress) &&
        Objects.equals(this.hyperlinkSubAddress, resource.hyperlinkSubAddress) &&
        Objects.equals(this.maxUnits, resource.maxUnits) &&
        Objects.equals(this.peakUnits, resource.peakUnits) &&
        Objects.equals(this.overAllocated, resource.overAllocated) &&
        Objects.equals(this.availableFrom, resource.availableFrom) &&
        Objects.equals(this.availableTo, resource.availableTo) &&
        Objects.equals(this.start, resource.start) &&
        Objects.equals(this.finish, resource.finish) &&
        Objects.equals(this.canLevel, resource.canLevel) &&
        Objects.equals(this.accrueAt, resource.accrueAt) &&
        Objects.equals(this.work, resource.work) &&
        Objects.equals(this.regularWork, resource.regularWork) &&
        Objects.equals(this.overtimeWork, resource.overtimeWork) &&
        Objects.equals(this.actualWork, resource.actualWork) &&
        Objects.equals(this.remainingWork, resource.remainingWork) &&
        Objects.equals(this.actualOvertimeWork, resource.actualOvertimeWork) &&
        Objects.equals(this.remainingOvertimeWork, resource.remainingOvertimeWork) &&
        Objects.equals(this.percentWorkComplete, resource.percentWorkComplete) &&
        Objects.equals(this.standardRate, resource.standardRate) &&
        Objects.equals(this.standardRateFormat, resource.standardRateFormat) &&
        Objects.equals(this.cost, resource.cost) &&
        Objects.equals(this.overtimeRateFormat, resource.overtimeRateFormat) &&
        Objects.equals(this.overtimeCost, resource.overtimeCost) &&
        Objects.equals(this.costPerUse, resource.costPerUse) &&
        Objects.equals(this.actualCost, resource.actualCost) &&
        Objects.equals(this.actualOvertimeCost, resource.actualOvertimeCost) &&
        Objects.equals(this.remainingCost, resource.remainingCost) &&
        Objects.equals(this.remainingOvertimeCost, resource.remainingOvertimeCost) &&
        Objects.equals(this.workVariance, resource.workVariance) &&
        Objects.equals(this.costVariance, resource.costVariance) &&
        Objects.equals(this.sv, resource.sv) &&
        Objects.equals(this.cv, resource.cv) &&
        Objects.equals(this.acwp, resource.acwp) &&
        Objects.equals(this.calendarUid, resource.calendarUid) &&
        Objects.equals(this.notesText, resource.notesText) &&
        Objects.equals(this.notes, resource.notes) &&
        Objects.equals(this.notesRTF, resource.notesRTF) &&
        Objects.equals(this.bcws, resource.bcws) &&
        Objects.equals(this.bcwp, resource.bcwp) &&
        Objects.equals(this.isGeneric, resource.isGeneric) &&
        Objects.equals(this.isInactive, resource.isInactive) &&
        Objects.equals(this.isEnterprise, resource.isEnterprise) &&
        Objects.equals(this.bookingType, resource.bookingType) &&
        Objects.equals(this.actualWorkProtected, resource.actualWorkProtected) &&
        Objects.equals(this.actualOvertimeWorkProtected, resource.actualOvertimeWorkProtected) &&
        Objects.equals(this.activeDirectoryGuid, resource.activeDirectoryGuid) &&
        Objects.equals(this.creationDate, resource.creationDate) &&
        Objects.equals(this.costCenter, resource.costCenter) &&
        Objects.equals(this.isCostResource, resource.isCostResource) &&
        Objects.equals(this.teamAssignmentPool, resource.teamAssignmentPool) &&
        Objects.equals(this.assignmentOwner, resource.assignmentOwner) &&
        Objects.equals(this.assignmentOwnerGuid, resource.assignmentOwnerGuid) &&
        Objects.equals(this.isBudget, resource.isBudget) &&
        Objects.equals(this.budgetWork, resource.budgetWork) &&
        Objects.equals(this.budgetCost, resource.budgetCost) &&
        Objects.equals(this.overtimeRate, resource.overtimeRate) &&
        Objects.equals(this.baselines, resource.baselines) &&
        Objects.equals(this.extendedAttributes, resource.extendedAttributes) &&
        Objects.equals(this.outlineCodes, resource.outlineCodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isRoot, name, uid, id, guid, type, isNull, initials, phonetics, ntAccount, windowsUserAccount, workgroup, materialLabel, code, group, emailAddress, hyperlink, hyperlinkAddress, hyperlinkSubAddress, maxUnits, peakUnits, overAllocated, availableFrom, availableTo, start, finish, canLevel, accrueAt, work, regularWork, overtimeWork, actualWork, remainingWork, actualOvertimeWork, remainingOvertimeWork, percentWorkComplete, standardRate, standardRateFormat, cost, overtimeRateFormat, overtimeCost, costPerUse, actualCost, actualOvertimeCost, remainingCost, remainingOvertimeCost, workVariance, costVariance, sv, cv, acwp, calendarUid, notesText, notes, notesRTF, bcws, bcwp, isGeneric, isInactive, isEnterprise, bookingType, actualWorkProtected, actualOvertimeWorkProtected, activeDirectoryGuid, creationDate, costCenter, isCostResource, teamAssignmentPool, assignmentOwner, assignmentOwnerGuid, isBudget, budgetWork, budgetCost, overtimeRate, baselines, extendedAttributes, outlineCodes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    
    sb.append("    isRoot: ").append(toIndentedString(isRoot)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    isNull: ").append(toIndentedString(isNull)).append("\n");
    sb.append("    initials: ").append(toIndentedString(initials)).append("\n");
    sb.append("    phonetics: ").append(toIndentedString(phonetics)).append("\n");
    sb.append("    ntAccount: ").append(toIndentedString(ntAccount)).append("\n");
    sb.append("    windowsUserAccount: ").append(toIndentedString(windowsUserAccount)).append("\n");
    sb.append("    workgroup: ").append(toIndentedString(workgroup)).append("\n");
    sb.append("    materialLabel: ").append(toIndentedString(materialLabel)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    hyperlink: ").append(toIndentedString(hyperlink)).append("\n");
    sb.append("    hyperlinkAddress: ").append(toIndentedString(hyperlinkAddress)).append("\n");
    sb.append("    hyperlinkSubAddress: ").append(toIndentedString(hyperlinkSubAddress)).append("\n");
    sb.append("    maxUnits: ").append(toIndentedString(maxUnits)).append("\n");
    sb.append("    peakUnits: ").append(toIndentedString(peakUnits)).append("\n");
    sb.append("    overAllocated: ").append(toIndentedString(overAllocated)).append("\n");
    sb.append("    availableFrom: ").append(toIndentedString(availableFrom)).append("\n");
    sb.append("    availableTo: ").append(toIndentedString(availableTo)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    finish: ").append(toIndentedString(finish)).append("\n");
    sb.append("    canLevel: ").append(toIndentedString(canLevel)).append("\n");
    sb.append("    accrueAt: ").append(toIndentedString(accrueAt)).append("\n");
    sb.append("    work: ").append(toIndentedString(work)).append("\n");
    sb.append("    regularWork: ").append(toIndentedString(regularWork)).append("\n");
    sb.append("    overtimeWork: ").append(toIndentedString(overtimeWork)).append("\n");
    sb.append("    actualWork: ").append(toIndentedString(actualWork)).append("\n");
    sb.append("    remainingWork: ").append(toIndentedString(remainingWork)).append("\n");
    sb.append("    actualOvertimeWork: ").append(toIndentedString(actualOvertimeWork)).append("\n");
    sb.append("    remainingOvertimeWork: ").append(toIndentedString(remainingOvertimeWork)).append("\n");
    sb.append("    percentWorkComplete: ").append(toIndentedString(percentWorkComplete)).append("\n");
    sb.append("    standardRate: ").append(toIndentedString(standardRate)).append("\n");
    sb.append("    standardRateFormat: ").append(toIndentedString(standardRateFormat)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
    sb.append("    overtimeRateFormat: ").append(toIndentedString(overtimeRateFormat)).append("\n");
    sb.append("    overtimeCost: ").append(toIndentedString(overtimeCost)).append("\n");
    sb.append("    costPerUse: ").append(toIndentedString(costPerUse)).append("\n");
    sb.append("    actualCost: ").append(toIndentedString(actualCost)).append("\n");
    sb.append("    actualOvertimeCost: ").append(toIndentedString(actualOvertimeCost)).append("\n");
    sb.append("    remainingCost: ").append(toIndentedString(remainingCost)).append("\n");
    sb.append("    remainingOvertimeCost: ").append(toIndentedString(remainingOvertimeCost)).append("\n");
    sb.append("    workVariance: ").append(toIndentedString(workVariance)).append("\n");
    sb.append("    costVariance: ").append(toIndentedString(costVariance)).append("\n");
    sb.append("    sv: ").append(toIndentedString(sv)).append("\n");
    sb.append("    cv: ").append(toIndentedString(cv)).append("\n");
    sb.append("    acwp: ").append(toIndentedString(acwp)).append("\n");
    sb.append("    calendarUid: ").append(toIndentedString(calendarUid)).append("\n");
    sb.append("    notesText: ").append(toIndentedString(notesText)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    notesRTF: ").append(toIndentedString(notesRTF)).append("\n");
    sb.append("    bcws: ").append(toIndentedString(bcws)).append("\n");
    sb.append("    bcwp: ").append(toIndentedString(bcwp)).append("\n");
    sb.append("    isGeneric: ").append(toIndentedString(isGeneric)).append("\n");
    sb.append("    isInactive: ").append(toIndentedString(isInactive)).append("\n");
    sb.append("    isEnterprise: ").append(toIndentedString(isEnterprise)).append("\n");
    sb.append("    bookingType: ").append(toIndentedString(bookingType)).append("\n");
    sb.append("    actualWorkProtected: ").append(toIndentedString(actualWorkProtected)).append("\n");
    sb.append("    actualOvertimeWorkProtected: ").append(toIndentedString(actualOvertimeWorkProtected)).append("\n");
    sb.append("    activeDirectoryGuid: ").append(toIndentedString(activeDirectoryGuid)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    costCenter: ").append(toIndentedString(costCenter)).append("\n");
    sb.append("    isCostResource: ").append(toIndentedString(isCostResource)).append("\n");
    sb.append("    teamAssignmentPool: ").append(toIndentedString(teamAssignmentPool)).append("\n");
    sb.append("    assignmentOwner: ").append(toIndentedString(assignmentOwner)).append("\n");
    sb.append("    assignmentOwnerGuid: ").append(toIndentedString(assignmentOwnerGuid)).append("\n");
    sb.append("    isBudget: ").append(toIndentedString(isBudget)).append("\n");
    sb.append("    budgetWork: ").append(toIndentedString(budgetWork)).append("\n");
    sb.append("    budgetCost: ").append(toIndentedString(budgetCost)).append("\n");
    sb.append("    overtimeRate: ").append(toIndentedString(overtimeRate)).append("\n");
    sb.append("    baselines: ").append(toIndentedString(baselines)).append("\n");
    sb.append("    extendedAttributes: ").append(toIndentedString(extendedAttributes)).append("\n");
    sb.append("    outlineCodes: ").append(toIndentedString(outlineCodes)).append("\n");
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

