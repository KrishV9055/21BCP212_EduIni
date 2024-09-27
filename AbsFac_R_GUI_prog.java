package DP;

interface GUIFactory{
    Button createButton();
    CheckBox createCheckBox();
}

class WinFactory implements GUIFactory{
    public Button createButton() {
        return new WinButton();
    }
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}

class MacFactory implements GUIFactory{
    public Button createButton() {
        return new MacButton();
    }
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}

interface Button{
    void Paint();
}

class WinButton implements Button{
    public void Paint() {
        System.out.println("Button created for Windows");
    }
}

class MacButton implements Button{
    public void Paint() {
        System.out.println("Button created for MAC");
    }
}

interface CheckBox{
    void Paint();
}

class WinCheckBox implements CheckBox{
    public void Paint() {
        System.out.println("Checkbox created for Windows");
    }
}

class MacCheckBox implements CheckBox{
    public void Paint() {
        System.out.println("Checkbox created for MAC");
    }
}

class Application{
    Button button;
    CheckBox checkBox;
    GUIFactory guiFactory;

    public Application(GUIFactory guiFactory){
        this.guiFactory = guiFactory;
    }

    public void createUI(){
        this.button = guiFactory.createButton();
        this.checkBox = guiFactory.createCheckBox();
    }

    public void paint(){
        this.button.Paint();
        this.checkBox.Paint();
    }
}

public class AbsFac_R_GUI_prog{
    public static void main(String[] args) {
        String OS = "Mac";
        GUIFactory guiFactory;
        if("mac".equalsIgnoreCase(OS)){
            guiFactory = new MacFactory();
        }else{
            guiFactory = new WinFactory();
        }

        Application app = new Application(guiFactory);
        app.createUI();
        app.paint();

    }
}