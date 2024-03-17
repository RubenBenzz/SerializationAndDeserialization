package nz.co.ruben.project.gsonbuildviajsonfile.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Pojo for sample json payload.
 * The private members of the class are annotated with Gson library annotations.
 * @Expose - This annotation makes the class variable visible for serialization/deserialization.
 * @SerializedName - This annotation provides a way to rename (override) class variables and the final payload is
 * constructed using these names.
 * This pojo has got constructors which will be used to set values dynamically by the calling test / method.
 */
public class GsonRequestPojo {
    @SerializedName("data")
    @Expose
    public List<Datum> data;
    @SerializedName("included")
    @Expose
    public List<Included> included;

    public static class Datum {
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("attributes")
        @Expose
        public Attributes attributes;
        @SerializedName("relationships")
        @Expose
        public Relationships relationships;
    }

    public static class Attributes {
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("body")
        @Expose
        public String body;
        @SerializedName("created")
        @Expose
        public String created;
        @SerializedName("updated")
        @Expose
        public String updated;
    }

    public static class Relationships {
        @SerializedName("author")
        @Expose
        public Author author;
    }

    public static class Author {
        @SerializedName("data")
        @Expose
        public Datum2 data;
    }

    public static class Datum2 {
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("type")
        @Expose
        public String type;
    }

    public static class Included {
        @SerializedName("type")
        @Expose
        public String type;
        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("attributes")
        @Expose
        public Attributes1 attributes;
    }

    public static class Attributes1 {
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("age")
        @Expose
        public Integer age;
        @SerializedName("gender")
        @Expose
        public String gender;
    }

    public GsonRequestPojo setFirstTitle(String value) {
        this.data.get(0).attributes.title = value;
        return this;
    }

    public GsonRequestPojo setSecondTitle(String value) {
        this.data.get(1).attributes.title = value;
        return this;
    }

    public GsonRequestPojo setFirstIncludedType(String value) {
        this.included.get(0).type = value;
        return this;
    }

    public GsonRequestPojo setSecondIncludedType(String value) {
        this.included.get(1).type = value;
        return this;
    }

}
