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
import com.aspose.tasks.cloud.model.GroupCriterion;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a group definition. A Group object is a member of the ResourceGroups collection or the TaskGroups collection.
 */
@ApiModel(description = "Represents a group definition. A Group object is a member of the ResourceGroups collection or the TaskGroups collection.")

public class Group {
  @SerializedName("Uid")
  private Integer uid = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("ShowInMenu")
  private Boolean showInMenu = null;

  @SerializedName("ShowSummary")
  private Boolean showSummary = null;

  @SerializedName("MaintainHierarchy")
  private Boolean maintainHierarchy = null;

  @SerializedName("GroupAssignments")
  private Boolean groupAssignments = null;

  @SerializedName("GroupCriteria")
  private List<GroupCriterion> groupCriteria = null;

  public Group uid(Integer uid) {
    this.uid = uid;
    return this;
  }

   /**
   * Gets or sets a unique identifier of a group.
   * @return uid
  **/
  @ApiModelProperty(required = true, value = "Gets or sets a unique identifier of a group.")
  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Group name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Gets or sets a name of a Group object.
   * @return name
  **/
  @ApiModelProperty(value = "Gets or sets a name of a Group object.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Group showInMenu(Boolean showInMenu) {
    this.showInMenu = showInMenu;
    return this;
  }

   /**
   * Gets or sets a value indicating whether Project shows the group name in the Group drop-down list in the Ribbon.
   * @return showInMenu
  **/
  @ApiModelProperty(required = true, value = "Gets or sets a value indicating whether Project shows the group name in the Group drop-down list in the Ribbon.")
  public Boolean isShowInMenu() {
    return showInMenu;
  }

  public void setShowInMenu(Boolean showInMenu) {
    this.showInMenu = showInMenu;
  }

  public Group showSummary(Boolean showSummary) {
    this.showSummary = showSummary;
    return this;
  }

   /**
   * Gets or sets a value indicating whether summary rows are displayed for the group.
   * @return showSummary
  **/
  @ApiModelProperty(required = true, value = "Gets or sets a value indicating whether summary rows are displayed for the group.")
  public Boolean isShowSummary() {
    return showSummary;
  }

  public void setShowSummary(Boolean showSummary) {
    this.showSummary = showSummary;
  }

  public Group maintainHierarchy(Boolean maintainHierarchy) {
    this.maintainHierarchy = maintainHierarchy;
    return this;
  }

   /**
   * Gets or sets a value indicating whether to show all the levels of summary tasks for subtasks within group.
   * @return maintainHierarchy
  **/
  @ApiModelProperty(required = true, value = "Gets or sets a value indicating whether to show all the levels of summary tasks for subtasks within group.")
  public Boolean isMaintainHierarchy() {
    return maintainHierarchy;
  }

  public void setMaintainHierarchy(Boolean maintainHierarchy) {
    this.maintainHierarchy = maintainHierarchy;
  }

  public Group groupAssignments(Boolean groupAssignments) {
    this.groupAssignments = groupAssignments;
    return this;
  }

   /**
   * Gets or sets a value indicating whether assignments should be grouped instead of tasks.
   * @return groupAssignments
  **/
  @ApiModelProperty(required = true, value = "Gets or sets a value indicating whether assignments should be grouped instead of tasks.")
  public Boolean isGroupAssignments() {
    return groupAssignments;
  }

  public void setGroupAssignments(Boolean groupAssignments) {
    this.groupAssignments = groupAssignments;
  }

  public Group groupCriteria(List<GroupCriterion> groupCriteria) {
    this.groupCriteria = groupCriteria;
    return this;
  }

  public Group addGroupCriteriaItem(GroupCriterion groupCriteriaItem) {
    if (this.groupCriteria == null) {
      this.groupCriteria = new ArrayList<GroupCriterion>();
    }
    this.groupCriteria.add(groupCriteriaItem);
    return this;
  }

   /**
   * Gets or sets a collection of criteria representing the fields in a group definition.
   * @return groupCriteria
  **/
  @ApiModelProperty(value = "Gets or sets a collection of criteria representing the fields in a group definition.")
  public List<GroupCriterion> getGroupCriteria() {
    return groupCriteria;
  }

  public void setGroupCriteria(List<GroupCriterion> groupCriteria) {
    this.groupCriteria = groupCriteria;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.uid, group.uid) &&
        Objects.equals(this.name, group.name) &&
        Objects.equals(this.showInMenu, group.showInMenu) &&
        Objects.equals(this.showSummary, group.showSummary) &&
        Objects.equals(this.maintainHierarchy, group.maintainHierarchy) &&
        Objects.equals(this.groupAssignments, group.groupAssignments) &&
        Objects.equals(this.groupCriteria, group.groupCriteria);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, name, showInMenu, showSummary, maintainHierarchy, groupAssignments, groupCriteria);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    showInMenu: ").append(toIndentedString(showInMenu)).append("\n");
    sb.append("    showSummary: ").append(toIndentedString(showSummary)).append("\n");
    sb.append("    maintainHierarchy: ").append(toIndentedString(maintainHierarchy)).append("\n");
    sb.append("    groupAssignments: ").append(toIndentedString(groupAssignments)).append("\n");
    sb.append("    groupCriteria: ").append(toIndentedString(groupCriteria)).append("\n");
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

