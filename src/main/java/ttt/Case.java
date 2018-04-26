package ttt;

public enum Case {
    UN(0), DEUX(1), TROIS(2), QUATRE(3), CINQ(4), SIX(5), SEPT(6), HUIT(7), NEUF(8), EMPTY(9);

    private int index;

    Case(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
