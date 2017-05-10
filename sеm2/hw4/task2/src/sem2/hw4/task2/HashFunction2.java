package sem2.hw4.task2;

/** Class for second Hash Function - LY */
public class HashFunction2 implements Hash {

    public int hashNumber(String value, int hashSize) {
        long hashNumber = 0;

        for (int i = 0; i < value.length(); i++)
        {
            hashNumber = ((hashNumber * 1664525) + (char)(value.charAt(i)) + 1013904223) % hashSize;
        }

        return (int)(hashNumber % hashSize);
    }
}
