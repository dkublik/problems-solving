package pl.dk.problems;

/**
 * we have 2 strings, like "BATD" and "ABACD",
 * and need to find common largest sequence
 * in this case = "BA"
 */
public class LargestCommonSequence {

    String findBruteforce(String s1, String s2) {
        String maxSequence = "";
        for (int i = 0; i < s1.length(); i++) {
            for (int seqLength = 1; seqLength + i < s1.length() ; seqLength++) {
                String sequence = s1.substring(i, i + seqLength);
                if (!s2.contains(sequence)) {
                    break;
                }
                if (sequence.length() > maxSequence.length()) {
                    maxSequence = sequence;
                }
            }
        }
        return maxSequence;
    }

    public static void main(String[] args) {
        String s1 = "BATD";
        String s2 = "ABACD";
        String longestSequence = new LargestCommonSequence().findBruteforce(s1, s2);
        System.out.println("longest sequence: " + longestSequence);
    }

}
