package testdata;

import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.LettersData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class LetterDataUnMarshaller {
    public static List<LetterData> unmarsallerLetterDatas(File lettersDataFile) {
        LettersData lettersData = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(LettersData.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Unmarshaller um = null;
        try {
            um = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            lettersData = (LettersData) um.unmarshal(lettersDataFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return lettersData.getLettersData();
    }
}
