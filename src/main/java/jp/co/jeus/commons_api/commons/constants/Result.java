package jp.co.jeus.commons_api.commons.constants;

public enum Result {
    /**
     *
     */
    SUCCESS("Success"),
    /**
     *
     */
    EMPTY("Empty"),;

    private final String type;

    private Result(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
