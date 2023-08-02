package Inputs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tape {
    //Attributes
    private ArrayList<Symbol> symbols = new ArrayList<>();

    private int currentIndex;
    //Constructor
    public Tape() {
        currentIndex = 0;
    }

    public Tape(ArrayList<Symbol> symbols){
        this.symbols = symbols;
        this.currentIndex = 0;
    }

    public Symbol getSymbol(int index){
        return symbols.get(index);
    }

    public Symbol getCurrentSymbol() {
        return symbols.get(currentIndex);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int x) {
        currentIndex = x;
    }

    public void increment() {
        ++currentIndex;
        System.out.println("increment tapes");
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

    public void addSymbol(Symbol symbol) {
        symbols.add(symbol);
    }

    public String toString(){
        String tapeString = "Tape: ";
        for (Symbol symbol : symbols) {
            tapeString += symbol.getValue();
        }
        return tapeString;
    }


    //private method for converting



}
