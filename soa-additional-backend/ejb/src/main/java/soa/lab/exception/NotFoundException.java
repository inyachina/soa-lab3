package exception;

import lombok.Getter;

@Getter
public class NotFoundException extends ApiException {

    public NotFoundException() {
        super(404, "Not Found");
    }

    public NotFoundException(String message) {
        this();
        super.message = message;
    }

}