import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TodosTest {
    @Test
    public void shouldFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected1 = {simpleTask};
        Task[] actual1 = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected1, actual1);
    }

    @Test
    public void shouldFindEpicTask() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        Task[] expected2 = {epic};
        Task[] actual2 = todos.search("Яйца");
        Assertions.assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldFindMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        Task[] expected3 = {meeting};
        Task[] actual3 = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected3, actual3);
    }
    @Test
    public void shouldFindNoTasksIfNoMatch() {
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

        Task[] expected1 = {};
        Task[] actual1 = todos.search("Принять звонок");
        Assertions.assertArrayEquals(expected1, actual1);

        Task[] expected2 = {};
        Task[] actual2 = todos.search("Птица");
        Assertions.assertArrayEquals(expected2, actual2);

        Task[] expected3 = {};
        Task[] actual3 = todos.search("Скаммер");
        Assertions.assertArrayEquals(expected3, actual3);
    }

    @Test
    public void shouldFindAllTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected1 = {epic};
        Task[] actual1 = todos.search("Яйца");
        Assertions.assertArrayEquals(expected1, actual1);

        Task[] expected2 = {meeting};
        Task[] actual2 = todos.search("Приложение НетоБанка");
        Assertions.assertArrayEquals(expected2, actual2);
    }

    @Test
    public void shouldFindSeveralTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Позвонить в НетоБанк",
                "Во вторник после обеда"
        );

        todos.add(simpleTask);
        todos.add(meeting);

        Task[] expected1 = {simpleTask, meeting};
        Task[] actual1 = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected1, actual1);
    }
}