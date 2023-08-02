package Inputs;

public class State {
    //Attributes
    private Symbol symbol;
    private boolean isInitial;
    private boolean isFinal;

    private TransitionSet transitionSet = new TransitionSet();

    //Constructor
    public State(Symbol symbol, boolean isInitial, boolean isFinal){
        this.symbol = symbol;
        this.isInitial = isInitial;
        this.isFinal = isFinal;
    }

    public boolean isInitial(){
        return isInitial;
    }

    public boolean isFinal(){
        return isFinal;
    }

    public Symbol getSymbol(){
        return symbol;
    }

    public void addTransition(Transition transition){
        transitionSet.addTransition(transition);
    }

    public String toString(){
        return "State: " + symbol.getValue() + " isInitial: " + isInitial + " isFinal: " + isFinal + "\n" + transitionSet.toString() + "\n";
    }
}
