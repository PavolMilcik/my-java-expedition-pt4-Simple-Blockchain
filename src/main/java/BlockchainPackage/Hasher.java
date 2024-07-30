package BlockchainPackage;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;


// In this 'Hasher' class, we have a method that creates a hash number.

// new hash = transaction + previousHash + X(nonce)

// X is a nonce number that starts from 0.
// It represents the number of attempts to find the difficulty level set by us.

public class Hasher {

    public static String calculateHash(String transaction, String previousHash, long nonce) {
        String toHash = transaction + previousHash + nonce;
        return Hashing.sha256().hashString(toHash, StandardCharsets.UTF_8).toString();
    }
}
