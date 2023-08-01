package Inputs;

public class State {
    //Attributes
    private Symbol symbol;
    private boolean isInitial;
    private boolean isFinal;

    private TransitionSet transitionSet;

    //Constructor
    public State(Symbol symbol, boolean isInitial, boolean isFinal, TransitionSet transitionSet){
        this.symbol = symbol;
        this.isInitial = isInitial;
        this.isFinal = isFinal;
        this.transitionSet = transitionSet;
    }
}
