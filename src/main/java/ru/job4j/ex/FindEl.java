package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;

        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (key == null && rsl == -1) {
            throw new ElementNotFoundException("Key could not be null");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[] {"Ben", "Fen"}, null);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
