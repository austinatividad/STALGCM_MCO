package Machine;

import Inputs.*;

import java.awt.Component;
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
    private StateStackItem currentStack;
    private boolean isAccepted = false;

    private Transition currentTransition;
    private int stepCount = 0;

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

        if (stateStacks.getStack() != null && !isAccepted) {
            stepCount++;
            currentStack = stateStacks.getStack();
            tape.setCurrentIndex(currentStack.inputIndex);
            tape.increment();
            stack0 = currentStack.stack0;
            stack1 = currentStack.stack1;
            stateStacks.removeStack();
            currentBranches = branchCurrentState(currentStack.state, tape);
            for (StateStackItem stateStackItem : currentBranches) {
                stateStacks.addStack(stateStackItem);
            }
            currentStack = stateStacks.getStack();
            stateStacks.printStateStacks();
            if (tape.getCurrentIndex() >= tape.getSymbols().size()) {
                if (currentStack.state.isFinal()) {
                    isAccepted = true;
                }
            }
            //if ((stack0.isEmpty() && stack1.isEmpty())) {
            //    isAccepted = true;
            //}
            System.out.println("State Stacks: " + stateStacks.getStackSize());
        }
    }

    private ArrayList<StateStackItem> branchCurrentState(State state, Tape tape) {
        ArrayList<StateStackItem> returnStates = new ArrayList<StateStackItem>();
        System.out.println("Branching from: " + state.getSymbol().getValue());
        returnStates = state.getTransitions().getValidTransitions(state, tape.getCurrentSymbol(), tape.getCurrentIndex(), stack0, stack1);

        if (returnStates.size() == 0) {
            returnStates.add(new StateStackItem(state, stack0, stack1, 0));
        }

        System.out.println("");

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

    public int getStepCount() {
        return stepCount;
    }

    public String getCurrentState() {
        String result = "";
        if(currentStack.state.isInitial()){
            result += "Initial State: ";
        } else if(currentStack.state.isFinal()){
            result += "Final State: ";
        } else {
            result += "Current State: ";
        }
        return result + currentStack.state.getSymbol().getValue();
    }

    public ArrayList<String> getStateStackTransitions() {
        //get top of Statestack
        String result = "";
        StateStackItem temp = stateStacks.getStack();

        ArrayList<String> transitions = new ArrayList<>();
        for(Transition transition : temp.state.getTransitionSet().getTransitions()) {
            transitions.add(transition.toString());
        }
        return transitions;
    }
}
