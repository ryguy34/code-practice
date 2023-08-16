import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodePractice {
    public static void main(String[] args) {
        // Valid Parenthesis
//        String bracketString = "({[]}){";
//        System.out.println(isValid(bracketString));

        // Best Time to Buy and Sell Stock
//        int[] prices = {3,2,6,5,0,3};
//        System.out.println(maxProfit(prices));

        // Valid Palindrome
//        String s = "racecar";
//        String s = " ";
//        System.out.println(isPalindrome(s));

        // Valid Anagram
//        String s = "anagram";
//        String t = "nagaram";
//        System.out.println(isAnagram(s,t));

        // Binary Search
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;
//        System.out.println(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid]>target) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        return -1;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (t.contains(String.valueOf(c))) {
                t = t.replaceFirst(String.valueOf(c), "");
            } else {
                return false;
            }
        }

        return t.isEmpty();
    }

    public static boolean isPalindrome(String s) {
        StringBuilder reverseString = new StringBuilder();
        // strip all non-alphanumeric chars
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        if (s.isEmpty()) {
            return true;
        }

        for (int i = s.length()-1; i >= 0; i--) {
            reverseString.append(s.charAt(i));
        }

        System.out.println(s);
        System.out.println(reverseString);

        return s.equalsIgnoreCase(reverseString.toString());
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];
        int minIndex = 0;
        int maxIndex = 0;
        int tempProfit = 0;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
            if (prices[i] > max) {
                max = prices[i];
                maxIndex = i;
            }
            if (maxIndex < minIndex) {
                max = 0;
                maxIndex = 0;
            } else {
                tempProfit = max - min;
            }
            if(tempProfit > profit) {
                profit = tempProfit;
            }
        }

        System.out.println("Min: " + min + " Max: " + max);
        System.out.println("MinIndex: " + minIndex + " MaxIndex: " + maxIndex);

        return profit;
    }

    public static boolean isValid(String s) {
        List<String> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.add(String.valueOf(c));
            } else if (c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                String openBracket = stack.get(stack.size()-1);
                if(openBracket.equals("(")) {
                    stack.remove(stack.size()-1);
                } else {
                    break;
                }
            } else if (c == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                String openBracket = stack.get(stack.size()-1);
                if(openBracket.equals("{")) {
                    stack.remove(stack.size()-1);
                } else {
                    break;
                }
            } else if (c == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                String openBracket = stack.get(stack.size()-1);
                if(openBracket.equals("[")) {
                    stack.remove(stack.size()-1);
                } else {
                    break;
                }
            }
        }

        System.out.println("Stack" + stack);

        return stack.isEmpty();
    }
}
