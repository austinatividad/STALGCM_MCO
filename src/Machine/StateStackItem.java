package Machine;

import java.util.ArrayList;

import Inputs.Stack;
import Inputs.State;
import Inputs.Symbol;
import Inputs.Transition;

public class StateStackItem {
    public State state;
    public Transition transition;
    public ArrayList<Symbol> pastTransitions;
    public Stack stack0;
    public Stack stack1;
    public int inputIndex;

    public StateStackItem(State state, Transition transition, ArrayList<Symbol> pastTransitions, Stack stack0, Stack stack1, int inputIndex) {
        this.state = state;
        this.transition = transition;
        this.pastTransitions = (ArrayList<Symbol>)pastTransitions.clone();
        this.stack0 = stack0;
        this.stack1 = stack1;
        this.inputIndex = inputIndex;
    }

}