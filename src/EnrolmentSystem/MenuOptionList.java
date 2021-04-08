package EnrolmentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOptionList {
    private static final String OPTION_EXIT = "6";
    private List<MenuOption> menuOptions = new ArrayList<>();
    public MenuOptionList(){}

    public void add(MenuOption m){
        this.menuOptions.add(m);
    }
    public void loopUntilExit(){
        String input;
        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println(this);
                input = sc.nextLine();
                if (input.equals(OPTION_EXIT)) {
                    return;
                }
                boolean foundOption = false;
                for (MenuOption m : menuOptions) {
                    if (m.getOption().equalsIgnoreCase(input)) {
                        m.doAction();
                        foundOption = true;
                    }
                }
                if (!foundOption) {
                    System.out.println("Sorry, unrecognised option");
                }
            }
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(MenuOption m:menuOptions){
            sb.append(m).append("\n");
        }
        sb.append("Please enter your option: ");
        return sb.toString();
    }
}
