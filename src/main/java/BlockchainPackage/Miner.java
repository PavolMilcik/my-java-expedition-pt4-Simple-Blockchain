package BlockchainPackage;


// In this 'Miner' class, we create a 'Miner' object.

// Here we have a method for mining a block, which creates a complete 'block' of transaction.
// This method returns a new object of type/class 'Block'.

public class Miner {

    // Create a difficulty level,
    // how many zeros will be at the beginning of the hash.
    private int difficulty;
    // In the constructor, we create a String target from the difficulty.
    private String target;

    public Miner(int difficulty) {
        this.difficulty = difficulty;

        // Create a string of '0's of size equal to the difficulty,
        // (e.g., if difficulty is 5, the String target will be '00000').
        this.target = new String(new char[difficulty]).replace("\0", "0");
    }

    public Block mineBlock(String transaction, String previousHash) {
        System.out.println("\nMining block... ");

        long nonce = 0;
        String hash = Hasher.calculateHash(transaction, previousHash, nonce);

        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = Hasher.calculateHash(transaction, previousHash, nonce);
        }

        System.out.println("Yes. I mined a block at " + nonce + " attempt! Hash: " + hash);
        System.out.println();

        return new Block(transaction, previousHash, hash, nonce);
    }
}
