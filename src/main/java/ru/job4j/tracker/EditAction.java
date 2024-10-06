package ru.job4j.tracker;

public class EditAction implements UserAction {

    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Please enter item's id: ");
        String name = input.askStr("Please enter a new name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("The item has been changed.");
        } else {
            out.println("Error when changing the item.");
        }
        return true;
    }
}
