package app.daeng.ingetin.Interfaces;

import java.util.ArrayList;

import app.daeng.ingetin.Models.DataItemModel;

/**
 * Created by isfaaghyth on 15/1/17.
 */

public interface DataListener {
    /*
     * Add a new data.
     * @param id
     * @param name
     */
    void dataAdd(String name);

    /*
     * Delete by Id
     * @param id
     */
    void dataDelete(int id);

    /*
     * Modify by Id and modify a new data
     * @param id
     * @param name
     */
    void dataModify(int id, String name);

    /*
     * show all data
     */
    ArrayList<DataItemModel> showData();
}
