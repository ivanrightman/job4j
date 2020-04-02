package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class StartUI {

    public static boolean start() {
        return true;
    }

    //was: public void init(Input input, Tracker tracker, UserAction[] actions) {
    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = StartUI.start();
        while (run) {
            this.showMenu(actions);
            //was: int select = input.askInt("Select: ", actions.length);
            int select = input.askInt("Select: ", actions.size());
            // was: UserAction action = actions[select];
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    //was: private void showMenu(UserAction[] actions) {
    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu: ");
        /*was: for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }*/
        for (UserAction el : actions) {
            System.out.println(el + ". " + el.name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        /*was: UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new EditAction(),
                new DeleteAction(),
                new FindByIDAction(),
                new FindByNameAction(),
                new ExitAction()
        };*/
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction());
                actions.add(new ShowAction());
                actions.add(new EditAction());
                actions.add(new DeleteAction());
                actions.add(new FindByIDAction());
                actions.add(new FindByNameAction());
                actions.add(new ExitAction());
        new StartUI().init(validate, tracker, actions);
    }
}
