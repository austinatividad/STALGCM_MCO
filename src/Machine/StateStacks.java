package Machine;

import java.util.ArrayList;

import Inputs.Stack;
import Inputs.State;

public class StateStacks {
    
    private ArrayList<stateStackItem> stateStack = new ArrayList<stateStackItem>();

    public StateStacks() {

    }

    public void addStack(State state, Stack stack0, Stack stack1, int inputIndex) {
        new stateStackItem(state, stack0, stack1, inputIndex);
    }

    public stateStackItem getStack() {
        return stateStack.get(stateStack.size() - 1);
    }

    public void removeStack() {
        stateStack.remove(stateStack.size() - 1);
    }
}

class stateStackItem {
    public State state;
    public Stack stack0;
    public Stack stack1;
    public int inputIndex;

    public stateStackItem(State state, Stack stack0, Stack stack1, int inputIndex) {
        this.state = state;
        this.stack0 = stack0;
        this.stack1 = stack1;
        this.inputIndex = inputIndex;
    }
}
