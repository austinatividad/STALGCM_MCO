package Inputs;

import java.util.ArrayList;

public class Alphabet {
    //Stores the Alphabet of stack symbols that can be used by the machine
    private ArrayList<Symbol> symbols = new ArrayList<>();

    public void addSymbol(Symbol symbol){
        symbols.add(symbol);
    }

    public Symbol getSymbol(int index){
        return symbols.get(index);
    }

    public ArrayList<Symbol> getSymbols(){
        return symbols;
    }

    public void removeSymbol(int index){
        symbols.remove(index);
    }

    public void popSymbol(){
        symbols.remove(symbols.size()-1);
    }

    public String toString(){
        String alphabetString = "Alphabet (Allowed Stack Symbols): ";
        for (Symbol symbol : symbols) {
            alphabetString += symbol.getValue();
            alphabetString += ", ";
        }
        return alphabetString;
    }
}