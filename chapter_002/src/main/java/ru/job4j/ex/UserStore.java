package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                user = users[i];
            } else {
                throw new UserNotFoundException("user with this login not found");
            }
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result;
        if (user.getUsername().length() < 3 || !user.isValid()) {
            throw new UserInvalidException("your user is invalid");
        } else {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
        User[] users = {
                new User("Pe", true)
        };
        User user = findUser(users, "Pe");

            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException en) {
            en.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
