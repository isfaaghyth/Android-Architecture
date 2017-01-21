package app.daeng.ingetin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.daeng.ingetin.Adapter.ItemAdapter;
import app.daeng.ingetin.Interfaces.ClickedListener;
import app.daeng.ingetin.Interfaces.DataListener;
import app.daeng.ingetin.Presenter.DataProcesses;
import app.daeng.ingetin.Presenter.ItemClicked;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edt_name)
    EditText edtName;

    @BindView(R.id.btn_insert)
    Button btnInsert;

    @BindView(R.id.lst_item)
    RecyclerView lstItem;

    private DataListener presenter;
    private ClickedListener clickedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new DataProcesses(getApplicationContext());
        clickedListener = new ItemClicked(this);
        initialize();
    }

    @OnClick(R.id.btn_insert)
    public void InsertData() {
        presenter.dataAdd(edtName.getText().toString());
        initialize();
    }

    private void initialize() {
        lstItem.setLayoutManager(new LinearLayoutManager(this));
        lstItem.setAdapter(new ItemAdapter(this, clickedListener, presenter.showData()));
    }
}
