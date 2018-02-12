import org.testng.annotations.DataProvider;
import testdata.DataObject;
import testdata.JAXBHendler;
import testdata.LetterDataUnMarshaller;
import testdata.xmlmodels.LetterData;
import testdata.xmlmodels.User;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.List;

public class GmailTest {

    @DataProvider(parallel = true)
    public Object[][] getData() {

        return DataObject.getDataObject();

    }

}
