package app.daeng.ingetin.Presenter.Realm;

import android.content.Context;

import java.util.ArrayList;

import app.daeng.ingetin.Models.DataItemModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by isfaaghyth on 15/1/17.
 */

public class HelperRealm {
    private Realm realm;
    private RealmResults<DataRealm> realmResults;
    private Context context;

    /*
     * Constructor
     * @param context
     */
    public HelperRealm(Context context) {
        Realm.init(context);
        this.context = context;
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);
    }

    /*
     * get size
     */
    private int getCount() {
        realmResults = realm.where(DataRealm.class).findAll();
        realmResults.sort("id");
        return realmResults.size();
    }

    public ArrayList<DataItemModel> show() {
        int id;
        String name;
        ArrayList<DataItemModel> data = new ArrayList<>();

        realmResults = realm.where(DataRealm.class).findAll();
        realmResults.sort("id");

        if (realmResults.size() > 0) {
            for (int i = 0; i < realmResults.size(); i++) {
                id = realmResults.get(i).getId();
                name = realmResults.get(i).getName();
                data.add(new DataItemModel(id, name));
            }
        }

        return data;
    }

    /*
     * Add a new data
     * @param name
     */
    public void add(String name) {
        DataRealm data = new DataRealm();
        data.setId(getCount() + 1);
        data.setName(name);

        realm.beginTransaction();
        realm.copyToRealm(data);
        realm.commitTransaction();
    }

    /*
     * Delete by id
     * @param id
     */
    public void delete(int id) {
        RealmResults<DataRealm> dataRealms = realm.where(DataRealm.class).equalTo("id", id).findAll();
        realm.beginTransaction();
        dataRealms.remove(0);
//        dataRealms.removeLast();
        dataRealms.clear();
        realm.commitTransaction();
    }

    /*
     * Modify by Id with a new data
     * @param id
     * @param name
     */
    public void modify(int id, String name) {
        realm.beginTransaction();
        DataRealm dataRealm = realm.where(DataRealm.class).equalTo("id", id).findFirst();
        dataRealm.setName(name);
        realm.commitTransaction();
    }
}
