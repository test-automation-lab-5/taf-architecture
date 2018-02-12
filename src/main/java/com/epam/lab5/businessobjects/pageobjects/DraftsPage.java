package com.epam.lab5.businessobjects.pageobjects;

import com.epam.lab5.decorator.elements.Button;
import com.epam.lab5.decorator.elements.PageElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.epam.lab5.consts.Numbers.ELEMENT_BE_VISIBLE_WAIT_VALUE;

public class DraftsPage extends AbstractPage {

    private static final Logger log = Logger.getLogger(DraftsPage.class);

    @FindBy(css = ".TN.GLujEb.aHS-bnq .aio.UKr6le span a")
    private Button draftsButton;

    @FindBy(css=".vh")
    private PageElement mailWasSentWindow;

    private Button draftMailWithSubject;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public void openDraftsPage(){
        waitElementBeVisible(draftsButton,ELEMENT_BE_VISIBLE_WAIT_VALUE);
        draftsButton.click();
        log.info("'Drafts' page was opened.");
    }

    public void clickDraftMailWithSubject(String mailSubject){
        getDraftMailWithSubject(mailSubject).click();
        log.info("Mail from Draft was opened.");
    }

    public PageElement getDraftMailWithSubject(String mailSubject){
        draftMailWithSubject=new Button(
                driver.findElement(By.xpath(String.format("//span[@class='bog'][text()='%s']",mailSubject))));
        return draftMailWithSubject;
    }

    public boolean isMailWasSentWindowDisplayed(){
      waitElementBeVisible(mailWasSentWindow,ELEMENT_BE_VISIBLE_WAIT_VALUE);
        return mailWasSentWindow.isDisplayed();
    }

}
