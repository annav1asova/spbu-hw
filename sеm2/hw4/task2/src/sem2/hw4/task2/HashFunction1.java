package sem2.hw4.task2;

/** Class for first Hash Function - H37 */
public class HashFunction1 implements Hash {

    public int hashNumber(String value, int hashSize) {
        long hashNumber = 2139062143;

        for (int i = 0; i < value.length(); i++)
        {
            hashNumber = (37 * hashNumber + value.charAt(i)) % hashSize;
        }

        return (int)(hashNumber % hashSize);
    }
}
