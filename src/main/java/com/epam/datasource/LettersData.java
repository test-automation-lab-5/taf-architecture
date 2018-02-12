package com.epam.datasource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "letters")
@XmlAccessorType(XmlAccessType.FIELD)
public class LettersData {
    @XmlElement(name = "letter", type = LetterData.class)
    private List<LetterData> lettersData = null;

    public LettersData(){};

    public LettersData(List<LetterData> lettersData) {
        this.lettersData = lettersData;
    }

    public List<LetterData> getLettersData() {
        return lettersData;
    }

    public void setLettersData(List<LetterData> lettersData) {
        this.lettersData = lettersData;
    }
}
