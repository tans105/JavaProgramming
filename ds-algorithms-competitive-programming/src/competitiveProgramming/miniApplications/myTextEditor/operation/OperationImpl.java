package competitiveProgramming.miniApplications.myTextEditor.operation;

public class OperationImpl {
    private StringBuilder builder;

    public OperationImpl() {
        builder = new StringBuilder();
    }

    public void append(String text) {
        builder.append(text);
    }

    public void delete(Integer numberOfCharacters) {
        if (builder == null || numberOfCharacters > builder.length() - 1) {
            builder = new StringBuilder();
        } else {
            builder = new StringBuilder(builder.substring(0, builder.length() - numberOfCharacters - 1));
        }
    }

    public void print(Integer index) {
        if (index - 1 < builder.length()) {
            System.out.println(builder.charAt(index - 1));
        } else {
            System.out.println("No Sufficient text");
        }
    }

    //Todo
    private boolean undo() {
        return false;
    }

    //Todo
    private boolean redo() {
        return false;
    }

    public String toString() {
        return builder.toString();
    }
}
