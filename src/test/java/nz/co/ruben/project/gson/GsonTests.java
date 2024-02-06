package nz.co.ruben.project.gson;

import nz.co.ruben.project.gson.service.GsonService;
import org.testng.annotations.Test;

public class GsonTests {

    GsonService service = new GsonService();

    @Test(description = "Verify that JSON string is built accurately by using the combination" +
            "of Gson and Lombok library.")
    private void verifyThatJsonStringIsBuiltAccuratelyUsingGsonAndLombok() throws Exception {

        String payloadViaBuilder = service.getGsonRequestPayload();
        System.out.println(payloadViaBuilder);

        String payloadViaFileRead = service.getGsonRequestPayloadViaFileRead();
        System.out.println(payloadViaFileRead);

        String xmlPayload = service.getGsonPayloadAsXmlString();
        System.out.println(xmlPayload);
    }
}
