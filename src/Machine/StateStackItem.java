package Machine;

import Inputs.Stack;
import Inputs.State;

public class StateStackItem {
    public State state;
    public Stack stack0;
    public Stack stack1;
    public int inputIndex;

    public StateStackItem(State state, Stack stack0, Stack stack1, int inputIndex) {
        this.state = state;
        this.stack0 = stack0;
        this.stack1 = stack1;
        this.inputIndex = inputIndex;
    }

}