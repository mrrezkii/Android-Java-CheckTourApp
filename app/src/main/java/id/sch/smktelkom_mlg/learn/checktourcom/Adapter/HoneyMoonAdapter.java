package id.sch.smktelkom_mlg.learn.checktourcom.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.learn.checktourcom.DetailActivity;
import id.sch.smktelkom_mlg.learn.checktourcom.Model.HoneyMoonModel;
import id.sch.smktelkom_mlg.learn.checktourcom.R;

/**
 * Created by Rezki on 5/10/2018.
 */

public class HoneyMoonAdapter extends RecyclerView.Adapter<HoneyMoonAdapter.ViewHolder> {

    private List<HoneyMoonModel> mListData;
    private Context context;

    public HoneyMoonAdapter(Context context) {
        mListData = new ArrayList<>();
        this.context = context;
    }

    @Override
    public HoneyMoonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final HoneyMoonAdapter.ViewHolder holder, int position) {

        final HoneyMoonModel mData = mListData.get(position);
        holder.tvJudul.setText(mData.getDestinasi());
        holder.tvHarga.setText(mData.getHarga());
        holder.tvDeskripsi.setText(mData.getDeskripsi());
        holder.tvFasilitas.setText(mData.getFasilitas());
        holder.tvIdPacket.setText(mData.getIDPacket());
        holder.tvLokasi.setText(mData.getLokasi());
        Glide.with(context)
                .load(mData.getUrl())
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tvJudul = holder.tvJudul.getText().toString();
                String tvHarga = holder.tvHarga.getText().toString();
                String tvDeskripsi = holder.tvDeskripsi.getText().toString();
                String tvFasilitas = holder.tvFasilitas.getText().toString();
                String tvIdPacket = holder.tvIdPacket.getText().toString();
                String tvLokasi = holder.tvLokasi.getText().toString();
                String ivUrl = mData.getUrl();

                Intent detailIntent = new Intent(view.getContext(), DetailActivity.class);

                detailIntent.putExtra("Destinasi", tvJudul);
                detailIntent.putExtra("Harga", tvHarga);
                detailIntent.putExtra("Deskripsi", tvDeskripsi);
                detailIntent.putExtra("Fasilitas", tvFasilitas);
                detailIntent.putExtra("IDPacket", tvIdPacket);
                detailIntent.putExtra("Lokasi", tvLokasi);
                detailIntent.putExtra("url", ivUrl);
                view.getContext().startActivity(detailIntent);
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Check out this '" + mData.getDestinasi() + "' in CheckTourApps");
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });

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

    private HoneyMoonModel getItem(int position) {
        return mListData.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvJudul, tvHarga, tvDeskripsi;
        TextView tvFasilitas, tvIdPacket, tvLokasi;
        ImageButton btnFavorite, btnShare;
        ImageView ivFoto;

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
            ivFoto = itemView.findViewById(R.id.imageView);


        }
    }
}
