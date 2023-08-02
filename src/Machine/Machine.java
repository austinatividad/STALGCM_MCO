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

    //Constructor
    public Machine(Alphabet stackAlphabet, Tape tape, ArrayList<State> stateSet, State startState){
        this.tape = tape;
        this.stateSet = stateSet;
        this.stackAlphabet = stackAlphabet;
        stateStacks.addStack(startState, stack1, stack0, 0);
    }

    public Stack getStack0() {
        return stack0;
    }

    public Stack getStack1() {
        return stack1;
    }

    public void startSim() {
        
        

        tape.getSymbol(currentTape);
    }

    private State branchCurrentState() {
        return null;
    }

    private Symbol getCurrentSymbol() {
        return tape.getSymbol(currentTape);
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

}
