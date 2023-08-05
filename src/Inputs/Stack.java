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
        this.stack = stack.getStack();
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

    public void push(Symbol symbol){
        if (symbol.getValue().equals("L")) {
            return;
        }

        if (symbol.getValue().length() > 1) {
            for (int i = 0; i < symbol.getValue().length(); i++) {
                stack.add(new Symbol(symbol.getValue().substring(i, i+1)));
            }
            return;
        }

    }

    public void pop(Symbol popsymbol){
        System.out.println("Popping " + popsymbol.getValue() + " from stack");
        if(popsymbol.getValue().equals("L")){
            return;
        }

        //use a for loop to pop multiple symbols
        //assumed to work without validation because of the validTransition method in Transition.java
        for (int i = 0; i < popsymbol.getValue().length(); i++) {
            stack.remove(stack.size()-1);
        }
    }

    //seek method for testing purposes
    public ArrayList<Symbol> getLastSymbols(int length){
        //returns the length amount of symbols from the end of the arraylist
        ArrayList<Symbol> symbols = new ArrayList<>();
        if(stack == null){
            return symbols;
        }
        if (stack.size() == 0 || stack.size() == 1) {
            return symbols;
        }
        for (int i = 0; i < length; i++) {
            symbols.add(stack.get(stack.size()-1-i));
        }
        return symbols;
    }

    public String toString(){
        String stackString = "";
        for (Symbol symbol : stack) {
            stackString += symbol.getValue();
        }
        return stackString;
    }
}
