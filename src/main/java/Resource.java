public enum Resource {
    FOOD("Еда", 5, 1),
    ORE("Руда", 20, 3),
    GARBAGE("Хлам", 2, 1);

    private final String translate;
    private final int cost;
    private final int volume;

    Resource(String translate, int cost, int volume) {
        this.translate = translate;
        this.cost = cost;
        this.volume = volume;
    }

    public String getTranslate() {
        return translate;
    }

    public int getCost() {
        return cost;
    }

    public int getVolume() {
        return volume;
    }
}
