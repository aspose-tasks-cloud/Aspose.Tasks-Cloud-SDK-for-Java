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

package com.aspose.tasks.cloud;

import com.aspose.tasks.cloud.model.*;
import com.aspose.tasks.cloud.model.responses.*;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeParseException;
import com.google.gson.*;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.GsonFireBuilder;
import io.gsonfire.TypeSelector;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;

import okio.ByteString;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class JSON {
    private Gson gson;
    private boolean isLenientOnJson = false;
    private DateTypeAdapter dateTypeAdapter = new DateTypeAdapter();
    private SqlDateTypeAdapter sqlDateTypeAdapter = new SqlDateTypeAdapter();
    private OffsetDateTimeTypeAdapter offsetDateTimeTypeAdapter = new OffsetDateTimeTypeAdapter();
    private LocalDateTypeAdapter localDateTypeAdapter = new LocalDateTypeAdapter();
    private ByteArrayAdapter byteArrayAdapter = new ByteArrayAdapter();

    public JSON() {
        gson = createGson()
                .registerTypeAdapter(Date.class, dateTypeAdapter)
                .registerTypeAdapter(java.sql.Date.class, sqlDateTypeAdapter)
                .registerTypeAdapter(OffsetDateTime.class, offsetDateTimeTypeAdapter)
                .registerTypeAdapter(LocalDate.class, localDateTypeAdapter)
                .registerTypeAdapter(byte[].class, byteArrayAdapter)
                .create();
    }

    public static GsonBuilder createGson() {
        GsonFireBuilder fireBuilder = new GsonFireBuilder()/*
          .registerTypeSelector(Baseline.class, new TypeSelector() {
            @Override
            public Class getClassForElement(JsonElement readElement) {
                Map classByDiscriminatorValue = new HashMap();
                classByDiscriminatorValue.put("AssignmentBaseline".toUpperCase(), AssignmentBaseline.class);
                classByDiscriminatorValue.put("TaskBaseline".toUpperCase(), TaskBaseline.class);
                classByDiscriminatorValue.put("Baseline".toUpperCase(), Baseline.class);
                return getClassByDiscriminator(
                                           classByDiscriminatorValue,
                                           getDiscriminatorValue(readElement, "Type"));
            }
          })
          .registerTypeSelector(AsposeResponse.class, new TypeSelector() {
            @Override
            public Class getClassForElement(JsonElement readElement) {
                Map classByDiscriminatorValue = new HashMap();
                classByDiscriminatorValue.put("AssignmentItemResponse".toUpperCase(), AssignmentItemResponse.class);
                classByDiscriminatorValue.put("AssignmentItemsResponse".toUpperCase(), AssignmentItemsResponse.class);
                classByDiscriminatorValue.put("AssignmentResponse".toUpperCase(), AssignmentResponse.class);
                classByDiscriminatorValue.put("AssignmentsResponse".toUpperCase(), AssignmentsResponse.class);
                classByDiscriminatorValue.put("CalendarExceptionsResponse".toUpperCase(), CalendarExceptionsResponse.class);
                classByDiscriminatorValue.put("CalendarItemResponse".toUpperCase(), CalendarItemResponse.class);
                classByDiscriminatorValue.put("CalendarItemsResponse".toUpperCase(), CalendarItemsResponse.class);
                classByDiscriminatorValue.put("CalendarResponse".toUpperCase(), CalendarResponse.class);
                classByDiscriminatorValue.put("CalendarWorkWeeksResponse".toUpperCase(), CalendarWorkWeeksResponse.class);
                classByDiscriminatorValue.put("DocumentPropertiesResponse".toUpperCase(), DocumentPropertiesResponse.class);
                classByDiscriminatorValue.put("DocumentPropertyResponse".toUpperCase(), DocumentPropertyResponse.class);
                classByDiscriminatorValue.put("ExtendedAttributeItemResponse".toUpperCase(), ExtendedAttributeItemResponse.class);
                classByDiscriminatorValue.put("ExtendedAttributeItemsResponse".toUpperCase(), ExtendedAttributeItemsResponse.class);
                classByDiscriminatorValue.put("ExtendedAttributeResponse".toUpperCase(), ExtendedAttributeResponse.class);
                classByDiscriminatorValue.put("OutlineCodeItemsResponse".toUpperCase(), OutlineCodeItemsResponse.class);
                classByDiscriminatorValue.put("OutlineCodeResponse".toUpperCase(), OutlineCodeResponse.class);
                classByDiscriminatorValue.put("PageCountResponse".toUpperCase(), PageCountResponse.class);
                classByDiscriminatorValue.put("ProjectIdsResponse".toUpperCase(), ProjectIdsResponse.class);
                classByDiscriminatorValue.put("ProjectListResponse".toUpperCase(), ProjectListResponse.class);
                classByDiscriminatorValue.put("ProjectRecalculateResponse".toUpperCase(), ProjectRecalculateResponse.class);
                classByDiscriminatorValue.put("RecurringInfoResponse".toUpperCase(), RecurringInfoResponse.class);
                classByDiscriminatorValue.put("ResourceItemResponse".toUpperCase(), ResourceItemResponse.class);
                classByDiscriminatorValue.put("ResourceItemsResponse".toUpperCase(), ResourceItemsResponse.class);
                classByDiscriminatorValue.put("ResourceResponse".toUpperCase(), ResourceResponse.class);
                classByDiscriminatorValue.put("TaskItemResponse".toUpperCase(), TaskItemResponse.class);
                classByDiscriminatorValue.put("TaskItemsResponse".toUpperCase(), TaskItemsResponse.class);
                classByDiscriminatorValue.put("TaskLinkResponse".toUpperCase(), TaskLinkResponse.class);
                classByDiscriminatorValue.put("TaskLinksResponse".toUpperCase(), TaskLinksResponse.class);
                classByDiscriminatorValue.put("TaskResponse".toUpperCase(), TaskResponse.class);
                classByDiscriminatorValue.put("TimephasedDataResponse".toUpperCase(), TimephasedDataResponse.class);
                classByDiscriminatorValue.put("VbaProjectResponse".toUpperCase(), VbaProjectResponse.class);
                classByDiscriminatorValue.put("WBSDefinitionResponse".toUpperCase(), WBSDefinitionResponse.class);
                classByDiscriminatorValue.put("AsposeResponse".toUpperCase(), AsposeResponse.class);
                return getClassByDiscriminator(
                                           classByDiscriminatorValue,
                                           getDiscriminatorValue(readElement, "Type"));
            }
          })
          .registerTypeSelector(LinkElement.class, new TypeSelector() {
            @Override
            public Class getClassForElement(JsonElement readElement) {
                Map classByDiscriminatorValue = new HashMap();
                classByDiscriminatorValue.put("AssignmentItems".toUpperCase(), AssignmentItems.class);
                classByDiscriminatorValue.put("CalendarItems".toUpperCase(), CalendarItems.class);
                classByDiscriminatorValue.put("DocumentProperties".toUpperCase(), DocumentProperties.class);
                classByDiscriminatorValue.put("DocumentProperty".toUpperCase(), DocumentProperty.class);
                classByDiscriminatorValue.put("ExtendedAttributeItems".toUpperCase(), ExtendedAttributeItems.class);
                classByDiscriminatorValue.put("OutlineCodeItems".toUpperCase(), OutlineCodeItems.class);
                classByDiscriminatorValue.put("ProjectList".toUpperCase(), ProjectList.class);
                classByDiscriminatorValue.put("ResourceAssignments".toUpperCase(), ResourceAssignments.class);
                classByDiscriminatorValue.put("ResourceItems".toUpperCase(), ResourceItems.class);
                classByDiscriminatorValue.put("TaskItems".toUpperCase(), TaskItems.class);
                classByDiscriminatorValue.put("LinkElement".toUpperCase(), LinkElement.class);
                return getClassByDiscriminator(
                                           classByDiscriminatorValue,
                                           getDiscriminatorValue(readElement, "Type"));
            }
          })
          .registerTypeSelector(StorageFile.class, new TypeSelector() {
            @Override
            public Class getClassForElement(JsonElement readElement) {
                Map classByDiscriminatorValue = new HashMap();
                classByDiscriminatorValue.put("FileVersion".toUpperCase(), FileVersion.class);
                classByDiscriminatorValue.put("StorageFile".toUpperCase(), StorageFile.class);
                return getClassByDiscriminator(
                                           classByDiscriminatorValue,
                                           getDiscriminatorValue(readElement, "Type"));
            }
          })*/;
        GsonBuilder builder = fireBuilder.createGsonBuilder();
        return builder;
    }

    private static String getDiscriminatorValue(JsonElement readElement, String discriminatorField) {
        JsonElement element = readElement.getAsJsonObject().get(discriminatorField);
        if (null == element) {
            throw new IllegalArgumentException("missing discriminator field: <" + discriminatorField + ">");
        }
        return element.getAsString();
    }

    private static Class getClassByDiscriminator(Map classByDiscriminatorValue, String discriminatorValue) {
        Class clazz = (Class) classByDiscriminatorValue.get(discriminatorValue.toUpperCase());
        if (null == clazz) {
            throw new IllegalArgumentException("cannot determine model class of name: <" + discriminatorValue + ">");
        }
        return clazz;
    }

    /**
     * Get Gson.
     *
     * @return Gson
     */
    public Gson getGson() {
        return gson;
    }

    /**
     * Set Gson.
     *
     * @param gson Gson
     * @return JSON
     */
    public JSON setGson(Gson gson) {
        this.gson = gson;
        return this;
    }

    public JSON setLenientOnJson(boolean lenientOnJson) {
        isLenientOnJson = lenientOnJson;
        return this;
    }

    /**
     * Serialize the given Java object into JSON string.
     *
     * @param obj Object
     * @return String representation of the JSON
     */
    public String serialize(Object obj) {
        if(obj instanceof java.time.OffsetDateTime){
            obj = obj.toString();
        }
        return gson.toJson(obj);
    }

    /**
     * Deserialize the given JSON string to Java object.
     *
     * @param <T>        Type
     * @param body       The JSON string
     * @param returnType The type to deserialize into
     * @return The deserialized Java object
     */
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String body, Type returnType) {
        try {
            if (isLenientOnJson) {
                JsonReader jsonReader = new JsonReader(new StringReader(body));
                // see https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
                jsonReader.setLenient(true);
                return gson.fromJson(jsonReader, returnType);
            } else {
                return gson.fromJson(body, returnType);
            }
        } catch (JsonParseException e) {
            // Fallback processing when failed to parse JSON form response body:
            // return the response body string directly for the String return type;
            if (returnType.equals(String.class))
                return (T) body;
            else throw (e);
        }
    }

    public JSON setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        offsetDateTimeTypeAdapter.setFormat(dateFormat);
        return this;
    }

    public JSON setLocalDateFormat(DateTimeFormatter dateFormat) {
        localDateTypeAdapter.setFormat(dateFormat);
        return this;
    }

    public JSON setDateFormat(DateFormat dateFormat) {
        dateTypeAdapter.setFormat(dateFormat);
        return this;
    }

    public JSON setSqlDateFormat(DateFormat dateFormat) {
        sqlDateTypeAdapter.setFormat(dateFormat);
        return this;
    }

    /**
     * Gson TypeAdapter for JSR310 OffsetDateTime type
     */
    public static class OffsetDateTimeTypeAdapter extends TypeAdapter<OffsetDateTime> {

        private DateTimeFormatter formatter;

        public OffsetDateTimeTypeAdapter() {
            this(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        }

        public OffsetDateTimeTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, OffsetDateTime date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public OffsetDateTime read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    try {
                        return OffsetDateTime.parse(date, formatter);
                    } catch (DateTimeParseException e1) {
                        try {
                            return OffsetDateTime.parse(date);
                        } catch (DateTimeParseException e2) {
                            try {
                                LocalDateTime ldt = LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                                return OffsetDateTime.of(ldt, ZoneOffset.UTC);
                            } catch (DateTimeParseException e3) {
                                String normalized = normalizeOffsetDateTimeString(date);
                                try {
                                    return OffsetDateTime.parse(normalized, formatter);
                                } catch (DateTimeParseException e4) {
                                    try {
                                        return OffsetDateTime.parse(normalized);
                                    } catch (DateTimeParseException e5) {
                                        LocalDateTime ldt2 = LocalDateTime.parse(normalized, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                                        return OffsetDateTime.of(ldt2, ZoneOffset.UTC);
                                    }
                                }
                            }
                        }
                    }
            }
        }

        private static String normalizeOffsetDateTimeString(String input) {
            int tIndex = input.indexOf('T');
            if (tIndex < 0) return input;

            int plus = input.indexOf('+', tIndex);
            int minus = input.indexOf('-', tIndex);
            int tzPos;
            if (plus == -1 && minus == -1) {
                tzPos = -1;
            } else if (plus == -1) {
                tzPos = minus;
            } else if (minus == -1) {
                tzPos = plus;
            } else {
                tzPos = Math.min(plus, minus);
            }

            String main;
            String offset = "";
            if (tzPos >= 0) {
                main = input.substring(0, tzPos);
                offset = input.substring(tzPos);
            } else {
                main = input;
            }

            if (main.contains(".")) {
                int dot = main.indexOf('.');
                String before = main.substring(0, dot);
                String fraction = main.substring(dot + 1);
                fraction = fraction.replaceAll("[^0-9]", "");
                if (fraction.length() > 9) fraction = fraction.substring(0, 9);
                while (fraction.length() < 9) fraction = fraction + "0";
                main = before + "." + fraction;
            }

            if (!offset.isEmpty()) {
                if (offset.matches("^[+-]\\d{2}$")) {
                    offset = offset + ":00";
                }
                else if (offset.matches("^[+-]\\d{4}$")) {
                    offset = offset.substring(0, 3) + ":" + offset.substring(3);
                }
            }

            return main + offset;
        }
    }

    /**
     * Gson TypeAdapter for java.sql.Date type
     * If the dateFormat is null, a simple "yyyy-MM-dd" format will be used
     * (more efficient than SimpleDateFormat).
     */
    public static class SqlDateTypeAdapter extends TypeAdapter<java.sql.Date> {

        private DateFormat dateFormat;

        public SqlDateTypeAdapter() {
        }

        public SqlDateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, java.sql.Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = date.toString();
                }
                out.value(value);
            }
        }

        @Override
        public java.sql.Date read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    try {
                        if (dateFormat != null) {
                            return new java.sql.Date(dateFormat.parse(date).getTime());
                        }
                        return new java.sql.Date(ISO8601Utils.parse(date, new ParsePosition(0)).getTime());
                    } catch (ParseException e) {
                        throw new JsonParseException(e);
                    }
            }
        }
    }

    /**
     * Gson TypeAdapter for java.util.Date type
     * If the dateFormat is null, ISO8601Utils will be used.
     */
    public static class DateTypeAdapter extends TypeAdapter<Date> {

        private DateFormat dateFormat;

        public DateTypeAdapter() {
        }

        public DateTypeAdapter(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        public void setFormat(DateFormat dateFormat) {
            this.dateFormat = dateFormat;
        }

        @Override
        public void write(JsonWriter out, Date date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                String value;
                if (dateFormat != null) {
                    value = dateFormat.format(date);
                } else {
                    value = ISO8601Utils.format(date, true);
                }
                out.value(value);
            }
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            try {
                switch (in.peek()) {
                    case NULL:
                        in.nextNull();
                        return null;
                    default:
                        String date = in.nextString();
                        try {
                            if (dateFormat != null) {
                                return dateFormat.parse(date);
                            }
                            return ISO8601Utils.parse(date, new ParsePosition(0));
                        } catch (ParseException e) {
                            throw new JsonParseException(e);
                        }
                }
            } catch (IllegalArgumentException e) {
                throw new JsonParseException(e);
            }
        }
    }

    /**
     * Gson TypeAdapter for Byte Array type
     */
    public class ByteArrayAdapter extends TypeAdapter<byte[]> {

        @Override
        public void write(JsonWriter out, byte[] value) throws IOException {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(ByteString.of(value).base64());
            }
        }

        @Override
        public byte[] read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String bytesAsBase64 = in.nextString();
                    ByteString byteString = ByteString.decodeBase64(bytesAsBase64);
                    return byteString.toByteArray();
            }
        }
    }

    /**
     * Gson TypeAdapter for JSR310 LocalDate type
     */
    public class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

        private DateTimeFormatter formatter;

        public LocalDateTypeAdapter() {
            this(DateTimeFormatter.ISO_LOCAL_DATE);
        }

        public LocalDateTypeAdapter(DateTimeFormatter formatter) {
            this.formatter = formatter;
        }

        public void setFormat(DateTimeFormatter dateFormat) {
            this.formatter = dateFormat;
        }

        @Override
        public void write(JsonWriter out, LocalDate date) throws IOException {
            if (date == null) {
                out.nullValue();
            } else {
                out.value(formatter.format(date));
            }
        }

        @Override
        public LocalDate read(JsonReader in) throws IOException {
            switch (in.peek()) {
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    String date = in.nextString();
                    return LocalDate.parse(date, formatter);
            }
        }
    }
}
