package app.daeng.ingetin.Presenter;

import android.content.Context;

import java.util.ArrayList;

import app.daeng.ingetin.Interfaces.DataListener;
import app.daeng.ingetin.Models.DataItemModel;
import app.daeng.ingetin.Presenter.Realm.HelperRealm;

/**
 * Created by isfaaghyth on 15/1/17.
 */

public class DataProcesses implements DataListener {

    private HelperRealm helperRealm;

    public DataProcesses(Context context) {
        helperRealm = new HelperRealm(context);
    }

    @Override
    public void dataAdd(String name) {
        helperRealm.add(name);
    }

    @Override
    public void dataDelete(int id) {
        helperRealm.delete(id);
    }

    @Override
    public void dataModify(int id, String name) {
        helperRealm.modify(id, name);
    }

    @Override
    public ArrayList<DataItemModel> showData() {
        return helperRealm.show();
    }

}
