package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        if (login != users[0].getUsername()) {
            throw new UserNotFoundException("user with this login not found");
        } else {
            users[0].setUsername("pe");
        }
        return users[0];
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("your user is invalid");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("petr", true)
        };

        User[] users2 = {
                new User("чтобы use is invalid", false)
        };

        try {
            User user = findUser(users, "чтобы login not found");
            if (validate(user)) {
                System.out.println("This user has an access");
            }

        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        try {
            User user2 = null;
            try {
                user2 = findUser(users2, "чтобы use is invalid");
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
            validate(user2);
        } catch (UserInvalidException en) {
            en.printStackTrace();
        }
    }
}
