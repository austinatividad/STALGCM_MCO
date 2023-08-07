package Inputs;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tape {
    //Attributes
    private ArrayList<Symbol> symbols = new ArrayList<>();

    private int currentIndex;
    //Constructor
    public Tape() {
        currentIndex = -1;
    }

    public Tape(ArrayList<Symbol> symbols){
        this.symbols = symbols;
        this.currentIndex = -1;
    }

    public Symbol getSymbol(int index){
        return symbols.get(index);
    }

    public Symbol getCurrentSymbol() {
        if (currentIndex > -1 && currentIndex < symbols.size()) {
            return symbols.get(currentIndex);
        }
        return new Symbol("L");
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int x) {
        System.out.println("set tape index: " + currentIndex);
        currentIndex = x;
    }

    public void increment() {
        System.out.println("pre-increment tape: " + currentIndex);
        ++currentIndex;
        System.out.println("increment tape: " + currentIndex);
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

    public String currentIndex(){
        if (currentIndex >= symbols.size()) {
            return "Tape Index: " + (symbols.size() - 1);
        }
        return "Tape Index: " + currentIndex;
    }




}
