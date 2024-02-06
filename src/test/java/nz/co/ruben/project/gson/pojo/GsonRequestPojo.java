package nz.co.ruben.project.gson.pojo;

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
 * The Pojo class itself is annotated with Lombok library annotations.
 * @Data - This annotation generates getters and setters for the class.
 * @Builder - This annotation provides a build pattern to build the Pojo object.
 */
@Data
@Builder
public class GsonRequestPojo {

    @SerializedName("data")
    @Expose
    private List<Datum> data;
    @SerializedName("included")
    @Expose
    private List<Included> included;

    @Data
    @Builder
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
    @Builder
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
    @Builder
    public static class Relationships {
        @SerializedName("author")
        @Expose
        private Author author;
    }

    @Data
    @Builder
    public static class Author {
        @SerializedName("data")
        @Expose
        private Datum2 data;
    }

    @Data
    @Builder
    public static class Datum2 {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("type")
        @Expose
        private String type;
    }

    @Data
    @Builder
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
    @Builder
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
