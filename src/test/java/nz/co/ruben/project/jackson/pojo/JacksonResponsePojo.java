package nz.co.ruben.project.jackson.pojo;

import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Pojo for sample json payload.
 * The private members of the class are annotated with Jackson library annotations.
 * @JsonInclude - This annotation removes null values during serialization/deserialization.
 * @JsonPropertyOrder - This annotation maintains the true order instance variables.
 * When the Pojo object is build the order or variables will be maintained even when the object is built
 * in the wrong order.
 * @JsonProperty - This annotation provides a way to rename (override) class variables and the final payload is
 * constructed using these names.
 * The Pojo class itself is annotated with Lombok library annotations.
 * @Data - This annotation generates getters and setters for the class.
 * @Builder - This annotation provides a build pattern to build the Pojo object.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data", "included"})
@Data
@NoArgsConstructor
@JsonPOJOBuilder
public class JacksonResponsePojo {

    @JsonProperty("data")
    private List<Datum> data;
    @JsonProperty("included")
    private List<Included> included;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"type", "id", "attributes", "relationships"})
    @Data
    @NoArgsConstructor
    public static class Datum {
        @JsonProperty("type")
        private String type;
        @JsonProperty("id")
        private String id;
        @JsonProperty("attributes")
        private Attributes attributes;
        @JsonProperty("relationships")
        private Relationships relationships;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"title", "body", "created", "updated"})
    @Data
    @NoArgsConstructor
    public static class Attributes {
        @JsonProperty("title")
        private String title;
        @JsonProperty("body")
        private String body;
        @JsonProperty("created")
        private String created;
        @JsonProperty("updated")
        private String updated;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"author"})
    @Data
    @NoArgsConstructor
    public static class Relationships {
        @JsonProperty("author")
        private Author author;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"data"})
    @Data
    @NoArgsConstructor
    public static class Author {
        @JsonProperty("data")
        private Datum2 data;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"id", "type"})
    @Data
    @NoArgsConstructor
    public static class Datum2 {
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"type", "id", "attributes"})
    @Data
    @NoArgsConstructor
    public static class Included {
        @JsonProperty("type")
        private String type;
        @JsonProperty("id")
        private String id;
        @JsonProperty("attributes")
        private Attributes1 attributes;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"name", "age", "gender"})
    @Data
    @NoArgsConstructor
    public static class Attributes1 {
        @JsonProperty("name")
        private String name;
        @JsonProperty("age")
        private Integer age;
        @JsonProperty("gender")
        private String gender;
    }
}

