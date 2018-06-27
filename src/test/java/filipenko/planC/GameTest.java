package filipenko.planC;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game = new Game();

    @BeforeEach
    public void gen(){
        game = new Game();
    }

    @Test
    public void move() {
        assertTrue(game.move(3,5,4,4));
        assertEquals(0, game.getDeck().get(3,5));
        assertEquals(1, game.getDeck().get(4,4));

        assertTrue(game.move(2,2,3,3));
        assertEquals(0, game.getDeck().get(2,2));
        assertEquals(-1, game.getDeck().get(3,3));

        assertTrue(game.move(4,4,2,2));
        assertEquals(0, game.getDeck().get(4,4));
        assertEquals(0, game.getDeck().get(3,3));
        assertEquals(1, game.getDeck().get(2,2));
        game.finishMove();

        assertTrue(game.move(3,1,1,3));
        assertEquals(0, game.getDeck().get(3,1));
        game.finishMove();

        assertTrue(game.move(1,5,0,4));
        game.finishMove();
        game.debugMove(0,0, 3,3);
        LinkedHashMap<Integer,Integer> moves = new LinkedHashMap<>();
        moves.put(2,2); moves.put(4,4);
        assertTrue(game.move(0,4,moves));
        assertEquals(1, game.getDeck().get(4,4));
        assertEquals(0, game.getDeck().get(3,3));
        assertEquals(0, game.getDeck().get(2,2));


        game.debugDelete(6,0);
        game.debugMove(3,7, 7,1);
        game.finishMove();

        assertTrue(game.move(7, 1, 6, 0));
        assertEquals(0, game.getDeck().get(7,1));
        assertEquals(2, game.getDeck().get(6,0));
        game.finishMove();

        assertTrue(game.move(6, 0, 3, 3));
        assertEquals(0, game.getDeck().get(5,1));
        assertEquals(0, game.getDeck().get(4,2));
        assertEquals(2, game.getDeck().get(3,3));
    }
}