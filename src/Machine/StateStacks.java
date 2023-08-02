package Machine;

import java.util.ArrayList;

import Inputs.Stack;
import Inputs.State;

public class StateStacks {
    
    private ArrayList<StateStackItem> stateStack = new ArrayList<StateStackItem>();

    public StateStacks() {}

    public Boolean isEmpty() {
        return stateStack.isEmpty();
    }

    public void addStack(State state, Stack stack0, Stack stack1, int inputIndex) {
        stateStack.add(new StateStackItem(state, stack0, stack1, inputIndex));
    }

    public void addStack(StateStackItem stateStackItem) {
        stateStack.add(stateStackItem);
    }

    public StateStackItem getStack() {
        return stateStack.get(stateStack.size() - 1);
    }

    public void removeStack() {
        stateStack.remove(stateStack.size() - 1);
    }
}


