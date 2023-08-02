package Inputs;

public class Symbol {
    private String value;

    public Symbol(String value) {
        setValue(value);
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
