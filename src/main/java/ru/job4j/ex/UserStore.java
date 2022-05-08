package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User us = null;
        for (int i = 0; i < users.length; i++) {
            if (login.equals(users[i].getUsername())) {
                us = users[i];
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
            if (findUser(users, "Petr") != null) {
            validate(user);
            }
        } catch (UserInvalidException ui) {
            ui.printStackTrace();
        } catch (UserNotFoundException un) {
            un.printStackTrace();
        }
    }
}
