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

package com.aspose.tasks.cloud.model.responses;

import java.util.Objects;
import java.util.Arrays;
import com.aspose.tasks.cloud.model.responses.AsposeResponse;
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
 * Represents the results of resource leveling.
 */
@ApiModel(description = "Represents the results of resource leveling.")

public class LevelingResponse extends AsposeResponse {
  @SerializedName("AffectedTaskUids")
  private List<Integer> affectedTaskUids = null;

  public LevelingResponse affectedTaskUids(List<Integer> affectedTaskUids) {
    this.affectedTaskUids = affectedTaskUids;
    return this;
  }

  public LevelingResponse addAffectedTaskUidsItem(Integer affectedTaskUidsItem) {
    if (this.affectedTaskUids == null) {
      this.affectedTaskUids = new ArrayList<Integer>();
    }
    this.affectedTaskUids.add(affectedTaskUidsItem);
    return this;
  }

   /**
   * Gets a set of task uids affected by resource leveling.
   * @return affectedTaskUids
  **/
  @ApiModelProperty(value = "Gets a set of task uids affected by resource leveling.")
  public List<Integer> getAffectedTaskUids() {
    return affectedTaskUids;
  }

  public void setAffectedTaskUids(List<Integer> affectedTaskUids) {
    this.affectedTaskUids = affectedTaskUids;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LevelingResponse levelingResponse = (LevelingResponse) o;
    return Objects.equals(this.affectedTaskUids, levelingResponse.affectedTaskUids) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(affectedTaskUids, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LevelingResponse {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    affectedTaskUids: ").append(toIndentedString(affectedTaskUids)).append("\n");
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

