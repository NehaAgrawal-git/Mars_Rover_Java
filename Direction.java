/**
 * Enum representing the four directions.
*/
public enum Direction {
    N, E, S, W;

    // Turn left from current direction.
    public Direction left() {
        switch (this) {
            case N:
                return W;
            case W:
                return S;
            case S:
                return E;
            case E:
                return N;
            default:
                throw new IllegalArgumentException();
        }
    }

    // Turn right from current direction.
    public Direction right() {
        switch (this) {
            case N:
                return E;
            case E:
                return S;
            case S:
                return W;
            case W:
                return N;
            default:
                throw new IllegalArgumentException();
        }
    }
}
