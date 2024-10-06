package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Id.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Look up by item's id ===");
        int id = input.askInt("Please enter item's id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Item" + " with id " + id + " is not found.");
        }
        return true;
    }
}
