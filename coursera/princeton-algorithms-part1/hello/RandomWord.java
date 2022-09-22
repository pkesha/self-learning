import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/*
 *Using algs4.jar. Under construction. Write a program RandomWord.java that
 * reads a sequence of words from standard input and prints one of those words
 * uniformly at random. Do not store the words in an array or list.
 * Instead, use Knuth’s method: when reading the ith word, select it with
 * probability 1/i to be the champion, replacing the previous champion.
 * After reading call of the words, print the surviving champion.
 */
public class RandomWord {
    public static void main(String[] args) {
        int numberOfWords = 1;
        String champion = null;
        while (!StdIn.isEmpty()) {
            String contender = StdIn.readString();

            if (StdRandom.bernoulli(1 / (double) numberOfWords)) {
                champion = contender;
            }
            else {
                continue;
            }
            numberOfWords++;
        }
        System.out.println(champion);
    }
}