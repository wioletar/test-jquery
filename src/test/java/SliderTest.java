import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest{

//    Open https://jqueryui.com/slider/#custom-handle
//    Move slider to value 80
//    Move slider to value 50
//    Move slider to value 55
//    Move slider to again to value 55
//   1. Each step should check position with assertion
//2. Moving slider should be done with one method that will work for each value between slider range (0-100)
// and it should move it to selected number, wherever the slider is actually.


    @Test
    public void testSlider() {
        driver.get("https://jqueryui.com/slider/#custom-handle");

        WebElement frame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
       //co robi switchTo()?
        driver.switchTo().frame(frame);
        WebElement slider = driver.findElement(By.id("custom-handle"));
        move(80, slider);
        move(50, slider);
        move(55, slider);
        move(55, slider);
    }

    private void move(int position, WebElement slider) {
        slider.click();
        // parseInt -> analizuje Stringa do Ina
        if (Integer.parseInt(slider.getText())<position)
            while (Integer.parseInt(slider.getText())!=position){
                slider.sendKeys(Keys.ARROW_RIGHT);
            }
        else
            while (Integer.parseInt(slider.getText())!=position){
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        Assert.assertEquals(Integer.parseInt(slider.getText()),position);
    }


}
