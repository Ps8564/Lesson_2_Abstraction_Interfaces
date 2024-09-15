public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Human Pavel = new Human("Pavel");
        Human Maria = new Human("Maria");

        market.acceptToMarket(Pavel);
        market.acceptToMarket(Maria);

        market.update();
        market.releaseFromQueue();
    }
}