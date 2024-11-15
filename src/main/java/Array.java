// Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
//move all 0 to right

import java.util.Arrays;

public class MoveZeros {


    public static void main(int[] arr) {
        int[] arr = {0, 1, 0, 3, 12};
        MoveZeros(arr);
        System.out.println("array after moving to right: " + Arrays.toString(arr));

    }
}

public static void MoveZeros(int[] arr) {

    int index = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            arr[index] = arr[i];
            index++;
        }
    }

    while (index < arr.length) {
        arr[index] = 0;
        index++;
    }
}

