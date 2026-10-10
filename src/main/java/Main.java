public class Main {
    public static void main(String[] args) {
        CargoHold cargoHold = new CargoHold(15);
        Ship ship = new Ship("Голландец", cargoHold, 20, 40);
        Player player = new Player("Капитан Шеппард", 1000, ship);

        player.buyResources(Resource.FOOD, 10, 20);
        player.buyResources(Resource.FOOD, 10, 20);
        player.sellResources(Resource.FOOD, 5, 40);

        System.out.println(player.getCredits());
        System.out.println(cargoHold.getResources());
    }
}
