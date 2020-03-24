package ru.job4j.tracker;


public class StartUI {

    public static boolean start() {
        return true;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = StartUI.start();
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu: ");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input validate = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAction(),
                new EditAction(),
                new DeleteAction(),
                new FindByIDAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(validate, tracker, actions);
    }
}
