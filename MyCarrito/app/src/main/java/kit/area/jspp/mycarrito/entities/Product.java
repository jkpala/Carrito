package kit.area.jspp.mycarrito.entities;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by PEPE on 13/09/2016.
 */
public class Product extends RealmObject {
    @PrimaryKey
    private long idproduct;
    private String codebar;
    private String productname;
    private String productdetail;
    private String productmodel;
    private int numberview;
    private int stock;
    private double price;
    private double ranking;
    private String urlimage;
    private Category category;
    private boolean isdeseado = false;

    public boolean getDeseado() {
        return isdeseado;
    }

    public void setDeseado(boolean isdeseado) {
        this.isdeseado = isdeseado;
    }

    public String getCodebar() {
        return codebar;
    }

    public void setCodebar(String codebar) {
        this.codebar = codebar;
    }
    public long getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(long idproduct) {
        this.idproduct = idproduct;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(String productdetail) {
        this.productdetail = productdetail;
    }

    public String getProductmodel() {
        return productmodel;
    }

    public void setProductmodel(String productmodel) {
        this.productmodel = productmodel;
    }

    public int getNumberview() {
        return numberview;
    }

    public void setNumberview(int numberview) {
        this.numberview = numberview;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static  int  getGenerateId(){

        Realm realm = Realm.getDefaultInstance();

        Number numberId = realm.where(Product.class).max("idproduct");

        return numberId == null ? 1 : numberId.intValue() + 1 ;
    }
}
