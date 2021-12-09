package final123;

public class Category {
    private String catCode;
    private String catDesc;

    public Category(String catCode, String catDesc) {
        this.catCode = catCode;
        this.catDesc = catDesc;
    }

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }
}