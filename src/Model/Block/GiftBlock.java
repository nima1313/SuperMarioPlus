package Model.Block;

public class GiftBlock extends Block{

    //TODO : do it all :))
    private String itemName;

    public GiftBlock(int upperLeftX, int upperLeftY, String item) {
        super(upperLeftX, upperLeftY);
        setItemName(item);

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
