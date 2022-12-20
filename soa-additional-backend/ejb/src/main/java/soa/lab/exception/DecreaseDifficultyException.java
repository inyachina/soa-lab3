package exception;


import lombok.Getter;


@Getter
public class DecreaseDifficultyException extends ApiException {
    public DecreaseDifficultyException() {
        super(406, "Impossible to decrease");
    }

    public DecreaseDifficultyException(String message) {
        this();
        super.message = message;
    }
}