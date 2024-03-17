package nz.co.ruben.project.gsonbuildviajsonfile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nz.co.ruben.project.gsonbuildviajsonfile.pojo.GsonRequestPojo;
import nz.co.ruben.project.gsonbuildviajsonfile.service.GsonService;
import org.testng.annotations.Test;

/**
 * This class validates that a request payload can be successfully built by reading a json file
 * with default values and then overriding unique values as needed.
 */
public class GsonBuildViaJsonFileTests {

    GsonService service = new GsonService();
    Gson gsonMapper = new GsonBuilder().setPrettyPrinting().create();

    @Test(description = "Verify that JSON payload is built accurately by using the combination" +
            "of Gson and json file.")
    private void verifyThatJsonStringIsBuiltAccuratelyUsingGsonAndJsonFile() throws Exception {

        GsonRequestPojo payloadViaJsonFile = service.getRequestPayloadViaJsonFile()
                .setFirstTitle("First Title 1")
                .setSecondTitle("Second Title 2")
                .setFirstIncludedType("zombies")
                .setSecondIncludedType("vampires");
        System.out.println(gsonMapper.toJson(payloadViaJsonFile));
    }
}
