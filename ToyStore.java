import java.util.PriorityQueue;
public class ToyStore {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> {
        double rand1 = t1.getWeight() * Math.random();
        double rand2 = t2.getWeight() * Math.random();

        return Double.compare(rand2, rand1);
    });

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public Toy getToy() {
        return toyQueue.poll();
    }
}