package EnrolmentSystem;

public abstract class MenuOption {
    private String option;
    private String menuLine;

    // constructor
    public MenuOption(String option, String menuLine) {
        this.option = option;
        this.menuLine = menuLine;
    }
    public String toString(){
        return this.option + ") " + this.menuLine;
    }

    public String getOption(){
        return option;
    }
    public abstract void doAction();
}
