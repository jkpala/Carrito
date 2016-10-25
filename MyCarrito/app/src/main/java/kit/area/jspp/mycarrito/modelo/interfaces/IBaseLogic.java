package kit.area.jspp.mycarrito.modelo.interfaces;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by PEPE on 19/09/2016.
 */

public interface IBaseLogic<T> {
    boolean create(T entity);
    boolean delete(T entity);
    boolean update(T entity);

}
