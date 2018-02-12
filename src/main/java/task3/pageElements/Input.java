package task3.pageElements;
import org.openqa.selenium.WebElement;

public class Input extends  PageElements {

    public Input(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        super.sendKeys(charSequences);
    }
}