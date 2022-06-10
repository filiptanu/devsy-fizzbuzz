package mk.filip.devsytask;

public class FizzBuzzErrorResponse extends FizzBuzzResponse{

    private String message;

    public FizzBuzzErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
