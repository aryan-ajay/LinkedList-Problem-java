import java.util.Arrays;

public class Ajay {

    // Count number of vowels, consonants, spaces in String
    public static void solve(String str) {
        int vowels = 0, consonants = 0, space = 0;
        str = str.toLowerCase();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if(ch >= 'a' && ch <= 'z'){
                consonants++;
            } else if(ch == ' ') {
                space++;
            }
        }
        System.out.println("Vowels: "+vowels);
        System.out.println("Consonants: "+consonants);
        System.out.println("Space: "+space);
    }

    //Remove all vowels from the string
    public static String removeVowels(String str) {
        String vowels = "aeiouAEIOU";

        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(vowels.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // Remove Spaces from a String    method - 1
    public static String removeSpaces(String str) {
        // Replace all spaces with empty string
        return str.replaceAll(" ", "");
    }
    // method - 2
    public static String reSpace(String str) {
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch != ' ') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    //Remove characters from a string except alphabets
    public static String Solve(String str) {
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<str.length(); i++) {
            int ascci = str.charAt(i);

            if((ascci >= 65 && ascci <= 90 ) || (ascci >= 97 && ascci <= 122)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //Remove brackets from an algebraic expression
    public static String removeBraket(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != '(' && str.charAt(i) != ')') {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //Sum of the Numbers in a String
    public static int stringSum(String str) {
        StringBuilder sb = new StringBuilder("");
        int sum = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                if(sb.length() > 0) {
                    sum += Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        if(sb.length() > 0) {
            sum += Integer.parseInt(sb.toString());
        }
        return sum;
    }

    public static String comparse(String str) {
        StringBuffer sb = new StringBuffer("");

        for(int i=0; i<str.length(); i++) {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if( count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    // chen the two string are anagrams or not
    public static void checkAnagram(String str1, String str2){
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()) {
            char[] str1charArray = str1.toCharArray();
            char[] str2CharArray = str2.toCharArray();

            Arrays.sort(str1charArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(str1charArray, str2CharArray);

            if(result) {
                System.out.println("Yes");
            } else {
                System.out.println("no");
            }
        } else {
            System.out.println("not");
        }
    }
    
    
    public static void main(String[] args) {
        String str1 = "ajay";
        String str2 = "jyaga";
        checkAnagram(str1, str2);
        
    }
}
