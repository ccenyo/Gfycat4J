package views;

public class ErrorResponse {

    public ErrorMessage errorMessage;

    public static class ErrorMessage {
        public String code;
        public String description;

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
