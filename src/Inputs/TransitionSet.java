package Inputs;
import java.util.ArrayList;

import Machine.StateStackItem;

//Stores the set of transitions for a state
public class TransitionSet {
    ArrayList<Transition> transitions = new ArrayList<>();

    public void addTransition(Transition transition){
        transitions.add(transition);
    }

    public Transition getTransition(int index){
        return transitions.get(index);
    }

    public int getTransitionSize() {
        return transitions.size();
    }

    public ArrayList<StateStackItem> getValidTransitions(State currentState, Symbol symbol, int inputIndex, Stack stack0, Stack stack1) {
        ArrayList<StateStackItem> stackItems = new ArrayList<>();
        Stack newStack0;
        Stack newStack1;

        for (Transition transition : transitions) {
            newStack0 = new Stack(stack0);
            newStack1 = new Stack(stack1);

            if (transition.validTransition(symbol, stack0, stack1)) {
                stackItems.add(new StateStackItem(currentState, newStack0, newStack1, inputIndex));
            }
        }
        return stackItems;
    }

    public String toString() {
        String output = "";
        for (Transition transition : transitions) {
            output += transition.toString() + "\n";
        }
        return output;
    }

}
