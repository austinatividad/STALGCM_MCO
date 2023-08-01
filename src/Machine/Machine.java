package Machine;

import Inputs.Tape;
import Inputs.Alphabet;
import Inputs.Stack;

//Class for creating a 2-STACK PDA machine
public class Machine {
    //Attributes that contain the formal definition of the machine
    private Tape tape = new Tape();
    private Alphabet alphabet = new Alphabet();
    private Stack stack_0 = new Stack();
    private Stack stack_1 = new Stack();

    //Constructor
    public Machine(Tape tape, Alphabet alphabet){
        this.tape = tape;
        this.alphabet = alphabet;
    }

}
