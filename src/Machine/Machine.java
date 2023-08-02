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
    private Alphabet alphabet = new Alphabet();
    private Stack stack_0 = new Stack();
    private Stack stack_1 = new Stack();
    private State startState;

    private ArrayList<State> stateSet = new ArrayList<>(); //list of all states that contain their transitions


    //Attributes for simulation
    private int currentTape = 0;
    private ArrayList<State> currenState;

    //Constructor
    public Machine(Tape tape, Alphabet alphabet, ArrayList<State> stateSet, State startState){
        this.tape = tape;
        this.alphabet = alphabet;
        this.stateSet = stateSet;
        this.startState = startState;
    }

    public Stack getStack0() {
        return stack_0;
    }

    public Stack getStack1() {
        return stack_1;
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



}
