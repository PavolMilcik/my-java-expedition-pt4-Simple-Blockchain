package BlockchainPackage;


// In this 'Block' class, we create a 'Block' object.

public class Block {

    // data about transaction
    private String transaction;
    // digital signature of previous transaction/block
    private String previousHash;
    // digital signature
    private String hash;
    // number of attempts
    private long nonce;

    public Block(String transaction, String previousHash, String hash, long nonce) {
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.hash = hash;
        this.nonce = nonce;
    }

    public String getTransaction() {
        return this.transaction;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    public String getHash() {
        return this.hash;
    }

    public long getNonce() {
        return this.nonce;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
