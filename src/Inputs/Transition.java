package Inputs;

public class Transition {
    //Attributes
    private State currentState;
    private Symbol inputSymbol;

    private Symbol popStack_0;
    private Symbol pushStack_0;

    private Symbol popStack_1;
    private Symbol pushStack_1;


    private State nextState;

    //Constructor
    public Transition(State currentState,
                      Symbol inputSymbol,
                      Symbol popStack_0,
                      Symbol pushStack_0,
                      Symbol popStack_1,
                      Symbol pushStack_1,
                      State nextState
    ){
        this.currentState = currentState;
        this.inputSymbol = inputSymbol;
        this.popStack_0 = popStack_0;
        this.pushStack_0 = pushStack_0;
        this.popStack_1 = popStack_1;
        this.pushStack_1 = pushStack_1;
        this.nextState = nextState;
    }

    public Transition getTransition(){
        return this;
    }

    public String toString(){
        return "Transition: " + currentState.getSymbol().getValue() + " " +
                inputSymbol.getValue() + " " +
                popStack_0.getValue() + " " +
                pushStack_0.getValue() + " " +
                popStack_1.getValue() + " " +
                pushStack_1.getValue() + " " +
                nextState.getSymbol().getValue();
    }
}
