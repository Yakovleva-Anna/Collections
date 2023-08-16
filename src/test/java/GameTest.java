import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class GameTest {

    @Test
    public void testWhenPlayer1Wins() {
        Player first = new Player(1, "First", 12);
        Player second = new Player(2, "Second", 10);
        Game game = new Game();
        game.register(first);
        game.register(second);

        int actual = game.round("First", "Second");
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenPlayer2Wins() {
        Player first = new Player(1, "First", 10);
        Player second = new Player(2, "Second", 12);
        Game game = new Game();
        game.register(first);
        game.register(second);

        int actual = game.round("First", "Second");
        int expected = 2;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenPlayersAreEqual() {
        Player first = new Player(1, "First", 10);
        Player second = new Player(2, "Second", 10);
        Game game = new Game();
        game.register(first);
        game.register(second);

        int actual = game.round("First", "Second");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhen1PlayerNotExist() {
        Player first = new Player(1, "First", 14);
        Player second = new Player(2, "Second", 10);
        Game game = new Game();
        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Third", "Second"));

    }

    @Test
    public void testWhen2PlayerNotExist() {
        Player first = new Player(1, "First", 10);
        Player second = new Player(2, "Second", 14);
        Game game = new Game();
        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("First", "Fourth"));

    }

    @Test
    public void testWhenBothPlayerNotExist() {
        Player first = new Player(1, "First", 14);
        Player second = new Player(2, "Second", 14);
        Game game = new Game();
        game.register(first);
        game.register(second);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Third", "Fourth"));

    }
}