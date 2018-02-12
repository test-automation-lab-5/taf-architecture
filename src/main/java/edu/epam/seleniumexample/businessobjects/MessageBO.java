package edu.epam.seleniumexample.businessobjects;

import edu.epam.seleniumexample.pages.LettersPage;

import java.util.List;

public class MessageBO {
    private LettersPage lettersPage;

    public MessageBO() {

        this.lettersPage = new LettersPage();
    }

    public void markInboxLetters(Integer quantity) {
        lettersPage.markInboxLettersAsImportant(quantity);
    }

    public List<String> getInboxTitles() {
        return lettersPage.getInboxTitles();
    }

    public List<String> getInboxMarkedTitles() {
        return lettersPage.getInboxMarkedTitles();
    }

    public List<String> findImportandTitles() {
        return lettersPage.getImportantLetterTitles();
    }

    public void clickImportantLink() {
        lettersPage.clickImportantLink();
    }

    public void clickInboxLink() {
        lettersPage.clickInboxLink();
    }

    public List<String> findInboxTitles() {
        return lettersPage.getInboxTitles();
    }

    public void checkImportantBoxLetters() {
        lettersPage.clickCheckBoxes();
    }

    public void deleteCheckedLetters() {
        lettersPage.clickDeleteButton();
    }

    public void openTrash(){
        lettersPage.clickTrashLink();
    }

    public void selectAll(){
        lettersPage.clickSelectButton();
        lettersPage.selectAllLetters();
    }

    public void moveSelectedLettersToInbox(){
        lettersPage.clickMoveToButton();
        lettersPage.selectInboxDestination();
    }

}
