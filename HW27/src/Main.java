import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    private static final String CORRECT_CREDENTIALS = "[\\w_]+";

    public static void main(String[] args) {
        //todo Тут протестить работу метода
        try {
            System.out.println(checkPasswd("vladb20", "password1", "password"));
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    //todo тут создать метод confirmPassword()

    public static boolean checkPasswd(String login,
                                      String password,
                                      String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (checkCorrection(login)) {
            throw new WrongLoginException("Неправильный логин");
        }
        if (checkCorrection(password)) {
            throw new WrongPasswordException("Неправильный пароль");
        }
        return password.equals(confirmPassword);
    }

    public static boolean checkCorrection(String correction) {
        return !correction.matches(CORRECT_CREDENTIALS) || correction.length() > 20;
    }
}