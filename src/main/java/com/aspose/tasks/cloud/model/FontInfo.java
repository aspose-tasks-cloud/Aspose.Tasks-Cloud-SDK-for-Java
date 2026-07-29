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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * Represents a brief read-only information about a font used in a group criterion.
 */
@ApiModel(description = "Represents a brief read-only information about a font used in a group criterion.")

public class FontInfo {
  @SerializedName("FontFamily")
  private String fontFamily = null;

  @SerializedName("Size")
  private Double size = null;

  @SerializedName("Style")
  private String style = null;

  public FontInfo fontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
    return this;
  }

   /**
   * Gets or sets the font family name.
   * @return fontFamily
  **/
  @ApiModelProperty(value = "Gets or sets the font family name.")
  public String getFontFamily() {
    return fontFamily;
  }

  public void setFontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
  }

  public FontInfo size(Double size) {
    this.size = size;
    return this;
  }

   /**
   * Gets or sets the em-size of the font.
   * @return size
  **/
  @ApiModelProperty(required = true, value = "Gets or sets the em-size of the font.")
  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public FontInfo style(String style) {
    this.style = style;
    return this;
  }

   /**
   * Gets or sets the style information applied to the font.
   * @return style
  **/
  @ApiModelProperty(value = "Gets or sets the style information applied to the font.")
  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FontInfo fontInfo = (FontInfo) o;
    return Objects.equals(this.fontFamily, fontInfo.fontFamily) &&
        Objects.equals(this.size, fontInfo.size) &&
        Objects.equals(this.style, fontInfo.style);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fontFamily, size, style);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FontInfo {\n");
    
    sb.append("    fontFamily: ").append(toIndentedString(fontFamily)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    style: ").append(toIndentedString(style)).append("\n");
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

