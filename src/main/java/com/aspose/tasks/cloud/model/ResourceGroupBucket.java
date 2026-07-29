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
import com.aspose.tasks.cloud.model.ResourceItem;
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
 * Represents a single bucket of a resource grouping result: the resources sharing the same group key.
 */
@ApiModel(description = "Represents a single bucket of a resource grouping result: the resources sharing the same group key.")

public class ResourceGroupBucket {
  @SerializedName("Key")
  private String key = null;

  @SerializedName("Resources")
  private List<ResourceItem> resources = null;

  public ResourceGroupBucket key(String key) {
    this.key = key;
    return this;
  }

   /**
   * The group key the bucketed resources share.
   * @return key
  **/
  @ApiModelProperty(value = "The group key the bucketed resources share.")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public ResourceGroupBucket resources(List<ResourceItem> resources) {
    this.resources = resources;
    return this;
  }

  public ResourceGroupBucket addResourcesItem(ResourceItem resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<ResourceItem>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Resources falling into this bucket.
   * @return resources
  **/
  @ApiModelProperty(value = "Resources falling into this bucket.")
  public List<ResourceItem> getResources() {
    return resources;
  }

  public void setResources(List<ResourceItem> resources) {
    this.resources = resources;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceGroupBucket resourceGroupBucket = (ResourceGroupBucket) o;
    return Objects.equals(this.key, resourceGroupBucket.key) &&
        Objects.equals(this.resources, resourceGroupBucket.resources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, resources);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceGroupBucket {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
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

