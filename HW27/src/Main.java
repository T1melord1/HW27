import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    private static final String CORRECT_CREDENTIALS = "[\\w_]+";

    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        //todo Тут протестить работу метода
        System.out.println("Введите ваш логин: ");
        String login = new Scanner(System.in).nextLine();
        System.out.println("Введите ваш пароль: ");
        String password = new Scanner(System.in).nextLine();
        System.out.println("Введите ваш пароль ещё раз для проверки: ");
        String confirmPassword = new Scanner(System.in).nextLine();
        checkPasswd(login, password, confirmPassword);

    }

    //todo тут создать метод confirmPassword()

    public static void checkPasswd(String login,
                                   String password,
                                   String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (checkCorrection(login)) {
            System.out.println("Ваш логин: " + login);
        } else {
            throw new WrongLoginException("Неправильный логин");
        }
        if (checkCorrection(password) && password.equals(confirmPassword)) {
            System.out.println("Ваш пароль: " + password);
        } else {
            throw new WrongPasswordException("Неправильный пароль");
        }

    }
    public static boolean checkCorrection(String correction){
        return correction.matches(CORRECT_CREDENTIALS) && correction.length() < 20;
    }
}