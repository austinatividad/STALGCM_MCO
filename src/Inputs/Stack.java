package Inputs;

import java.util.ArrayList;

public class Stack {
    //Attributes

    //The stack will always contain the initial stack symbol Z
    private ArrayList<Symbol> stack = new ArrayList<>();


    //Methods only allow push and pop operations
    public Stack () {
        stack.add(new Symbol("Z"));
    }

    public Stack(Stack stack) {
        this.stack = (ArrayList)stack.getStack().clone();
    }

    public ArrayList<Symbol> getStack() {
        return stack;
    }

    public Boolean isEmpty() {
        return stack.isEmpty();
    }

    public Symbol getLastSymbol() {
        if (stack.size() == 0) {
            return new Symbol("L"); 
        }
        return stack.get(stack.size()-1);
    }

    public String getLastSymbols(int x) {
        StringBuilder string = new StringBuilder();

        for (int i = stack.size() - 1; i >= stack.size() - x; i--) {
            string.append(stack.get(i).getValue());
        }

        return string.toString();
    }

    public void push(Symbol symbol){
        if (symbol.getValue().length() > 1) {
            for (int i = 0; i < symbol.getValue().length(); i++) {
                stack.add(new Symbol(symbol.getValue().substring(i, i+1)));
            }
            return;
        }

        if (!symbol.getValue().equals("L")) {
            stack.add(symbol);
        }
        //handle multi-line input by separating into separate stack.add calls

    }

    public Symbol pop(){
        Symbol symbol = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return symbol;
    }

    public ArrayList<Symbol> pop(int x){
        ArrayList<Symbol> symbol = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            symbol.add(stack.get(stack.size()-1));
            stack.remove(stack.size()-1);
        }
        return symbol;
    }

    //seek method for testing purposes
    public Symbol seek(){
        return stack.get(stack.size()-1);
    }

    public String toString(){
        String stackString = "";
        for (Symbol symbol : stack) {
            stackString += symbol.getValue();
        }
        return stackString;
    }
}
