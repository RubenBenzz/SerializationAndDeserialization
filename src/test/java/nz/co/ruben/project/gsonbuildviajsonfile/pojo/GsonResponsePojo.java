package nz.co.ruben.project.gsonbuildviajsonfile.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Pojo for sample json payload.
 * The private members of the class are annotated with Gson library annotations.
 * @Expose - This annotation makes the class variable visible for serialization/deserialization.
 * @SerializedName - This annotation provides a way to rename (override) class variables and the final payload is
 * constructed using these names.
 * The Pojo class itself is annotated with Lombok library annotations.
 * @Data - This annotation generates getters and setters for the class.
 * @NoArgsConstructer - This annotation generates a no argument constructor for the class.
 */
@Data
@NoArgsConstructor
public class GsonResponsePojo {

    @SerializedName("data")
    @Expose
    private List<Datum> data;
    @SerializedName("included")
    @Expose
    private List<Included> included;

    @Data
    @NoArgsConstructor
    public static class Datum {
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("attributes")
        @Expose
        private Attributes attributes;
        @SerializedName("relationships")
        @Expose
        private Relationships relationships;
    }

    @Data
    @NoArgsConstructor
    public static class Attributes {
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("body")
        @Expose
        private String body;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("updated")
        @Expose
        private String updated;
    }

    @Data
    @NoArgsConstructor
    public static class Relationships {
        @SerializedName("author")
        @Expose
        private Author author;
    }

    @Data
    @NoArgsConstructor
    public static class Author {
        @SerializedName("data")
        @Expose
        private Datum2 data;
    }

    @Data
    @NoArgsConstructor
    public static class Datum2 {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("type")
        @Expose
        private String type;
    }

    @Data
    @NoArgsConstructor
    public static class Included {
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("attributes")
        @Expose
        private Attributes1 attributes;
    }

    @Data
    @NoArgsConstructor
    public static class Attributes1 {
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("age")
        @Expose
        private Integer age;
        @SerializedName("gender")
        @Expose
        private String gender;
    }
}
