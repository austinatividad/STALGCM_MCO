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
    private Stack stack_0 = new Stack();
    private Stack stack_1 = new Stack();

    private Alphabet stackAlphabet;

    private ArrayList<State> stateSet = new ArrayList<>(); //list of all states that contain their transitions


    //Attributes for simulation
    private int currentTape = 0;

    private boolean isAccepted = false;

    //Constructor
    public Machine(Alphabet stackAlphabet, Tape tape, ArrayList<State> stateSet){
        this.tape = tape;
        this.stateSet = stateSet;
        this.stackAlphabet = stackAlphabet;
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

    public String toString(){
        return "PDA DEFINITION:\n"
                + tape.toString()
                + "\n"
                + stack_0.toString()
                + "\n"
                + stack_1.toString()
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
