import java.util.Arrays;
import java.util.LinkedList;

public class MyStack {

    private String[] stackArray;

    private int stackSize;

    private int topOfStack = -1;

    MyStack(int size) {
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String input) {
        if(topOfStack+1 < stackSize){
            topOfStack++;
            stackArray[topOfStack] = input;
        }
        else {
            System.out.println("stack is full");

            System.out.println("PUSH " + input + " Was Added to the Stack");
        }


    }
}
