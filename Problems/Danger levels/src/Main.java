enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    int danger;

    DangerLevel(int danger) {
        this.danger = danger;
    }

    int getLevel() {
        return this.danger;
    }
}