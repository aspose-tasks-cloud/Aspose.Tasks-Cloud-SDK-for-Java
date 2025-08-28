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
import com.aspose.tasks.cloud.model.LevelingOrder;
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
import org.threeten.bp.OffsetDateTime;

/**
 * LevelingOptions
 */

public class LevelingOptions {
  @SerializedName("StartDate")
  private OffsetDateTime startDate = null;

  @SerializedName("FinishDate")
  private OffsetDateTime finishDate = null;

  @SerializedName("ResourceUids")
  private List<Integer> resourceUids = null;

  @SerializedName("LevelingOrder")
  private LevelingOrder levelingOrder = null;

  public LevelingOptions startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * Leveling period start date. The default value is the project&#x60;s start date.
   * @return startDate
  **/
  @ApiModelProperty(value = "Leveling period start date. The default value is the project`s start date.")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public LevelingOptions finishDate(OffsetDateTime finishDate) {
    this.finishDate = finishDate;
    return this;
  }

   /**
   * Leveling period end date. The default value is the project&#x60;s finish date.
   * @return finishDate
  **/
  @ApiModelProperty(value = "Leveling period end date. The default value is the project`s finish date.")
  public OffsetDateTime getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(OffsetDateTime finishDate) {
    this.finishDate = finishDate;
  }

  public LevelingOptions resourceUids(List<Integer> resourceUids) {
    this.resourceUids = resourceUids;
    return this;
  }

  public LevelingOptions addResourceUidsItem(Integer resourceUidsItem) {
    if (this.resourceUids == null) {
      this.resourceUids = new ArrayList<Integer>();
    }
    this.resourceUids.add(resourceUidsItem);
    return this;
  }

   /**
   * The list of the resource uids which will be leveled. If null is set,  all project resources will be leveled.
   * @return resourceUids
  **/
  @ApiModelProperty(value = "The list of the resource uids which will be leveled. If null is set,  all project resources will be leveled.")
  public List<Integer> getResourceUids() {
    return resourceUids;
  }

  public void setResourceUids(List<Integer> resourceUids) {
    this.resourceUids = resourceUids;
  }

  public LevelingOptions levelingOrder(LevelingOrder levelingOrder) {
    this.levelingOrder = levelingOrder;
    return this;
  }

   /**
   * The order in which the leveling algorithm delays tasks that have overallocations. After determination of tasks causing the overallocation and which tasks can be delayed, the specified order is used which task should be delayed first.
   * @return levelingOrder
  **/
  @ApiModelProperty(required = true, value = "The order in which the leveling algorithm delays tasks that have overallocations. After determination of tasks causing the overallocation and which tasks can be delayed, the specified order is used which task should be delayed first.")
  public LevelingOrder getLevelingOrder() {
    return levelingOrder;
  }

  public void setLevelingOrder(LevelingOrder levelingOrder) {
    this.levelingOrder = levelingOrder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LevelingOptions levelingOptions = (LevelingOptions) o;
    return Objects.equals(this.startDate, levelingOptions.startDate) &&
        Objects.equals(this.finishDate, levelingOptions.finishDate) &&
        Objects.equals(this.resourceUids, levelingOptions.resourceUids) &&
        Objects.equals(this.levelingOrder, levelingOptions.levelingOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, finishDate, resourceUids, levelingOrder);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LevelingOptions {\n");
    
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    finishDate: ").append(toIndentedString(finishDate)).append("\n");
    sb.append("    resourceUids: ").append(toIndentedString(resourceUids)).append("\n");
    sb.append("    levelingOrder: ").append(toIndentedString(levelingOrder)).append("\n");
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

