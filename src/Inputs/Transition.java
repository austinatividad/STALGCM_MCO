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
        System.out.println("Stack 0: " + stack0.toString());
        System.out.println("Stack 1: " + stack1.toString());
        if (symbol.getValue().equals(inputSymbol.getValue())) {
            if (!popStack_0.getValue().equals("L")) {
                if (stack0.getLastSymbol().getValue().equals(popStack_0.getValue())) {
                    if (!popStack_1.getValue().equals("L")) {
                        if (stack1.getLastSymbol().getValue().equals(popStack_1.getValue())) {
                            stack0.pop();
                            stack1.pop();
                            stack0.push(pushStack_0);
                            stack1.push(pushStack_1);
                            System.out.println("pop pop push push");
                            return true;
                        }
                    } else {
                        stack0.pop();
                        stack0.push(pushStack_0);
                        stack1.push(pushStack_1);      
                        System.out.println("pop ignore push push");    
                        return true;
                    }
                }
            } else {
                if (!popStack_1.getValue().equals("L")) {
                    if (stack1.getLastSymbol().getValue().equals(popStack_1.getValue())) {
                        stack1.pop();
                        stack0.push(pushStack_0);
                        stack1.push(pushStack_1);
                        System.out.println("ignore pop push push");             
                        return true;
                    }
                } else {
                    stack0.push(pushStack_0);
                    stack1.push(pushStack_1);    
                    System.out.println("ignore ignore push push");              
                    return true;           
                }
            }
        }
        return false;
    }

    public String toString(){
        return "δ(" +
                currentState.getSymbol().getValue() + ", " +
                convertLambdaVisual(inputSymbol.getValue()) + ", " +
                convertLambdaVisual(popStack_0.getValue()) + ", " +
                convertLambdaVisual(popStack_1.getValue()) + ") = (" +
                nextState.getSymbol().getValue() + ", " +
                convertLambdaVisual(pushStack_0.getValue()) + ", " +
                convertLambdaVisual(pushStack_1.getValue()) + ")";


    }

    private String convertLambdaVisual(String lambda) {
        if (lambda.equals("L")) {
            return "λ";
        } else {
            return lambda;
        }
    }

}
