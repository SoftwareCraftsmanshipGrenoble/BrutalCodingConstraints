package ttt;

public enum Player {
    X {
        public Player next() {
            return O;
        }
    }, O {
        public Player next() {
            return X;
        }
    }, NONE {
        public Player next() {
            return NONE;
        }
    };

    public abstract Player next();
}
