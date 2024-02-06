package nz.co.ruben.project.jackson.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import nz.co.ruben.project.jackson.pojo.JacksonRequestPojo;
import nz.co.ruben.project.jackson.pojo.JacksonResponsePojo;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods for building the Json/Xml objects as string using Jackson library methods.
 */
public class JacksonService {

    //Object used for serialization and deserialization of Pojo/Json.
    ObjectMapper jsonMapper = new ObjectMapper();
    public String getJacksonRequestPayload() throws Exception {

        //Creation of final Request Payload object.
        JacksonRequestPojo jacksonRequestPojo = JacksonRequestPojo.builder().data(rootDataObjectList())
                .included(includedList()).build();

        //Converting Pojo to Json.
        return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonRequestPojo);
    }

    List<JacksonRequestPojo.Datum> rootDataObjectList() {

        //Creation of Attributes object.
        JacksonRequestPojo.Attributes attributesObject = JacksonRequestPojo.Attributes.builder()
                .title("JSON:API paints my bikeshed!").body("The shortest article. Ever.")
                .created("2015-05-22T14:56:29.000Z").updated("2015-05-22T14:56:28.000Z").build();
        JacksonRequestPojo.Attributes attributesObject2 = JacksonRequestPojo.Attributes.builder()
                .title("JSON:something!").body("particles theory")
                .created("2015-05-22T14:56:29.000Z").updated("2015-05-22T14:56:28.000Z").build();

        //Creation of Data object which is a child object of Author object.
        JacksonRequestPojo.Datum2 authorDataObject = JacksonRequestPojo.Datum2.builder().id("42").type("people")
                .build();

        //Creation of Author Object.
        JacksonRequestPojo.Author authorObject = JacksonRequestPojo.Author.builder()
                .data(authorDataObject).build();

        //Creation of Relationships object.
        JacksonRequestPojo.Relationships relationshipsObject = JacksonRequestPojo.Relationships.builder()
                .author(authorObject).build();

        //Creation of List to store root Data objects.
        List<JacksonRequestPojo.Datum> rootDataObjectList = new ArrayList<JacksonRequestPojo.Datum>();

        //Creation of root Data objects[].
        JacksonRequestPojo.Datum rootDataObject1 = JacksonRequestPojo.Datum.builder().type("articles")
                .id("1").attributes(attributesObject).relationships(relationshipsObject).build();
        rootDataObjectList.add(rootDataObject1);
        JacksonRequestPojo.Datum rootDataObject2 = JacksonRequestPojo.Datum.builder().type("particles")
                .id("2").attributes(attributesObject2).build();
        rootDataObjectList.add(rootDataObject2);

        return rootDataObjectList;
    }

    List<JacksonRequestPojo.Included> includedList() {

        //Creation of Attributes object which is a child object of Included object.
        JacksonRequestPojo.Attributes1 includedAttributes = JacksonRequestPojo.Attributes1.builder()
                .name("John").age(80).gender("male").build();

        //Creation of List to store Included objects.
        List<JacksonRequestPojo.Included> includedList = new ArrayList<JacksonRequestPojo.Included>();

        //Creation of Included objects[].
        JacksonRequestPojo.Included includedObject1 = JacksonRequestPojo.Included.builder().type("people")
                .id("42").attributes(includedAttributes).build();
        includedList.add(includedObject1);
        JacksonRequestPojo.Included includedObject2 = JacksonRequestPojo.Included.builder().type("strangers")
                .id("52").build();
        includedList.add(includedObject2);

        return includedList;
    }

    public String getJacksonRequestPayloadViaFileRead() throws Exception {

        //Reading the content of json file and storing it as a Java object.
        JacksonResponsePojo jacksonRequestPojoObject = jsonMapper.readValue(
                new File("src/test/resources/json/SampleRequestFile.json"),
                JacksonResponsePojo.class);
        //Converting Pojo to Json.
        return jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonRequestPojoObject);
    }

    public String getJacksonPayloadAsXmlString() throws Exception {
        //Creation of final Request Payload object.
        JacksonRequestPojo jacksonRequestPojo = JacksonRequestPojo.builder().data(rootDataObjectList())
                .included(includedList()).build();

        //Object used for serialization and deserialization of Pojo/Xml.
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        // StringBuilder is used to transfer the content of Pojo.
        StringWriter stringWriter = new StringWriter();

        // converting Pojo to Xml.
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(stringWriter, jacksonRequestPojo);

        return stringWriter.toString();
    }

    public String getJacksonPayloadAsXmlStringWithoutStringBuilder() throws Exception {
        //Creation of final Request Payload object.
        JacksonRequestPojo jacksonRequestPojo = JacksonRequestPojo.builder().data(rootDataObjectList())
                .included(includedList()).build();
        //Object used for serialization and deserialization of Pojo/Xml.
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);

        return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jacksonRequestPojo);
    }
}
