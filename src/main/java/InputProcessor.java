import person.Person;

public class InputProcessor {

    public final String processInput(final String input) {
        return input.trim().matches("\\d{4}") ? new Person().build(input) : "Неверный ввод.";
    }
}