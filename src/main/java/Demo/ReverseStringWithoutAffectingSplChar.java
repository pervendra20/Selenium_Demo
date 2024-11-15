package Demo;

public class ReverseStringWithoutAffectingSplChar {


    public static void main(String[] args) {

        String input = "!A@B#C$D";
        String output = "!D@C#B$A";
        System.out.println("Input: " + input);
        System.out.println("Output: " + reversestring(input));
    }
    static  String reversestring(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (Character.IsAlphabetic(arr[length])) {
                left++;
            } else if (!Character.isAlphabetic(arr[length])) {

                right--;

            }
            return new String(arr);

        }


    }}
}
drive= findElement ()