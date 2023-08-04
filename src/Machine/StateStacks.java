package Machine;

import java.util.ArrayList;

import Inputs.Stack;
import Inputs.State;

public class StateStacks {
    
    private ArrayList<StateStackItem> stateStack = new ArrayList<>();

    public StateStacks() {}

    public Boolean isEmpty() {
        return stateStack.isEmpty();
    }

    public void addStack(State state, Stack stack0, Stack stack1, int inputIndex) {
        stateStack.add(new StateStackItem(state, stack0, stack1, inputIndex));
        //printStackSeq(stateStack.size()-1);
    }

    public void addStack(StateStackItem stateStackItem) {
        stateStack.add(stateStackItem);
        //printStackSeq(stateStack.size()-1);
    }

    private void printStackSeq(int x) {
        System.out.println("Stack State: " + stateStack.get(x).state.getSymbol().getValue());

        System.out.print("Stack 1: ");

        for (int i = 0; i < stateStack.get(x).stack0.getStack().size(); i++) {
            System.out.print(stateStack.get(x).stack0.getStack().get(i).getValue() + " ");
        }

        System.out.print("\nStack 2: ");
        
        for (int i = 0; i < stateStack.get(x).stack1.getStack().size(); i++) {
            System.out.print(stateStack.get(x).stack1.getStack().get(i).getValue() + " ");
        }

        System.out.println("\nRead Index: " + stateStack.get(x).inputIndex + "\n");
    }

    public int getStackSize() {
        return stateStack.size();
    }

    public void printStateStacks() {
        for (int i = 0; i < stateStack.size(); i++) {
            printStackSeq(i);
        }
    }

    public StateStackItem getStack() {
        return stateStack.get(stateStack.size() - 1);
    }

    public void removeStack() {
        stateStack.remove(stateStack.size() - 1);
    }

}


