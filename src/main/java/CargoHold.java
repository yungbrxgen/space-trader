import java.util.HashMap;
import java.util.Map;

public class CargoHold {
    private final int maxCapacity;
    private final Map<Resource, Integer> resources = new HashMap<>();

    public CargoHold(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getOccupiedSpace() {
        return resources.entrySet().stream()
                .mapToInt(e ->
                    e.getKey().getVolume() * e.getValue()
                )
                .sum();
    }

    public int getFreeSpace() {
        return maxCapacity - getOccupiedSpace();
    }

    public boolean addResources(Resource resource, int amount) {
        if ((amount * resource.getVolume()) > getFreeSpace()) {
            System.out.println("Не хватает свободного места, чтобы положить в трюм");
            return false;
        }
        int currentAmount = resources.getOrDefault(resource, 0);
        resources.put(resource, amount +  currentAmount);
        return true;
    }

    public boolean removeResources(Resource resource, int amount) {
        if (!resources.containsKey(resource)) {
            System.out.println("Ресурс в трюме не обнаружен");
            return false;
        } else if (resources.get(resource) < amount) {
            System.out.println("У Вас нет такого количества этого ресурса");
            return false;
        }
        int currentAmount = resources.getOrDefault(resource, 0);
        int newAmount = currentAmount - amount;
        if (newAmount == 0) {
            resources.remove(resource);
        } else {
            resources.put(resource, currentAmount - amount);
        }
        return true;
    }

    public Map<Resource, Integer> getResources() {
        return resources;
    }

    public boolean isExistResource(Resource resource, int amount) {
        if (!resources.containsKey(resource)) {
            System.out.println("Ресурс не найден");
            return false;
        } else if (resources.get(resource) < amount) {
            System.out.println("Ресурсов такого количества не обнаружено");
            return false;
        }
        return true;
    }
}
