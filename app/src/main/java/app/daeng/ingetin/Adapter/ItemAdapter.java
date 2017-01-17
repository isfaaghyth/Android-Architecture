package app.daeng.ingetin.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.daeng.ingetin.Interfaces.ClickedListener;
import app.daeng.ingetin.Models.DataItemModel;
import app.daeng.ingetin.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isfaaghyth on 15/1/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    Context context;
    List<DataItemModel> dataItems;
    ClickedListener clickedListener;

    public ItemAdapter(Context context, ClickedListener clickedListener, List<DataItemModel> dataItems) {
        this.clickedListener = clickedListener;
        this.context = context;
        this.dataItems = dataItems;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, final int position) {
        holder.txtName.setText(dataItems.get(position).getName());
        holder.txtId.setText(String.valueOf(dataItems.get(position).getId()));
        holder.cardItem.setOnClickListener(view -> clickedListener.clicked(dataItems.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_item)
        CardView cardItem;

        @BindView(R.id.txt_id)
        TextView txtId;

        @BindView(R.id.txt_name)
        TextView txtName;

        ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
