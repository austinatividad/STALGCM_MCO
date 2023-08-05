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

        Symbol l = new Symbol("L");
        for (Transition transition : transitions) {
            newStack0 = new Stack(stack0);
            newStack1 = new Stack(stack1);

            if (transition.validTransition(l, newStack0, newStack1)) {
                stackItems.add(new StateStackItem(transition.nextState, transition, newStack0, newStack1, inputIndex - 1));
                System.out.println("Added lambda Transition");
            }
        }

        for (Transition transition : transitions) {
            newStack0 = new Stack(stack0);
            newStack1 = new Stack(stack1);

            if (transition.validTransition(symbol, newStack0, newStack1)) {
                stackItems.add(new StateStackItem(transition.nextState, transition, newStack0, newStack1, inputIndex));
                System.out.println("Added " + transition.nextState.getSymbol().getValue() + " Transition");
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

    public ArrayList<Transition> getTransitions(){
        return transitions;
    }

}
