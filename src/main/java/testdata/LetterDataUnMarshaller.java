package testdata;

import testdata.xmlmodels.LetterData;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class LetterDataUnMarshaller {
    public static LetterData unmarsaller() {
        try {

            File file = new File("src\\\\main\\\\resources\\\\letterData.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(LetterData.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            LetterData letterData = (LetterData) jaxbUnmarshaller.unmarshal(file);
            return letterData;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
