package kit.area.jspp.mycarrito.entities;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by PEPE on 12/09/2016.
 */
public class Category extends RealmObject {

    @PrimaryKey
    private long id;
    private String categoryname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public static  int  getGenerateId(){

        Realm  realm = Realm.getDefaultInstance();

        Number numberId = realm.where(Category.class).max("id");

        return numberId == null ? 1 : numberId.intValue() + 1 ;
    }
}
