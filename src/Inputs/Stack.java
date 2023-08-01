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

    public void push(Symbol symbol){

        stack.add(symbol);
    }

    public Symbol pop(){
        Symbol symbol = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return symbol;
    }

    //seek method for testing purposes
    public Symbol seek(){
        return stack.get(stack.size()-1);
    }
}
