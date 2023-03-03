package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void testWhenFirstPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Tom", "Bill");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerIsStronger() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 60);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Tom", "Bill");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenPlayersForcesAreEquals() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 50);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Tom", "Bill");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenThirstPlayerNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("John", "Bill")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Tom", "John")
        );
    }

    @Test
    public void testWhenBothPlayersNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Tom", 50);
        Player player2 = new Player(2, "Bill", 40);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Henry", "John")
        );
    }
}