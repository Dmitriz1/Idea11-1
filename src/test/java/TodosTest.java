import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {
    @Test
    public void shouldFindThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected1 = {simpleTask};
        Task[] actual1 = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected1, actual1);

        Task[] expected2 = {epic};
        Task[] actual2 = todos.search("Яйца");
        Assertions.assertArrayEquals(expected2, actual2);

        Task[] expected3 = {meeting};
        Task[] actual3 = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected3, actual3);
    }

    @Test
    public void shouldFindNoTasksIfNoMatch() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);

        Task[] actual = todos.search("Нет задачи");
        Task[] expected = {}; // Ожидаем пустой массив
        Assertions.assertArrayEquals(expected, actual);
    }
}