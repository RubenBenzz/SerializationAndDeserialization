package nz.co.ruben.project.jackson;

import nz.co.ruben.project.jackson.service.JacksonService;
import org.testng.annotations.Test;

public class JacksonTests {

    JacksonService service = new JacksonService();

    @Test (description = "Verify that JSON string is built accurately by using the combination" +
            "of Jackson and Lombok library.")
    private void verifyThatJsonStringIsBuiltAccuratelyUsingJacksonAndLombok() throws Exception {

        String payloadViaBuilder = service.getJacksonRequestPayload();
        System.out.println(payloadViaBuilder);

        String payloadViaFileRead = service.getJacksonRequestPayloadViaFileRead();
        System.out.println(payloadViaFileRead);

        String xmlPayload = service.getJacksonPayloadAsXmlString();
        System.out.println(xmlPayload);

        String xmlPayloadWithoutStringBuilder = service.getJacksonPayloadAsXmlStringWithoutStringBuilder();
        System.out.println(xmlPayloadWithoutStringBuilder);
    }
}
