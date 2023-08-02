package Inputs;

public class Transition {
    //Attributes
    public State currentState;
    public Symbol inputSymbol;

    public Symbol popStack_0;
    public Symbol pushStack_0;

    public Symbol popStack_1;
    public Symbol pushStack_1;


    public State nextState;

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

    public Boolean validTransition(Symbol symbol, Stack stack0, Stack stack1) {
        if (symbol.getValue().equals(inputSymbol.getValue())) {
            if (!popStack_0.getValue().equals("L")) {
                if (stack0.getLastSymbol().getValue().equals(popStack_0.getValue())) {
                    if (!popStack_1.getValue().equals("L")) {
                        if (stack1.getLastSymbol().getValue().equals(popStack_1.getValue())) {
                            stack0.pop();
                            stack1.pop();
                            stack0.push(pushStack_0);
                            stack1.push(pushStack_1);
                            return true;
                        }
                    } else {
                        stack0.pop();
                        stack0.push(pushStack_0);
                        stack1.push(pushStack_1);                   
                    }
                }
            } else {
                if (!popStack_1.getValue().equals("L")) {
                    if (stack1.getLastSymbol().getValue().equals(popStack_1.getValue())) {
                        stack1.pop();
                        stack0.push(pushStack_0);
                        stack1.push(pushStack_1);
                        return true;
                    }
                } else {
                    stack0.push(pushStack_0);
                    stack1.push(pushStack_1);     
                    return true;           
                }
            }
        }
        return false;
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
