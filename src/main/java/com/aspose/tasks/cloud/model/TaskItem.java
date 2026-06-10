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
import com.aspose.tasks.cloud.model.Link;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * A task&#39;s brief info 
 */
@ApiModel(description = "A task's brief info ")

public class TaskItem {
  @SerializedName("Link")
  private Link link = null;

  @SerializedName("Uid")
  private Integer uid = null;

  @SerializedName("Id")
  private Integer id = null;

  @SerializedName("Name")
  private String name = null;

  @SerializedName("Start")
  private OffsetDateTime start = null;

  @SerializedName("Finish")
  private OffsetDateTime finish = null;

  @SerializedName("Duration")
  private String duration = null;

  @SerializedName("ActivityId")
  private String activityId = null;

  public TaskItem link(Link link) {
    this.link = link;
    return this;
  }

   /**
   * Get link
   * @return link
  **/
  @ApiModelProperty(value = "")
  public Link getLink() {
    return link;
  }

  public void setLink(Link link) {
    this.link = link;
  }

  public TaskItem uid(Integer uid) {
    this.uid = uid;
    return this;
  }

   /**
   * Get uid
   * @return uid
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public TaskItem id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TaskItem name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TaskItem start(OffsetDateTime start) {
    this.start = start;
    return this;
  }

   /**
   * Get start
   * @return start
  **/
  @ApiModelProperty(required = true, value = "")
  public OffsetDateTime getStart() {
    return start;
  }

  public void setStart(OffsetDateTime start) {
    this.start = start;
  }

  public TaskItem finish(OffsetDateTime finish) {
    this.finish = finish;
    return this;
  }

   /**
   * Get finish
   * @return finish
  **/
  @ApiModelProperty(required = true, value = "")
  public OffsetDateTime getFinish() {
    return finish;
  }

  public void setFinish(OffsetDateTime finish) {
    this.finish = finish;
  }

  public TaskItem duration(String duration) {
    this.duration = duration;
    return this;
  }

   /**
   * The duration of a task.
   * @return duration
  **/
  @ApiModelProperty(required = true, value = "The duration of a task.")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public TaskItem activityId(String activityId) {
    this.activityId = activityId;
    return this;
  }

   /**
   * Represents activity id field - a task&#39;s unique identifier used by Primavera.     (only applicable to Primavera projects)
   * @return activityId
  **/
  @ApiModelProperty(value = "Represents activity id field - a task's unique identifier used by Primavera.     (only applicable to Primavera projects)")
  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskItem taskItem = (TaskItem) o;
    return Objects.equals(this.link, taskItem.link) &&
        Objects.equals(this.uid, taskItem.uid) &&
        Objects.equals(this.id, taskItem.id) &&
        Objects.equals(this.name, taskItem.name) &&
        Objects.equals(this.start, taskItem.start) &&
        Objects.equals(this.finish, taskItem.finish) &&
        Objects.equals(this.duration, taskItem.duration) &&
        Objects.equals(this.activityId, taskItem.activityId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(link, uid, id, name, start, finish, duration, activityId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskItem {\n");
    
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    start: ").append(toIndentedString(start)).append("\n");
    sb.append("    finish: ").append(toIndentedString(finish)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
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

