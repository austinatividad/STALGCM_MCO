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

    private ArrayList<ArrayList<Symbol>> transitionLog = new ArrayList<ArrayList<Symbol>>();
    private int logCounter = 0;

    //Constructor
    public Machine(Alphabet stackAlphabet, Tape tape, ArrayList<State> stateSet, State startState){
        this.tape = tape;
        this.stateSet = stateSet;
        this.stackAlphabet = stackAlphabet;
        transitionLog.add(new ArrayList<>());
        stateStacks.addStack(startState, new Transition(), transitionLog.get(logCounter), new Stack(stack0), new Stack(stack1), -1);
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
            tape.setCurrentIndex(currentStack.inputIndex + 1);
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
            if ((stack0.isEmpty() && stack1.isEmpty())) {
                isAccepted = true;
            }
            stack0 = currentStack.stack0;
            stack1 = currentStack.stack1;
            System.out.println("State Stacks: " + stateStacks.getStackSize());
            // ---------------- TODO: NOT SURE IF THIS WILL ALWAYS WORK ----------------
            if (currentBranches.size() == 0) {
                System.out.println("Current Transition: null");
                logCounter++;
                transitionLog.add(new ArrayList<>());
                transitionLog.get(logCounter).addAll(currentStack.pastTransitions);
            } else {
                System.out.println("Current Transition: " + currentStack.transition.toString());
                transitionLog.get(logCounter).add(currentStack.transition.getNextState().getSymbol());
            }

        }
    }

    private ArrayList<StateStackItem> branchCurrentState(State state, Tape tape) {
        ArrayList<StateStackItem> returnStates = new ArrayList<StateStackItem>();
        System.out.println("Branching from: " + state.getSymbol().getValue());
        returnStates = state.getTransitions().getValidTransitions(state, tape.getCurrentSymbol(), transitionLog.get(logCounter), tape.getCurrentIndex(), stack0, stack1);

        //Adds itself again because there are no transitions
//        if (returnStates.size() == 0) {
//            returnStates.add(new StateStackItem(state, new Transition(), stack0, stack1, 0));
//        }

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

    public String getTransitionLog() {

        String string = new String();

        if(transitionLog.size() == 0) {
            return "";
        } else {
            for (int i = 0; i < transitionLog.size(); i++) {
                if (i == transitionLog.size() - 1) {
                    if (isAccepted) {
                        string += "<span style=\"color:green\">";
                    } else {
                        string += "<span style=\"color:blue\">";
                    }
                } else {
                    string += "<span style=\"color:red\">";
                }
                for (int j = 0; j < transitionLog.get(i).size(); j++) {
                    if(transitionLog.get(i).size() - j == 1) {
                        string += transitionLog.get(i).get(j).getValue();
                    } else {
                        string += transitionLog.get(i).get(j).getValue() + " ⮕ ";
                    }
                }
                string += "</span>";
                string += "<br>";
            }
        }

        return string;
    }

    public StateStacks getStateStacks() {
        return stateStacks;
    }


}
