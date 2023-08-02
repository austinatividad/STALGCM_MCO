package Inputs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tape {
    //Attributes
    private ArrayList<Symbol> symbols = new ArrayList<>();

    //Constructor

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


    //private method for converting



}
