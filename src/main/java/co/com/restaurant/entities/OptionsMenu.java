package co.com.restaurant.entities;

public class OptionsMenu {
    private String optionsMenuId;
    private String text;

    public OptionsMenu() {
    }

    public OptionsMenu(String optionsMenuId, String text) {
        this.optionsMenuId = optionsMenuId;
        this.text = text;
    }

    public String getOptionsMenuId() {
        return optionsMenuId;
    }

    public void setOptionsMenuId(String optionsMenuId) {
        this.optionsMenuId = optionsMenuId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "OptionsMenu = {" + '\n' +
                "optionsMenuId = " + optionsMenuId + '\n' +
                ", text = " + text +  '\n' +
                '}';
    }
}
