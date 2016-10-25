package kit.area.jspp.mycarrito.modelo.logics;

import android.content.Entity;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.internal.async.QueryUpdateTask;
import kit.area.jspp.mycarrito.entities.Category;
import kit.area.jspp.mycarrito.entities.Product;
import kit.area.jspp.mycarrito.modelo.interfaces.IBaseLogic;
import kit.area.jspp.mycarrito.modelo.interfaces.ILogic;

/**
 * Created by PEPE on 19/09/2016.
 */

public class LProduct implements ILogic<Product> {
    private static Realm mRealm;

    public LProduct(){
        mRealm = Realm.getDefaultInstance();
    }
    public RealmResults<Product> toListDeseado(){
        RealmResults<Product> realmResults =  null;
        try{
            realmResults = mRealm.where(Product.class)
                    .equalTo("isdeseado",true)
                    .findAll();

        }catch (Exception ex){
            Log.e("toListDeseado",ex.toString());
        }
        return realmResults;
    }
    public Product toID(Long mID){
        Product realmResults =  null;
        try{
            realmResults = mRealm.where(Product.class)
                    .equalTo("idproduct",mID)
                    .findFirst();

        }catch (Exception ex){
            Log.e("toCategory",ex.toString());
        }
        return realmResults;
    }

    public RealmResults<Product> toCategory(String mCategory){
        RealmResults<Product> realmResults =  null;
        try{
            realmResults = mRealm.where(Product.class)
                    .equalTo("category.categoryname",mCategory)
                    .findAll();

        }catch (Exception ex){
            Log.e("toCategory",ex.toString());
        }
        return realmResults;
    }

    public RealmResults<Product> toList(){
        RealmResults<Product> realmResults =  null;
        try{
            realmResults = mRealm
                            .where(Product.class)
                            .findAll();

        }catch (Exception ex){
            Log.e("LProducto.toList()",ex.toString());
        }
        return realmResults;
    }

    @Override
    public boolean create(Product entity) {
        boolean mResult = true;
        try {
            mRealm.beginTransaction();
            Product product = mRealm.createObject(Product.class);
            product.setIdproduct(Product.getGenerateId());
            product.setProductname(entity.getProductname());
            product.setProductmodel(entity.getProductmodel());
            product.setCodebar(entity.getCodebar());
            product.setPrice(entity.getPrice());
            product.setProductdetail(entity.getProductdetail());
            product.setRanking(entity.getRanking());
            product.setCategory(entity.getCategory());
            product.setStock(entity.getStock());
            product.setNumberview(entity.getNumberview());
            product.setUrlimage(entity.getUrlimage());
            mRealm.commitTransaction();
        }catch (Exception ex){
            Log.e("LProducto.create()",ex.toString());
            mResult = false;
        }
        return mResult;

    }

    @Override
    public boolean delete(Product entity) {
        boolean mResult = true;
        try {

        }catch (Exception ex){

        }
        return mResult;
    }

    @Override
    public boolean update(Product entity) {
        return false;
    }

    public boolean setProductDeseado(final Product entity) {
        boolean mResult = true;
        try{
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Product product = realm.where(Product.class).equalTo("idproduct", entity.getIdproduct()).findFirst();
                    product.setDeseado(true);

                }
            });
            }
        catch (Exception ex){
            mResult = false;
        }

        return mResult;
    }
}
