package jp.co.jeus.commons_api.commons.constants;

public enum Result {
    /**
     *
     */
    SUCCESS(0, "Success", "Success"),
    /**
     *
     */
    EMPTY(1, "Empty", "No contents"),
    /**
     *
     */
    INTERNAL_SERVER_ERROR(99, "Internal server error", "Unexpected error has occurred");

    private final int code;
    private final String name;
    private final String details;

    private Result(int code, String name, String details) {
        this.code = code;
        this.name = name;
        this.details = details;
    }

    public int getCode() {
        return this.code;
    }

    public String getCodeName() {
        return this.name;
    }

    public String getDetails() {
        return this.details;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
