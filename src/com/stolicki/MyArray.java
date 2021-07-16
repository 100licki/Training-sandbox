package com.stolicki;

public class MyArray {

    private final int[] theArray = new int[50];
     private int arraySize = 10;

     public void generateRandomArray() {
         for(int i=0; i <arraySize; i++) {
             theArray[i] = (int)(Math.random()*10)+10;
         }
     }

     public void  printArray() {
         System.out.println("__________");
         for(int i=0; i < arraySize; i++){
             System.out.print("| " + i + " | ");
             System.out.println(theArray[i] + " |");
             System.out.println("----------");
         }
     }

     public int getValueAtIndex(int index) {
         if(index < arraySize) {
             return theArray[index];
         }
         return -1;
     }

     public boolean doesArrayContainThisValue(int searchValue) {
         for (int i=0; i<arraySize; i++) {
             if(theArray[i] == searchValue) {
                 return true;
             }
         }
         return false;
     }

     public void deleteIndex(int index) {
         if(index<arraySize) {
             for(int i = index; i < arraySize-1; i++) {
                 theArray[i] = theArray[i+1];
             }
             arraySize--;
         }
     }

     public void insertValue(int value) {
         if(arraySize < 50) {
             theArray[arraySize] = value;
             arraySize++;
         }
     }

     public String linearSearchForValue(int value) {
        boolean valueInArray = false;
        String indexWithValue = "";
        System.out.println("The value was Found in: ");

        for(int i = 0; i<arraySize; i++){
            if(theArray[i] == value) {
                valueInArray = true;
                System.out.print(i + " ");
                indexWithValue+= i + " ";
            }
        }
        if(!valueInArray) {
            indexWithValue = "None";
            System.out.print(indexWithValue);
        }
         System.out.println();
        return indexWithValue;
     }

     public void bubbleSort() {
         for(int i= arraySize-1; i>1; i--) {
             for(int j = 0; j<i; j++) {
                 if(theArray[j] > theArray[j+1]){
                     swapValues(j,j+1);
                 }
             }
         }
     }

     public void binarySearchForValue(int value) {
         int lowIndex = 0;
         int highIndex = arraySize-1;

         while(lowIndex <= highIndex) {
             int middleIndex = (highIndex+lowIndex)/2;
             if(theArray[middleIndex] < value) {
                 lowIndex = middleIndex+1;
             }
             else if(theArray[middleIndex] > value) {
                 highIndex = middleIndex-1;
             }
             else {
                 System.out.println("Found a value: " + value + " at the index of " + middleIndex);
                 lowIndex = highIndex+1;
             }
         }
     }

     public void selectionSort() {
         for(int i=0; i<arraySize; i++) {
             int min = i;
             for(int j = i; j<arraySize; j++) {
                 if(theArray[min] > theArray[j]) {
                     min = j;
                 }
             }
         }
     }

     public void insertionSort() {
         for(int i = 1; i<arraySize;i++) {
             int j = i;
             int toInsert = theArray[i];
             while((j>0) && (theArray[j-1]>toInsert)){
                 theArray[j] = theArray[j-1];
                 j--;
             }
         }
     }

    private void swapValues(int j, int i) {
        int temp = theArray[j];
        theArray[j] = theArray[i];
        theArray[i] = temp;
    }

    public static void main(String[] args) {
        MyArray Array = new MyArray();
        Array.generateRandomArray();
        Array.printArray();
        System.out.println(Array.getValueAtIndex(3));
        System.out.println(Array.doesArrayContainThisValue(18));
        Array.deleteIndex(2);
        Array.printArray();
        Array.insertValue(999);
        Array.printArray();
        Array.linearSearchForValue(111);

    }
}
