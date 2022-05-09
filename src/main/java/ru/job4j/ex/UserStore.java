package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User us = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                us = user;
                break;
            }
        }
        if (us == null) {
            throw new UserInvalidException("User not found");
        }
        return us;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User has not an access");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr", true)
        };
        User user = new User("Petr", true);
        try {
            if (findUser(users, "Georgy") != null) {
            validate(user);
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}
