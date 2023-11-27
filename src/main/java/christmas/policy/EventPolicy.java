package christmas.policy;

public enum EventPolicy {
    GIVEAWAY_EVENT_CONSTRAINT(120000),
    SANTA_BADGE_CONSTRAINT(20000),
    TREE_BADGE_CONSTRAINT(10000),
    STAR_BADGE_CONSTRAINT(5000),
    NUMBER_OF_MENU_CONSTRAINT(20),
    EVENT_APPLY_CONSTRAINT(10000);

    private final int limit;

    EventPolicy(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
