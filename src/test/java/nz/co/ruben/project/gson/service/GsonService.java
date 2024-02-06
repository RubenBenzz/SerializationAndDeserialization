package nz.co.ruben.project.gson.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nz.co.ruben.project.gson.pojo.GsonRequestPojo;
import nz.co.ruben.project.gson.pojo.GsonResponsePojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods for building the Json/Xml objects as string using Gson library methods.
 */
public class GsonService {

    //Object used for serialization and deserialization of Pojo/Json.
    Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();

    //Object used for serialization and deserialization of Pojo/Xml.
    XmlMapper xmlMapper = new XmlMapper();


    public String getGsonRequestPayload() throws Exception {

        //Creation of final Request Payload object using Lombok builder pattern.
         GsonRequestPojo gsonRequestPojo = GsonRequestPojo.builder().data(rootDataObjectList())
                .included(includedList()).build();
        //converting a Pojo to Json.
        return gsonMapper.toJson(gsonRequestPojo);
    }

    List<GsonRequestPojo.Datum> rootDataObjectList() {

        //Creation of Attributes object.
        GsonRequestPojo.Attributes attributesObject = GsonRequestPojo.Attributes.builder()
                .title("JSON:API paints my bikeshed!").body("The shortest article. Ever.")
                .created("2015-05-22T14:56:29.000Z").updated("2015-05-22T14:56:28.000Z").build();
        GsonRequestPojo.Attributes attributesObject2 = GsonRequestPojo.Attributes.builder()
                .title("JSON:something!").body("particles theory")
                .created("2015-05-22T14:56:29.000Z").updated("2015-05-22T14:56:28.000Z").build();

        //Creation of Data object which is a child object of Author object.
        GsonRequestPojo.Datum2 authorDataObject = GsonRequestPojo.Datum2.builder().id("42").type("people")
                .build();

        //Creation of Author Object.
        GsonRequestPojo.Author authorObject = GsonRequestPojo.Author.builder()
                .data(authorDataObject).build();

        //Creation of Relationships object.
        GsonRequestPojo.Relationships relationshipsObject = GsonRequestPojo.Relationships.builder()
                .author(authorObject).build();

        //Creation of List to store root Data objects.
        List<GsonRequestPojo.Datum> rootDataObjectList = new ArrayList<GsonRequestPojo.Datum>();

        //Creation of root Data objects[].
        GsonRequestPojo.Datum rootDataObject1 = GsonRequestPojo.Datum.builder().type("articles")
                .id("1").attributes(attributesObject).relationships(relationshipsObject).build();
        rootDataObjectList.add(rootDataObject1);
        GsonRequestPojo.Datum rootDataObject2 = GsonRequestPojo.Datum.builder().type("particles")
                .id("2").attributes(attributesObject2).build();
        rootDataObjectList.add(rootDataObject2);

        return rootDataObjectList;
    }

    List<GsonRequestPojo.Included> includedList() {

        //Creation of Attributes object which is a child object of Included object.
        GsonRequestPojo.Attributes1 includedAttributes = GsonRequestPojo.Attributes1.builder()
                .name("John").age(80).gender("male").build();

        //Creation of List to store Included objects.
        List<GsonRequestPojo.Included> includedList = new ArrayList<GsonRequestPojo.Included>();

        //Creation of Included objects[].
        GsonRequestPojo.Included includedObject1 = GsonRequestPojo.Included.builder().type("people")
                .id("42").attributes(includedAttributes).build();
        includedList.add(includedObject1);
        GsonRequestPojo.Included includedObject2 = GsonRequestPojo.Included.builder().type("strangers")
                .id("52").build();
        includedList.add(includedObject2);

        return includedList;
    }

    public String getGsonRequestPayloadViaFileRead() throws Exception {

        // BufferedReader is used to read and store the Json file content.
        BufferedReader reader =
                new BufferedReader(new FileReader("src/test/resources/json/SampleRequestFile.json"));
        // StringBuilder is used to transfer the content of BufferedReader.
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        GsonResponsePojo gsonRequestPojoObject = gsonMapper.fromJson(
                json.toString(), GsonResponsePojo.class);
        return gsonMapper.toJson(gsonRequestPojoObject);
    }

    public String getGsonPayloadAsXmlString() throws Exception {
        //Creation of final Request Payload object.
        GsonRequestPojo gsonRequestPojo = GsonRequestPojo.builder().data(rootDataObjectList())
                .included(includedList()).build();
        String json = gsonMapper.toJson(gsonRequestPojo);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        //converting a pojo to xml.
        return xmlMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(gsonMapper.fromJson(json, GsonRequestPojo.class));
    }
}
