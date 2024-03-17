package nz.co.ruben.project.gsonbuildviajsonfile.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nz.co.ruben.project.gson.pojo.GsonResponsePojo;
import nz.co.ruben.project.gsonbuildviajsonfile.pojo.GsonRequestPojo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods for building the Json/Xml objects as string using Gson library methods.
 */
public class GsonService {

    //Object used for serialization and deserialization of Pojo/Json.
    Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();

    /**
     * This method returns the request payload as a java object.
     * This is achieved by reading a sample json file with appropriate values and unique values in the json file
     * are overridden.
     * @return - the request payload as a java object.
     */
    public GsonRequestPojo getRequestPayloadViaJsonFile() {
        InputStream inputStream = GsonService.class
                .getResourceAsStream("/json/SampleRequestFile.json");
        Reader reader = new InputStreamReader(inputStream);
        GsonRequestPojo rootObj = gsonMapper.fromJson(reader, GsonRequestPojo.class);
        return buildGsonRequestPayload(rootObj);
    }

    /**
     * This method overrides unique values by traversing through the java object.
     * @param rootObj - java object with default values coming from the json file.
     * @return - java object after overriding default values with unique values.
     */
    public GsonRequestPojo buildGsonRequestPayload(GsonRequestPojo rootObj) {
        rootObj.data.get(0).id = "222";
        rootObj.data.get(1).id = "333";
        return rootObj;
    }
}
