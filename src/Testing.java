import Inputs.Alphabet;
import Inputs.Stack;
import Inputs.Symbol;

import java.util.Scanner;
public class Testing {
    public static void main(String[] args) {
        Stack stack = new Stack();
        //print stack
        System.out.println(stack.seek().getValue());
        //add symbol to stack
        stack.push(new Symbol("A"));
        //print stack
        System.out.println(stack.seek().getValue());

        //pop symbol from stack
        stack.pop();

        //print stack
        System.out.println(stack.seek().getValue());

        Alphabet alphabet = new Alphabet();

        //add symbol to alphabet
        alphabet.addSymbol(new Symbol("A"));
        alphabet.addSymbol(new Symbol("B"));
        alphabet.addSymbol(new Symbol("C"));
        alphabet.addSymbol(new Symbol("D"));

        //print contents of alphabet
        for (Symbol symbol : alphabet.getSymbols()) {
            System.out.println(symbol.getValue() + ": Alphabet");
        }


    }
}
