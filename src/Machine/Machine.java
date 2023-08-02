package Machine;

import Inputs.State;
import Inputs.Symbol;
import Inputs.Tape;
import Inputs.TransitionSet;
import Inputs.Alphabet;
import Inputs.Stack;
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

    public void startSim() {
        
        ArrayList<StateStackItem> currentBranches;

        while (stateStacks.isEmpty() == false || (stack0.isEmpty() && stack0.isEmpty())) {
            tape.increment();
            stack0 = stateStacks.getStack().stack0;
            stack1 = stateStacks.getStack().stack1;
            currentBranches = branchCurrentState(stateStacks.getStack().state, tape);
            for (StateStackItem stateStackItem : currentBranches) {
                stateStacks.addStack(stateStackItem);
            }
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
}
