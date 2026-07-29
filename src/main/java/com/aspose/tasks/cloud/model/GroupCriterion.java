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
import com.aspose.tasks.cloud.model.BackgroundPattern;
import com.aspose.tasks.cloud.model.Colors;
import com.aspose.tasks.cloud.model.Field;
import com.aspose.tasks.cloud.model.FontInfo;
import com.aspose.tasks.cloud.model.GroupOn;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Represents a criterion in a group definition.
 */
@ApiModel(description = "Represents a criterion in a group definition.")

public class GroupCriterion {
  @SerializedName("Field")
  private Field field = null;

  @SerializedName("Ascending")
  private Boolean ascending = null;

  @SerializedName("GroupOn")
  private GroupOn groupOn = null;

  @SerializedName("GroupInterval")
  private String groupInterval = null;

  @SerializedName("StartAt")
  private String startAt = null;

  @SerializedName("CellColor")
  private Colors cellColor = null;

  @SerializedName("FontColor")
  private Colors fontColor = null;

  @SerializedName("Pattern")
  private BackgroundPattern pattern = null;

  @SerializedName("Font")
  private FontInfo font = null;

  public GroupCriterion field(Field field) {
    this.field = field;
    return this;
  }

   /**
   * Gets or sets the field being grouped by.
   * @return field
  **/
  @ApiModelProperty(required = true, value = "Gets or sets the field being grouped by.")
  public Field getField() {
    return field;
  }

  public void setField(Field field) {
    this.field = field;
  }

  public GroupCriterion ascending(Boolean ascending) {
    this.ascending = ascending;
    return this;
  }

   /**
   * Gets or sets a value indicating whether a field used as a criterion in a group definition is sorted in ascending order. False if the field is sorted in descending order.
   * @return ascending
  **/
  @ApiModelProperty(required = true, value = "Gets or sets a value indicating whether a field used as a criterion in a group definition is sorted in ascending order. False if the field is sorted in descending order.")
  public Boolean isAscending() {
    return ascending;
  }

  public void setAscending(Boolean ascending) {
    this.ascending = ascending;
  }

  public GroupCriterion groupOn(GroupOn groupOn) {
    this.groupOn = groupOn;
    return this;
  }

   /**
   * Gets or sets the type of grouping for a field used as a criterion in a group definition.
   * @return groupOn
  **/
  @ApiModelProperty(required = true, value = "Gets or sets the type of grouping for a field used as a criterion in a group definition.")
  public GroupOn getGroupOn() {
    return groupOn;
  }

  public void setGroupOn(GroupOn groupOn) {
    this.groupOn = groupOn;
  }

  public GroupCriterion groupInterval(String groupInterval) {
    this.groupInterval = groupInterval;
    return this;
  }

   /**
   * Gets or sets the interval for a field used as a criterion in a group definition.
   * @return groupInterval
  **/
  @ApiModelProperty(value = "Gets or sets the interval for a field used as a criterion in a group definition.")
  public String getGroupInterval() {
    return groupInterval;
  }

  public void setGroupInterval(String groupInterval) {
    this.groupInterval = groupInterval;
  }

  public GroupCriterion startAt(String startAt) {
    this.startAt = startAt;
    return this;
  }

   /**
   * Gets or sets the start of the intervals for a field used as a criterion in a group definition.
   * @return startAt
  **/
  @ApiModelProperty(value = "Gets or sets the start of the intervals for a field used as a criterion in a group definition.")
  public String getStartAt() {
    return startAt;
  }

  public void setStartAt(String startAt) {
    this.startAt = startAt;
  }

  public GroupCriterion cellColor(Colors cellColor) {
    this.cellColor = cellColor;
    return this;
  }

   /**
   * Gets or sets the color of the cell background for a field used as a criterion in a group definition.
   * @return cellColor
  **/
  @ApiModelProperty(required = true, value = "Gets or sets the color of the cell background for a field used as a criterion in a group definition.")
  public Colors getCellColor() {
    return cellColor;
  }

  public void setCellColor(Colors cellColor) {
    this.cellColor = cellColor;
  }

  public GroupCriterion fontColor(Colors fontColor) {
    this.fontColor = fontColor;
    return this;
  }

   /**
   * Gets or sets the color of the font for a field used as a criterion in a group definition.
   * @return fontColor
  **/
  @ApiModelProperty(required = true, value = "Gets or sets the color of the font for a field used as a criterion in a group definition.")
  public Colors getFontColor() {
    return fontColor;
  }

  public void setFontColor(Colors fontColor) {
    this.fontColor = fontColor;
  }

  public GroupCriterion pattern(BackgroundPattern pattern) {
    this.pattern = pattern;
    return this;
  }

   /**
   * Gets or sets the pattern of the cell for a field used as a criterion in a group definition.
   * @return pattern
  **/
  @ApiModelProperty(required = true, value = "Gets or sets the pattern of the cell for a field used as a criterion in a group definition.")
  public BackgroundPattern getPattern() {
    return pattern;
  }

  public void setPattern(BackgroundPattern pattern) {
    this.pattern = pattern;
  }

  public GroupCriterion font(FontInfo font) {
    this.font = font;
    return this;
  }

   /**
   * Gets or sets the font for a criterion in a group definition.
   * @return font
  **/
  @ApiModelProperty(value = "Gets or sets the font for a criterion in a group definition.")
  public FontInfo getFont() {
    return font;
  }

  public void setFont(FontInfo font) {
    this.font = font;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupCriterion groupCriterion = (GroupCriterion) o;
    return Objects.equals(this.field, groupCriterion.field) &&
        Objects.equals(this.ascending, groupCriterion.ascending) &&
        Objects.equals(this.groupOn, groupCriterion.groupOn) &&
        Objects.equals(this.groupInterval, groupCriterion.groupInterval) &&
        Objects.equals(this.startAt, groupCriterion.startAt) &&
        Objects.equals(this.cellColor, groupCriterion.cellColor) &&
        Objects.equals(this.fontColor, groupCriterion.fontColor) &&
        Objects.equals(this.pattern, groupCriterion.pattern) &&
        Objects.equals(this.font, groupCriterion.font);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, ascending, groupOn, groupInterval, startAt, cellColor, fontColor, pattern, font);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupCriterion {\n");
    
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    ascending: ").append(toIndentedString(ascending)).append("\n");
    sb.append("    groupOn: ").append(toIndentedString(groupOn)).append("\n");
    sb.append("    groupInterval: ").append(toIndentedString(groupInterval)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    cellColor: ").append(toIndentedString(cellColor)).append("\n");
    sb.append("    fontColor: ").append(toIndentedString(fontColor)).append("\n");
    sb.append("    pattern: ").append(toIndentedString(pattern)).append("\n");
    sb.append("    font: ").append(toIndentedString(font)).append("\n");
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

