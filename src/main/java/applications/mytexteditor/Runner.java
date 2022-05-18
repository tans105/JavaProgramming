package applications.mytexteditor;

import applications.mytexteditor.operation.OperationHandler;

/**
 * You must implement a simple text editor. Operations:
 * <p>
 * 1.append(W) : append string W to the end of S.
 * 2.delete(k) : Delete the last k characters of S.
 * 3.print(k) : Print the Kth character of S.
 * 4.undo() : Undo the last(not previously undone) operation of type 1,2 or 5 reverting S to the state it was prior to that operation.
 * 5.redo() : reverse the effect of last undo operation.
 * <p>
 * Input format: The input will be given in a string format which is of the pattern opcode operand. The only exception is undo, redo operations will not have the operand.
 * <p>
 * A sample input looks like:
 * <p>
 * 1 abc;
 * 3 3;
 * 2 3;
 * 1 xy;
 * 3 2;
 * 4;
 * 5;
 * 3 1;
 * <p>
 * Output would be:
 * <p>
 * c
 * y
 * x
 * <p>
 * Constraints are:
 * - The number of operations would be limited to 1 million.
 * - At any time the number of characters to be deleted or printed as part of delete or print operation will be less than the length
 * of the string so formed so far.
 **/
public class Runner {
    static OperationHandler op = new OperationHandler();

    public static void main(String[] args) {
        String operations = "1 abc;3 3;2 3;1 xy;3 2;4;5;3 1;";
        parseAndRunOperation(operations);
    }

    private static void parseAndRunOperation(String operations) {
        OperationHandler op = new OperationHandler();
        String[] operationList = operations.split(";");
        for (String operationItem : operationList) {
            op.runOperation(operationItem);
        }
    }
}