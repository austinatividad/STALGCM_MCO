
import Inputs.*;
import Machine.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
        public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);

    //read file
    try {
        FileReader f = new FileReader("./inputs/testing.txt");
        BufferedReader br = new BufferedReader(f);

        //get number of states
        int stateCount = Integer.parseInt(br.readLine());
        System.out.println(stateCount);

        //get names of states

        String[] symbols = br.readLine().split(" ");
        for (String state : symbols) {
            System.out.println("State: " + state);
        }

        //get size of tape
        int tapeSize = Integer.parseInt(br.readLine());
        System.out.println(tapeSize);

        //get tape symbols
        String[] tapeSymbols = br.readLine().split(" ");
        for (String symbol : tapeSymbols) {
            System.out.println("Input Tape: " + symbol);
        }

        //get number of stack symbols
        int stackCount = Integer.parseInt(br.readLine());

        //get names of stack symbols
        String[] stackSymbols = br.readLine().split(" ");
        for (String symbol : stackSymbols) {
            System.out.println("Symbol: " + symbol);
        }

        //get number of transitions
        int transitionCount = Integer.parseInt(br.readLine());

        //get transitions
        ArrayList<String> transitions = new ArrayList<>();
        for (int i = 0; i < transitionCount; i++) {
            transitions.add(br.readLine());
            System.out.println("Transition: " + transitions.get(i));
        }

        //get start state
        String startState = br.readLine();

        //get number of final states
        int finalStateCount = Integer.parseInt(br.readLine());

        //get final states
        ArrayList<String> finalStates = new ArrayList<>();
        String[] finalStateString = br.readLine().split(" ");
        for (String finalState : finalStateString) {
            finalStates.add(finalState);
            System.out.println("Final State: " + finalState);
        }

        //initialize stateSet array
        ArrayList<State> stateSet = new ArrayList<>();
        //for each state in symbols
        for (String state : symbols) {
            //create a new Symbol
            Symbol newStateSymbol = new Symbol(state);

            //get if it is an initial state
            boolean isInitial = false;
            if (state.equals(startState)){
                isInitial = true;
            }

            //get if it is a final state
            boolean isFinal = false;
            for (String finalState : finalStates) {
                if (state.equals(finalState)){
                    isFinal = true;
                }
            }
            //create a new state
            State newState = new State(newStateSymbol,isInitial, isFinal);
            //add it to the stateSet
            stateSet.add(newState);
        }

        System.out.println("Testing States ----");
        for (State state : stateSet) {
            System.out.println("State: " + state.getSymbol().getValue());
            System.out.println("Initial: " + state.isInitial());
            System.out.println("Final: " + state.isFinal());
        }

        //initialize the transitions for each state
        for (State state : stateSet) {
            TransitionSet set = new TransitionSet();

        }

        //initialize transitions
        //get transition components:
        for(int i = 0; i < transitions.size(); i++){
            System.out.println("Transition: " + transitions.get(i));
            String[] transitionComponents = transitions.get(i).split(" ");
            //initialize transition
            //loop through the states
            State cur_state = null;
            State next_state = null;
            for (State state : stateSet){
                //check each transition, if the first component matches the state
                System.out.println("Current State: " + state.getSymbol().getValue());
                if( transitionComponents[0].equals(state.getSymbol().getValue())){
                    System.out.println("Matched State: " + state.getSymbol().getValue());
                    cur_state = state;
                    break;
                }
            }
            for (State state : stateSet){
                //check each transition, if the last component matches the state
                System.out.println("Next State: " + state.getSymbol().getValue());
                if( transitionComponents[6].equals(state.getSymbol().getValue())){
                    System.out.println("Matched State: " + state.getSymbol().getValue());
                    next_state = state;
                    break;
                }
            }
            Transition new_trans =  new Transition(cur_state,
                                    new Symbol(transitionComponents[1]),
                                    new Symbol(transitionComponents[2]),
                                    new Symbol(transitionComponents[3]),
                                    new Symbol(transitionComponents[4]),
                                    new Symbol(transitionComponents[5]),
                                    next_state);
            //add transition to the cur_state's transition set
            cur_state.addTransition(new_trans);

            //print transition
            System.out.println(new_trans.toString());
        }

        //use state tostring for each state
        //STATESET IS NOW COMPLETE-----------------------------------------------------------------------
        System.out.println("List of States ------------------");
        for (State state : stateSet) {
            System.out.println(state.toString());
        }

        //INITIALIZE TAPE
        Tape tape = new Tape();
        for (String symbol : tapeSymbols) {
            tape.addSymbol(new Symbol(symbol));
        }

        System.out.println("Tape: ");
        for (Symbol symbol : tape.getSymbols()) {
            System.out.println(symbol.getValue());
        }
        //TAPE IS NOW COMPLETE-----------------------------------------------------------------------


        //INITIALIZE STACK ALPHABET
        Alphabet stackAlphabet = new Alphabet();
        for (String symbol : stackSymbols) {
            stackAlphabet.addSymbol(new Symbol(symbol));
        }


        System.out.println("Stack Alphabet: ");
        for (Symbol symbol : stackAlphabet.getSymbols()) {
            System.out.println(symbol.getValue());
        }
        //STACK ALPHABET IS NOW COMPLETE-----------------------------------------------------------------------

        //Initialize Machine
        Machine machine = new Machine( stackAlphabet, tape, stateSet);

        System.out.println(machine.toString());








    }  catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


    }
}
