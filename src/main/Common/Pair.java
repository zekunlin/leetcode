package Common;

public class Pair<T, U> {
    public final T first;
    public final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getKey(){
        return this.first;
    }

    public U getValue(){
        return this.second;
    }
}
