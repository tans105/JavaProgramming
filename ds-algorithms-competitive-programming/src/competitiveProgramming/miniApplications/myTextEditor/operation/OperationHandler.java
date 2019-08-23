package competitiveProgramming.miniApplications.myTextEditor.operation;

import java.util.Stack;

public class OperationHandler {
    private StringBuilder builder;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public OperationHandler() {
        builder = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    private void append(String text) {
        builder.append(text);
    }

    private void delete(String text) {
        if (builder.toString().contains(text)) {
            int index = builder.indexOf(text);
            builder = new StringBuilder(builder.substring(0, index));
        }
    }

    private String delete(Integer numberOfCharacters) {
        String deletedCharacters = null;
        if (builder == null || numberOfCharacters > builder.length()) {
            builder = new StringBuilder();
        } else {
            deletedCharacters = builder.substring(builder.length() - numberOfCharacters);
            builder = new StringBuilder(builder.substring(0, builder.length() - numberOfCharacters));
        }
        return deletedCharacters;
    }

    private void print(Integer index) {
        if (index - 1 < builder.length()) {
            System.out.println(builder.charAt(index - 1));
        } else {
            System.out.println("No Sufficient text");
        }
    }

    private void undo() {
        if (undoStack.size() > 0) {
            String operationMetadata = undoStack.pop();
            runOperation(operationMetadata);
            String[] operationItems = operationMetadata.split(" ");
            String operation = operationItems[0];
            String operand = operationItems[1];
            if (operation.equals("1")) {
                redoStack.push("6 " + operand);
            }
            if (operation.equals("6")) {
                redoStack.push("1 " + operand);
            }
        }
    }

    private void redo() {
        if (redoStack.size() > 0) {
            runOperation(redoStack.pop());
        }
    }

    public String toString() {
        return builder.toString();
    }

    public void performOperation(String operation, String operand) {
        switch (operation) {
            case "1":  //append
                append(operand);
                undoStack.push("6 " + operand);
                break;
            case "2":  //delete k characters
                try {
                    String deletedCharacters = delete(Integer.parseInt(operand));
                    if (deletedCharacters != null) undoStack.push("1 " + deletedCharacters);
                } catch (Exception e) {
                    System.out.println("Invalid Operand");
                }
                break;
            case "3":  //print
                try {
                    print(Integer.parseInt(operand));
                } catch (Exception e) {
                    System.out.println("Invalid Operand");
                }
                break;
            case "4":  //undo
                undo();
                break;
            case "5":  //redo
                redo();
                break;
            case "6": //delete text
                delete(operand);
        }
    }

    public void runOperation(String operationItem) {
        String operand = null, operation = null;
        String[] operationMetadata = operationItem.trim().split(" ");
        operation = operationMetadata[0];
        if (operationMetadata.length > 1) operand = operationMetadata[1];
        performOperation(operation, operand);
    }
}
