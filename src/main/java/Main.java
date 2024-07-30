import BlockchainPackage.Block;
import BlockchainPackage.Miner;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import static BlockchainPackage.ValidOfBlockchain.isBlockchainValid;


public class Main {

    // Create a difficulty level,
    // which specifies how many zeros will be at the beginning of the hash.
    public static final int DIFFICULTY = 5;

    public static void main(String[] args) {
        System.out.println("\nHello world!\n");

        // Create an empty blockchain.
        ArrayList<Block> myBlockchain = new ArrayList<>();


//        Block myBlock = new Block("first transaction", "5555", "2222", 13);
//        System.out.println(myBlock.getTransactionInfo());
//        System.out.println(myBlock.getNonce());

//        int difficulty = 5;
//        String target = new String(new char[difficulty]).replace("\0", "0");
//        System.out.println(target);

        // Create a Miner.
        Miner miner01 = new Miner(DIFFICULTY);


        // --------------------- 1. Transaction ---------------------
        String transaction1 = "Pavol pays Lenka 5€";
        // mine 1. block
        Block block01 = miner01.mineBlock(transaction1, "0");
        // add 1. block to blockchain
        myBlockchain.add(block01);

        // 2. transaction and block
        Block block02 = miner01.mineBlock("Bubu pays Pavol 8€", block01.getHash());
        myBlockchain.add(block02);

        // 3. transaction and block
        Block block03 = miner01.mineBlock("Lenka pays Bubu 13€", block02.getHash());
        myBlockchain.add(block03);

        // 4. transaction and block
        Block block04 = miner01.mineBlock("Pavol pays Bubu 17€", block03.getHash());
        myBlockchain.add(block04);

        // 5. transaction and block
        Block block05 = miner01.mineBlock("Bubu pays Lenka 22€", block04.getHash());
        myBlockchain.add(block05);

        // 6. transaction and block
        Block block06 = miner01.mineBlock("Lenka pays Pavol 26€", block05.getHash());
        myBlockchain.add(block06);


        // Create a JSON file of the whole blockchain.
        // Print the blockchain.
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(myBlockchain);
        System.out.println("\nBlockchain:");
        System.out.println(blockchainJson);


        // Check the validity of our blockchain.
//        block02.setTransaction("bla");
        System.out.println();
        System.out.println("Is our blockchain valid?: " + isBlockchainValid(myBlockchain, DIFFICULTY));
    }
}
