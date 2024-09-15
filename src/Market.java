import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehaviour, QueueBehaviour {
    private final List<Actor> queue = new ArrayList<>();

    @Override
    public void acceptToMarket(Actor actor) {
        queue.add(actor);
        System.out.println(actor.getName() + " вошел в магазин и стал в очередь.");
    }

    @Override
    public void releaseFromMarket(List<Actor> actorList) {
        queue.removeAll(actorList);
        actorList.forEach(actor -> System.out.println(actor.getName() + " покинул магазин."));
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
    }

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
        System.out.println(actor.getName() + " встал в очередь.");
    }

    @Override
    public void takeOrders() {
        queue.forEach(actor -> {
            if (!actor.isTakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " сделал заказ.");
            }
        });
    }

    @Override
    public void giveOrders() {
        queue.forEach(actor -> {
            if (actor.isTakeOrder() && !actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ.");
            }
        });
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> toRemove = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isMakeOrder()) {
                toRemove.add(actor);
                System.out.println(actor.getName() + " вышел из очереди.");
            }
        }
        queue.removeAll(toRemove);
        releaseFromMarket(toRemove);
    }
}

