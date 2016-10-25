package kit.area.jspp.mycarrito.modelo.logics;

import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;
import kit.area.jspp.mycarrito.entities.Category;
import kit.area.jspp.mycarrito.entities.Product;
import kit.area.jspp.mycarrito.modelo.interfaces.ILogic;

/**
 * Created by PEPE on 29/09/2016.
 */

public class LCategory implements ILogic<Category> {
    private static Realm mRealm;

    public LCategory() {
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public boolean create(Category entity) {
        return false;
    }

    @Override
    public boolean delete(Category entity) {
        return false;
    }

    @Override
    public boolean update(Category entity) {
        return false;
    }
    public RealmResults<Category> toList(){
        RealmResults<Category> realmResults =  null;
        try{
            realmResults = mRealm
                    .where(Category.class)
                    .findAll();

        }catch (Exception ex){
            Log.e("Category.toList()",ex.toString());
        }
        return realmResults;
    }
    public Category toCategoryName(String name){
        Category mCategory =  null;
        try{
            mCategory = mRealm
                    .where(Category.class)
                    .equalTo("categoryname", name)
                    .findFirst();

        }catch (Exception ex){
            Log.e("toCategoryName",ex.toString());
        }
        return mCategory;
    }
}
