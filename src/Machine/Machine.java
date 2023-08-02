package Machine;

import Inputs.State;
import Inputs.Tape;
import Inputs.Alphabet;
import Inputs.Stack;
import java.util.ArrayList;

//Class for creating a 2-STACK PDA machine
public class Machine {
    //Attributes that contain the formal definition of the machine
    private Tape tape = new Tape();
    private Alphabet stackAlphabet = new Alphabet();
    private Stack stack_0 = new Stack();
    private Stack stack_1 = new Stack();

    private ArrayList<State> stateSet = new ArrayList<>(); //list of all states that contain their transitions

    //Constructor
    public Machine(Tape tape, Alphabet alphabet, ArrayList<State> stateSet){
        this.tape = tape;
        this.stackAlphabet = alphabet;
        this.stateSet = stateSet;
    }

}
