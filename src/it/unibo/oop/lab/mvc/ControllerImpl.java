package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private String nextString;
    private final List<String> historyString = new ArrayList<>();
    /**
     * {@link Controller#setNextString(String s)}.
     */
    @Override
    public void setNextString(final String s) {
        if (s == null) {
            throw new IllegalStateException();
        }
        this.nextString = s;
        this.historyString.add(s);
    }
    /**
     * {@link Controller#getNextString()}.
     */
    @Override
    public String getNextString() {
        return this.nextString;
    }
    /**
     *{@link Controller#getHistoryString()}. 
     */
    @Override
    public List<String> getHistoryString() {
        return this.historyString;
    }
    /**
     * {@link Controller#printString()}.
     */
    @Override
    public void printString() {
        if (this.getNextString() == null) {
            throw new IllegalStateException();
        }
        System.out.println(this.getNextString());
    }
}
