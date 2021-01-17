package seawar;

public enum ConsoleErrors {
    EMPTY_STRING("Ошибка: Введена пустая строка."),
    NON_DIGITS("Ошибка: В координатах присутствуют посторонние символы."),
    ON_HALO_SHIP("Ошибка: Корабль задевает чужой ореал или сам корабль."),
    WRONG_SHIP("Ошибка: Неправильный (невалидный) корабль.")
    ;

    private String message;

    ConsoleErrors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
