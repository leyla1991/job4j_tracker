package ru.job4j.tracker;

public class ExitAppAction implements UserAction {
    private final Output out;

    public ExitAppAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit the App.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}