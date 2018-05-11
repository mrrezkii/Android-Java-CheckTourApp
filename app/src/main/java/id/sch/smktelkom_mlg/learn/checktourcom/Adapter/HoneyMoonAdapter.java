package id.sch.smktelkom_mlg.learn.checktourcom.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import id.sch.smktelkom_mlg.learn.checktourcom.Model.HoneyMoonModel;
import id.sch.smktelkom_mlg.learn.checktourcom.R;

/**
 * Created by Rezki on 5/10/2018.
 */

public class HoneyMoonAdapter extends RecyclerView.Adapter<HoneyMoonAdapter.ViewHolder> {

    private List<HoneyMoonModel> mListData;
    private Context context;

    public HoneyMoonAdapter() {
        this.mListData = mListData;
        this.context = context;
    }

    @Override
    public HoneyMoonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HoneyMoonAdapter.ViewHolder holder, int position) {

        final HoneyMoonModel mData = mListData.get(position);
        holder.tvJudul.setText(mData.getDestinasi());
        holder.tvHarga.setText(mData.getHarga());
        holder.tvDeskripsi.setText(mData.getDeskripsi());
        holder.tvFasilitas.setText(mData.getFasilitas());
        holder.tvIdPacket.setText(mData.getIdPacket());
        holder.tvLokasi.setText(mData.getLokasi());


    }

    @Override
    public int getItemCount() {
        return null != mListData ? mListData.size() : 0;
    }

    private void add(HoneyMoonModel item) {
        mListData.add(item);
        notifyItemInserted(mListData.size() - 1);
    }

    public void addAll(List<HoneyMoonModel> barangList) {
        for (HoneyMoonModel honeyMoonModel : barangList) {
            add(honeyMoonModel);
        }
    }

    public void remove(HoneyMoonModel item) {
        int position = mListData.indexOf(item);
        if (position > -1) {
            mListData.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    private HoneyMoonModel getItem(int i) {
        return mListData.get(i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvJudul, tvHarga, tvDeskripsi;
        TextView tvFasilitas, tvIdPacket, tvLokasi;
        Button btnFavorite, btnShare;

        public ViewHolder(View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = itemView.findViewById(R.id.textViewDeskripsi);
            tvHarga = itemView.findViewById(R.id.textViewHarga);
            tvFasilitas = itemView.findViewById(R.id.textViewFasilitas);
            tvIdPacket = itemView.findViewById(R.id.textViewIdPacket);
            tvLokasi = itemView.findViewById(R.id.textViewLokasi);
            btnFavorite = itemView.findViewById(R.id.buttonFavorite);
            btnShare = itemView.findViewById(R.id.buttonShare);


        }
    }
}
