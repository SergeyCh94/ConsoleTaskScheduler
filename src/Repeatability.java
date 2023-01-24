public enum Repeatability {
    ONE_TIME("Однократная"), DAILY("Ежедневная"), WEEKLY("Еженедельная"), MONTHLY("Ежемесячная"), YEARLY("Ежегодная");

    String repeatability;

    Repeatability(String repeatability) {
        this.repeatability = repeatability;
    }

    public String getRepeatability() {
        return repeatability;
    }
}
