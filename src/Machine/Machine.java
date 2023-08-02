package Machine;

import Inputs.*;

import java.util.ArrayList;

//Class for creating a 2-STACK PDA machine
public class Machine {
    //Attributes that contain the formal definition of the machine
    private Tape tape = new Tape();
    private Stack stack0 = new Stack();
    private Stack stack1 = new Stack();

    private Alphabet stackAlphabet;
    private StateStacks stateStacks = new StateStacks();

    private ArrayList<State> stateSet = new ArrayList<>(); //list of all states that contain their transitions


    //Attributes for simulation
    private int currentTape = 0;

    private boolean isAccepted = false;

    //Constructor
    public Machine(Alphabet stackAlphabet, Tape tape, ArrayList<State> stateSet, State startState){
        this.tape = tape;
        this.stateSet = stateSet;
        this.stackAlphabet = stackAlphabet;
        stateStacks.addStack(startState, new Stack(stack0), new Stack(stack1), -1);
    }

    public Stack getStack0() {
        return stack0;
    }

    public Stack getStack1() {
        return stack1;
    }

    public void stepSim() {
        ArrayList<StateStackItem> currentBranches;

        tape.increment();
        stack0 = stateStacks.getStack().stack0;
        stack1 = stateStacks.getStack().stack1;
        currentBranches = branchCurrentState(stateStacks.getStack().state, tape);
        for (StateStackItem stateStackItem : currentBranches) {
            stateStacks.addStack(stateStackItem);
        }
        if (tape.getCurrentIndex() == tape.getSymbols().size()-1) {
            if (stateStacks.getStack().state.isFinal()) {
                isAccepted = true;
            }
        }
        if ((stack0.isEmpty() && stack1.isEmpty())) {
            isAccepted = true;
        }
    }

    private ArrayList<StateStackItem> branchCurrentState(State state, Tape tape) {
        ArrayList<StateStackItem> returnStates = new ArrayList<StateStackItem>();
        
        returnStates = state.getTransitions().getValidTransitions(state, tape.getCurrentSymbol(), tape.getCurrentIndex(), stack0, stack1);

        return returnStates; 
    }

    public String toString() {
        return "PDA DEFINITION:\n"
                + tape.toString()
                + "\n"
                + stack0.toString()
                + "\n"
                + stack1.toString()
                + "\n"
                + stackAlphabet.toString()
                + "\n"
                + stateSet.toString();
    }

    public Tape getTape() {
        return tape;
    }

    public String getIsAccepted() {
        if(isAccepted) {
            return "Accepted";
        } else {
            return "Rejected";
        }
    }

    public Stack getStack(int stack) {
        if(stack == 0) {
            return stack0;
        } else {
            return stack1;
        }
    }

    public ArrayList<Transition> getTransitions() {
        ArrayList<Transition> transitions = new ArrayList<>();
        for(State state : stateSet) {
            transitions.addAll(state.getTransitionSet().getTransitions());
        }
        return transitions;
    }


}
