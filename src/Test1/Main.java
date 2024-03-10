package Test1;

import java.util.Scanner;

public class Main {
    public static User[] getUsers() {
        User user1 = new User("John", "jhon@gmail.com", "pass", 24);
        User user2 = new User("Aynura","aynurthebest@gmail.com","123",13);
        return new User[]{user1, user2};
    }
    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }
    public static void validateUser(User user) throws AccessDeniedException{
        if ( user.getAge() < 18){
            throw new  AccessDeniedException( "Вход запрещен");
        } else {
            System.out.println( "Вход разрешен");
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин :");
        String login = scanner.nextLine();
        System.out.println("Введите пароль :");
        String password = scanner.nextLine();

        try {
            User user = getUserByLoginAndPassword(login, password);
            validateUser(user);
            System.out.println("Доступ предоставлен");
        } catch (UserNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (AccessDeniedException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
