package graph.bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.*;

public class WaterJugProblemTest {

    private static class State {
        public final int jug1Quantity, jug2Quantity, step;

        State(int jug1Quantity, int jug2Quantity, int step) {
            this.jug1Quantity = jug1Quantity;
            this.jug2Quantity = jug2Quantity;
            this.step = step;
        }

        @Override
        public int hashCode() {
            return Objects.hash(jug1Quantity, jug2Quantity, step);
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof State)) {
                return false;
            }

            State otherState = (State) other;

            return this.jug1Quantity == otherState.jug1Quantity &&
                    this.jug2Quantity == otherState.jug2Quantity &&
                    this.step == otherState.step;
        }
    }

    public int minSteps(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (Math.max(jug1Capacity, jug2Capacity) < targetCapacity) {
            return -1;
        }

        int transferCapacity;

        // We need to traverse all the possible combinations of jug 1 and 2's capacity
        // hence number of states is equal to jug1Capacity * jug2Capacity
        boolean[][] visited = new boolean[jug1Capacity + 1][jug2Capacity + 1];

        Queue<State> q = new ArrayDeque<>();
        q.add(new State(0, 0, 0));

        while (!q.isEmpty()) {
            // Remove the state and see if we have reached the targetCapacity in any of the jugs,
            // if not, try all the operations on both the jugs
            State state = q.remove();

            if (state.jug1Quantity == targetCapacity || state.jug2Quantity == targetCapacity) {
                return state.step;
            }

            // Fill Jug1
            if (!visited[jug1Capacity][state.jug2Quantity]) {
                visited[jug1Capacity][state.jug2Quantity] = true;
                q.add(new State(jug1Capacity, state.jug2Quantity, state.step + 1));
            }

            // Fill Jug2
            if (!visited[state.jug1Quantity][jug2Capacity]) {
                visited[state.jug1Quantity][jug2Capacity] = true;
                q.add(new State(state.jug1Quantity, jug2Capacity, state.step + 1));
            }

            // Empty Jug1
            if (!visited[0][state.jug2Quantity]) {
                visited[0][state.jug2Quantity] = true;
                q.add(new State(0, state.jug2Quantity, state.step + 1));
            }

            // Empty Jug2
            if (!visited[state.jug1Quantity][0]) {
                visited[state.jug1Quantity][0] = true;
                q.add(new State(state.jug1Quantity, 0, state.step + 1));
            }

            // Pour Jug1 into Jug2
            transferCapacity = Math.min(jug2Capacity - state.jug2Quantity, state.jug1Quantity);
            if (!visited[state.jug1Quantity - transferCapacity][state.jug2Quantity + transferCapacity]) {
                visited[state.jug1Quantity - transferCapacity][state.jug2Quantity + transferCapacity] = true;
                q.add(new State(state.jug1Quantity - transferCapacity, state.jug2Quantity + transferCapacity, state.step + 1));
            }

            // Pour Jug2 into Jug1
            transferCapacity = Math.min(jug1Capacity - state.jug1Quantity, state.jug2Quantity);
            if (!visited[state.jug1Quantity + transferCapacity][state.jug2Quantity - transferCapacity]) {
                visited[state.jug1Quantity + transferCapacity][state.jug2Quantity - transferCapacity] = true;
                q.add(new State(state.jug1Quantity + transferCapacity, state.jug2Quantity - transferCapacity, state.step + 1));
            }

        }

        return -1;
    }

    @Test
    public void basicTest() {
        WaterJugProblemTest test = new WaterJugProblemTest();
        Assertions.assertEquals(4, test.minSteps(4, 3, 2));
    }
}
