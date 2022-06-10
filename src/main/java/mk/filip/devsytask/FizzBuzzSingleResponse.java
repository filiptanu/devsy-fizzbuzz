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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FizzBuzzSingleResponse) {
            FizzBuzzSingleResponse instance = (FizzBuzzSingleResponse) obj;

            return this.entry.equals(instance.entry) && this.output.equals(instance.output);
        }

        return false;
    }
}
