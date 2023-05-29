package jp.co.jeus.commons_api.commons.constants;

public enum Result {
    /**
     * Success
     */
    SUCCESS(0, "Success", "Success"),
    /**
     * No contents
     */
    EMPTY(1, "Empty", "No contents"),
    /**
     * Internal server error
     */
    INTERNAL_SERVER_ERROR(99, "Internal server error", "Unexpected error has occurred");

    private final int code;
    private final String name;
    private final String details;

    Result(int code, String name, String details) {
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
