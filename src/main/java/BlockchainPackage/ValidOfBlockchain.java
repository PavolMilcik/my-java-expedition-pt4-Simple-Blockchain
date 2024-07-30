package BlockchainPackage;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


// In this class, we check if our blockchain is valid.

public class ValidOfBlockchain {

    public static boolean isBlockchainValid(ArrayList<Block> blockchain, int DIFFICULTY) {
        if (!blockchain.isEmpty()) {

            for (int i = 0; i < blockchain.size(); i++) {
                Block block = blockchain.get(i);

                // has valid hash ---> compare hashes
                String toHash = block.getTransaction() + block.getPreviousHash() + block.getNonce();
                String expectedHash = Hashing.sha256().hashString(toHash, StandardCharsets.UTF_8).toString();
                if (!expectedHash.equals(block.getHash())) {
                    System.out.println("Block has invalid hash");
                    return false;
                }

                // block was mined/solved ---> control if first 5 chars in String are: 00000
                String expectedTarget = block.getHash().substring(0, DIFFICULTY);
                String hashTarget = new String(new char[DIFFICULTY]).replace("\0", "0");
                if (!hashTarget.equals(expectedTarget)) {
                    System.out.println("Block wasn't mined");
                    return false;
                }

                // For every block except the first compare previousHash
                if (i > 0) {
                    String expectedPreviousHash = blockchain.get(i - 1).getHash();
                    if (!block.getPreviousHash().equals(expectedPreviousHash)) {
                        System.out.println("Block has invalid previous hash");
                        return false;
                    }
                }
            }

        } else {
            System.out.println("\nEmpty blockchain!");
            return true;
        }

        return true;
    }
}
