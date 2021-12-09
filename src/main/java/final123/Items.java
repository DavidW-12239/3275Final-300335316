package final123;


public class Items {
    private String itemCode;
    private String itemDesc;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Items(String itemCode, String itemDesc) {
        this.itemCode = itemCode;
        this.itemDesc = itemDesc;
    }
}
