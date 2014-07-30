import javax.swing.*;

@SuppressWarnings("serial")
public class Slider extends JApplet {

    // Called when this applet is loaded into the browser.
    public void init() {
        SliderDriver driver = new SliderDriver();
        add(driver);
    }
}
