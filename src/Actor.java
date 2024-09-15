public abstract class Actor implements ActorBehaviour{
    protected boolean isTakeOrder;
    protected boolean isMakeOrder;
    protected final String name;

    protected Actor(String name) {
        this.name = name;
    }

    public abstract String getName();
}
