package sem2.hw4.task2;

/** Class for HashTable */
public class HashTable<T extends Comparable>  {

    public int hashSize = 10;
    public UniqueList<T>[] hashTable = new UniqueList[hashSize];
    private Hash hash;

    public HashTable(Hash hash) {
        for (int i = 0; i < hashSize; i++) {
            hashTable[i] = new UniqueList<T>();
        }
        this.hash = hash;
    };

    /**
     * @param value
     * @return hash number for given value
     */
    int hash(T value) {
        String valueString = value.toString();
        return hash.hashNumber(valueString, hashSize);
    }

    /**
     * method that adds an element to hash table.
     *
     * @param value element to be added has this value
     */
    void addToHash(T value) {
        int hashNumber = hash(value);
        hashTable[hashNumber].add(value);
    }

    /**
     * method that removes an element from hash table.
     *
     * @param value element to be deleted has this value
     */
    void removeFromHash(T value) {
        int hashNumber = hash(value);
        hashTable[hashNumber].remove(value);
    }

    /**
     * method that counts amount of different words in hash table.
     *
     * @return amount of different words in hash table
     */
    double amountOfWords() {
        double numberOfWords = 0;
        for (int i = 0; i < hashSize; i++) {
            numberOfWords += hashTable[i].size();
        }
        return numberOfWords;
    }

    /**
     * method that counts load factor of hash table.
     *
     * @return load factor
     */
    double loadFactor() {
        return (double)(amountOfWords() / hashSize);
    }

    /**
     * method that counts max length of chain and returns it.
     *
     * @return max length of chain
     */
    int maxChainLength() {
        int max = 0;
        for (int i = 0; i < hashSize; i++)
        {
            if (hashTable[i].size() > max)
                max = hashTable[i].size();
        }
        return max;
    }

    /**
     * method that counts average length of chain.
     *
     * @return average length
     */
    double averageNotEmptyChain() {
        double averageLength = 0;
        int notEmptyChains = 0;
        for (int i = 0; i < hashSize; i++)
        {
            int tempSize = hashTable[i].size();
            if (tempSize != 0)
            {
                averageLength += hashTable[i].size();
                notEmptyChains++;
            }
        }
        return (double)(averageLength / notEmptyChains);
    }

    /**
     * method that counts the number of conflicts.
     *
     * @return number of conflicts in hash table
     */
    int conflicts() {
        int number = 0;
        for (int i = 0; i < hashSize; i++)
        {
            if (hashTable[i].size() > 1)
                number++;
        }
        return number;
    }

    /**
     * method that counts the quantity of given element.
     *
     * @param value element
     * @return quantity of this element
     */
    int count(T value) {
        int hashNumber = hash(value);
        int result = hashTable[hashNumber].quantity(value);
        return result;
    }

    /** method that prints statistics of hash table */
    void getStatistics() {
        System.out.println("Size: " + hashSize);
        System.out.println("load factor: " + loadFactor());
        System.out.println("number of conflicts: " + conflicts());
        System.out.println("max chain length: " + maxChainLength());
    }
}
