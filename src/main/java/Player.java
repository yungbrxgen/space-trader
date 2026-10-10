public class Player {
    private final String name;
    private int credits;
    private Ship ship;

    public Player(String name, int credits, Ship ship) {
        this.name = name;
        this.credits = credits;
        this.ship = ship;
    }

    public boolean buyResources(Resource resource, int amount, int pricePerUnit) {
        int totalCost = amount * pricePerUnit;
        if (totalCost > credits) {
            System.out.println("Кредитов на балансе не достаточно");
            return false;
        } else if ((resource.getVolume() * amount) > ship.getCargoHold().getFreeSpace()) {
            System.out.println("Места в трюме не достаточно");
            return false;
        }
        ship.getCargoHold().addResources(resource, amount);
        credits -= totalCost;
        System.out.println("Было приобретено " + resource.getTranslate() + " в количестве: " + amount + ".");
        System.out.println("Было потрачено: " + totalCost + ". Баланс: " + credits + ".");
        return true;
    }

    public boolean sellResources(Resource resource, int amount, int pricePerUnit) {
        int totalCost = amount * pricePerUnit;
        if (!ship.getCargoHold().isExistResource(resource, amount)) {
            System.out.println("Ресурс отсутствует в трюме или его не достаточно");
            return false;
        }
        credits += totalCost;
        ship.getCargoHold().removeResources(resource, amount);
        System.out.println("Было продано " + resource.getTranslate() + " в количестве: " + amount + ".");
        System.out.println("Прибыль составила: " + totalCost + ". Баланс: " + credits + ".");
        return true;
    }

    public int getCredits() {
        return credits;
    }
}
