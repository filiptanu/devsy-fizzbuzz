package mk.filip.devsytask;

public class FizzBuzzSingleResponse extends FizzBuzzResponse {

    private String entry;
    private String output;

    public FizzBuzzSingleResponse(String entry, String output) {
        this.entry = entry;
        this.output = output;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}
