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
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Specifies the type of grouping for a field used as a criterion in a group definition.
 */
@JsonAdapter(GroupOn.Adapter.class)
public enum GroupOn {
  
  EACHVALUE("EachValue"),
  
  INTERVAL("Interval"),
  
  DATEEACHVALUE("DateEachValue"),
  
  DATEMINUTE("DateMinute"),
  
  DATEHOUR("DateHour"),
  
  DATEDAY("DateDay"),
  
  DATEWEEK("DateWeek"),
  
  DATETHIRDOFMONTH("DateThirdOfMonth"),
  
  DATEMONTH("DateMonth"),
  
  DATEQTR("DateQtr"),
  
  DATEYEAR("DateYear"),
  
  DURATIONEACHVALUE("DurationEachValue"),
  
  DURATIONMINUTES("DurationMinutes"),
  
  DURATIONHOURS("DurationHours"),
  
  DURATIONDAYS("DurationDays"),
  
  DURATIONWEEKS("DurationWeeks"),
  
  DURATIONMONTHS("DurationMonths"),
  
  OUTLINEEACHVALUE("OutlineEachValue"),
  
  OUTLINELEVEL("OutlineLevel"),
  
  PCTEACHVALUE("PctEachValue"),
  
  PCTINTERVAL("PctInterval"),
  
  PCT199("Pct199"),
  
  PCT150("Pct150"),
  
  PCT125("Pct125"),
  
  PCT110("Pct110"),
  
  TEXTEACHVALUE("TextEachValue"),
  
  TEXTPREFIX("TextPrefix");

  private String value;

  GroupOn(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static GroupOn fromValue(String text) {
    for (GroupOn b : GroupOn.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<GroupOn> {
    @Override
    public void write(final JsonWriter jsonWriter, final GroupOn enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public GroupOn read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return GroupOn.fromValue(String.valueOf(value));
    }
  }
}

