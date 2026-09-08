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
import com.aspose.tasks.cloud.model.VbaModuleType;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Represents the body of a request that creates a new VBA module.
 */
@ApiModel(description = "Represents the body of a request that creates a new VBA module.")

public class CreateVbaModuleRequest {
  @SerializedName("Name")
  private String name = null;

  @SerializedName("Type")
  private VbaModuleType type = null;

  @SerializedName("SourceCode")
  private String sourceCode = null;

  public CreateVbaModuleRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Gets or sets the name of the VBA module to create.
   * @return name
  **/
  @ApiModelProperty(value = "Gets or sets the name of the VBA module to create.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateVbaModuleRequest type(VbaModuleType type) {
    this.type = type;
    return this;
  }

   /**
   * Gets or sets the type of the VBA module to create. Only ProceduralModule and ClassModule can be created; other values are rejected.
   * @return type
  **/
  @ApiModelProperty(required = true, value = "Gets or sets the type of the VBA module to create. Only ProceduralModule and ClassModule can be created; other values are rejected.")
  public VbaModuleType getType() {
    return type;
  }

  public void setType(VbaModuleType type) {
    this.type = type;
  }

  public CreateVbaModuleRequest sourceCode(String sourceCode) {
    this.sourceCode = sourceCode;
    return this;
  }

   /**
   * Gets or sets the source code to store in the new VBA module.
   * @return sourceCode
  **/
  @ApiModelProperty(value = "Gets or sets the source code to store in the new VBA module.")
  public String getSourceCode() {
    return sourceCode;
  }

  public void setSourceCode(String sourceCode) {
    this.sourceCode = sourceCode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateVbaModuleRequest createVbaModuleRequest = (CreateVbaModuleRequest) o;
    return Objects.equals(this.name, createVbaModuleRequest.name) &&
        Objects.equals(this.type, createVbaModuleRequest.type) &&
        Objects.equals(this.sourceCode, createVbaModuleRequest.sourceCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, sourceCode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateVbaModuleRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    sourceCode: ").append(toIndentedString(sourceCode)).append("\n");
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

