import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Block {
    private long timestamp;
    private byte[] data;
    private byte[] prevBlockHash;
    private byte[] hash;

    private Block(long timestamp, byte[] data, byte[] prevBlockHash, byte[] hash) {
        this.timestamp = timestamp;
        this.data = data;
        this.prevBlockHash = prevBlockHash;
        this.hash = hash;
    }

    public static Block newBlock(String data, byte[] prevBlockHash) throws NoSuchAlgorithmException {
        Block block = new Block(new Date().getTime(), data.getBytes(), prevBlockHash, null);
        block.SetHash();
        return block;
    }

    private void SetHash() throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String concat;
        if (this.prevBlockHash == null) {
            concat = new String(this.data, StandardCharsets.UTF_8) + this.timestamp;
        } else {
            concat = new String(this.data, StandardCharsets.UTF_8) + new String(this.prevBlockHash, StandardCharsets.UTF_8) + this.timestamp;
        }
        this.hash = digest.digest(concat.getBytes());
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getPrevBlockHash() {
        return prevBlockHash;
    }

    public void setPrevBlockHash(byte[] prevBlockHash) {
        this.prevBlockHash = prevBlockHash;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }
}
