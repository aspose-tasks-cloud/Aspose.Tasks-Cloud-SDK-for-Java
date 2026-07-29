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
import com.aspose.tasks.cloud.model.TaskItem;
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
 * Represents a single bucket of a task grouping result: the tasks sharing the same group key.
 */
@ApiModel(description = "Represents a single bucket of a task grouping result: the tasks sharing the same group key.")

public class TaskGroupBucket {
  @SerializedName("Key")
  private String key = null;

  @SerializedName("Tasks")
  private List<TaskItem> tasks = null;

  public TaskGroupBucket key(String key) {
    this.key = key;
    return this;
  }

   /**
   * The group key the bucketed tasks share.
   * @return key
  **/
  @ApiModelProperty(value = "The group key the bucketed tasks share.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public TaskGroupBucket tasks(List<TaskItem> tasks) {
    this.tasks = tasks;
    return this;
  }

  public TaskGroupBucket addTasksItem(TaskItem tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<TaskItem>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

   /**
   * Tasks falling into this bucket.
   * @return tasks
  **/
  @ApiModelProperty(value = "Tasks falling into this bucket.")
  public List<TaskItem> getTasks() {
    return tasks;
  }

  public void setTasks(List<TaskItem> tasks) {
    this.tasks = tasks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskGroupBucket taskGroupBucket = (TaskGroupBucket) o;
    return Objects.equals(this.key, taskGroupBucket.key) &&
        Objects.equals(this.tasks, taskGroupBucket.tasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, tasks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskGroupBucket {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
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

