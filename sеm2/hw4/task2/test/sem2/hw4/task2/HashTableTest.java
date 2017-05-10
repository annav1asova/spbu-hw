package sem2.hw4.task2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/** Tests class for Hash Table*/
public class HashTableTest {

    /** size of array */
    private int arraySize = 100;
    private int array[] = new int[arraySize];

    Random r = new Random();

    /** tests hash table when first function is chosen */
    @Test
    public void testFirstHashFunction() {
        testHashTable(new HashFunction1());
    }

    /** tests hash table when second function is chosen */
    @Test
    public void testSecondHashFunction() {
        testHashTable(new HashFunction2());
    }

    /** creates random array and checks that quantity of all array's elements in hash is more than 0 */
    private void testHashTable(Hash hash) {
        HashTable<Integer> hashTable = new HashTable<>(hash);
        for (int i = 0; i < arraySize; i++) {
            array[i] = r.nextInt();
        }

        for (int i = 0; i < arraySize; i++) {
            hashTable.addToHash(array[i]);
        }

        for (int i = 0; i < arraySize; i++) {
            Assert.assertTrue(hashTable.count(array[i]) > 0);
        }
        for (int i = 0; i < arraySize; i++) {
            hashTable.removeFromHash(array[i]);
        }
        Assert.assertTrue(hashTable.amountOfWords() == 0);
    }
}