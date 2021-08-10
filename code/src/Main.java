import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Blockchain blockchain = new Blockchain().newBlockchain();

        blockchain.addBlock("Send 1 BTC to Ivan");
        blockchain.addBlock("Send 2 more BTC to Ivan");

        blockchain.getBlocks().forEach(b -> {
            if (b.getPrevBlockHash() == null) {
                System.out.println("Prev. hash: ");
            } else {
                System.out.format("Prev. hash: %s\n", Utils.bytesToHex(b.getPrevBlockHash()));
            }
            System.out.println("Data: " + new String(b.getData(), StandardCharsets.UTF_8));
            System.out.println("Hash: " + Utils.bytesToHex(b.getHash()));
            System.out.println();
        });
    }
}
