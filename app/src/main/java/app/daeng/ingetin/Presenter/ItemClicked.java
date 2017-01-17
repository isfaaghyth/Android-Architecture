package app.daeng.ingetin.Presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import app.daeng.ingetin.Interfaces.ClickedListener;
import app.daeng.ingetin.R;

/**
 * Created by isfaaghyth on 17/1/17.
 */

public class ItemClicked implements ClickedListener {

    private Context context;

    public ItemClicked(Context context) {
        this.context = context;
    }

    @Override
    public void clicked(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.select_for));
        builder.setItems(new CharSequence[]{context.getString(R.string.mn_delete), "test2"}, (dialogInterface, i) -> {
            switch (i) {
                case 0:Toast.makeText(context, "menu 1", Toast.LENGTH_SHORT).show();break;
                case 1:Toast.makeText(context, "menu 2", Toast.LENGTH_SHORT).show();break;
            }
        });
        builder.show();
    }
}
