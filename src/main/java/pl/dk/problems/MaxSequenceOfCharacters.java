package pl.dk.problems;

/**
 * find max sesquence of characters in string
 * eg. in "AABCDDBBBEA" => "BBB"
 */
public class MaxSequenceOfCharacters {

    String maxSubSequence(String sequence) {
        char maxCharacter = sequence.charAt(0);
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == sequence.charAt(i - 1)) {
                currentLength ++;

            } else {
                currentLength = 1;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxCharacter = sequence.charAt(i - 1);
            }
        }
        String maxSubSequence = "";
        while (maxLength > 0) {
            maxSubSequence += maxCharacter;
            maxLength--;
        }
        return maxSubSequence;
    }

    public static void main(String[] args) {
        String sequence = "AABCDDBBBEA";
        String maxSubSequence = new MaxSequenceOfCharacters().maxSubSequence(sequence);
        System.out.println("maxSubSequence: " + maxSubSequence);
    }

}
