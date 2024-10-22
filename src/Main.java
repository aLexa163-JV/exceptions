public class Main {

    public static void main(String[] args)  {

        try {
            validateCredentials("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
            System.out.println("Данные корректны");
        } catch (WrongLoginException i) {
            System.out.println("Ошибка: " + i.getMessage());
        } catch (WrongPasswordException i){
            System.out.println("Ошибка: " + i.getMessage());
        } finally {
            System.out.println("Работа метода завершена");
        }

    }

    private static void validateCredentials(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        // Проверка логина
        if (login.length() > 20) {
            throw new WrongLoginException("Логин слишком длинный");
        }
        if (!isValidLogin(login)) {
            throw new WrongLoginException("Логин содержит недопустимые символы");
        }

        // Проверка пароля
        if (password.length() > 20) {
            throw new WrongPasswordException("Пароль слишком длинный");
        }
        if (!isValidPassword(password)) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }

        // Проверка совпадения пароля и подтверждения пароля
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
        }
    }

    //Проверка символов
    private static boolean allowedCharacter(char i) {
        return (i >= 'a' && i <= 'z') ||
                (i >= 'A' && i <= 'Z') ||
                (i >= '0' && i <= '9') ||
                (i == '_');
    }

    //Проверка недопустимых символов логин
    private static boolean isValidLogin(String login) {
        for (int i = 0; i < login.length(); i++) {
            char e = login.charAt(i);
            if (!allowedCharacter(e)) {
                return false;
            }
        }
        return true;
    }

    //Проверка недопустимых символов пароль
    private static boolean isValidPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            char e = password.charAt(i);
            if (!allowedCharacter(e)) {
                return false;
            }
        }
        return true;
    }
}