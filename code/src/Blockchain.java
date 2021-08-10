import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> blocks;

    public Blockchain newBlockchain() throws NoSuchAlgorithmException {
        blocks = new ArrayList<>();
        this.blocks.add(newGenesisBlock());
        return this;
    }

    public void addBlock(String data) throws NoSuchAlgorithmException {
        Block prevBlock = blocks.get(blocks.size() - 1);
        Block newBlock = Block.newBlock(data, prevBlock.getHash());
        this.blocks.add(newBlock);
    }

    private Block newGenesisBlock() throws NoSuchAlgorithmException {
        return Block.newBlock("Genesis Block", null);
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
