package kit.area.jspp.mycarrito.modelo.logics;

import io.realm.Realm;
import kit.area.jspp.mycarrito.entities.User;
import kit.area.jspp.mycarrito.modelo.interfaces.ILogic;

/**
 * Created by PEPE on 24/09/2016.
 */

public class LUser implements ILogic<User> {
    @Override
    public boolean create(User entity) {
        boolean Result = false;
        Realm realm = Realm.getDefaultInstance();
        //realm.executeTransaction(new Realm.Transaction() {
        //    @Override
        //    public void execute(Realm realm) {

        //    }
        //});
        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setId(entity.getId());
        user.setEmail(entity.getEmail());
        user.setFirstName(entity.getFirstName());
        user.setLastName(entity.getLastName());
        user.setBirthday(entity.getBirthday());
        //user.setLink(user.getLink());
        realm.commitTransaction();
        Result = true;
        return Result;
    }

    @Override
    public boolean delete(User entity) {
        boolean Result = false;
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(User.class);
        realm.commitTransaction();
        Result = true;
        return Result;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    public User obtenerSession(){
        Realm realm = Realm.getDefaultInstance();
        return realm.where(User.class).findFirst();
    }
}
