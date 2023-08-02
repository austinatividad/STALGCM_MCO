package Inputs;
import java.util.ArrayList;

//Stores the set of transitions for a state
public class TransitionSet {
    ArrayList<Transition> transitions = new ArrayList<>();

    public void addTransition(Transition transition){
        transitions.add(transition);
    }

    public Transition getTransition(int index){
        return transitions.get(index);
    }

    public String toString() {
        String output = "";
        for (Transition transition : transitions) {
            output += transition.toString() + "\n";
        }
        return output;
    }

}
