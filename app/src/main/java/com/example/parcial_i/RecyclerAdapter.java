package com.example.parcial_i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Producto> mData;
    private LayoutInflater mInflater;
    private Context context;

    public RecyclerAdapter(List<Producto> itemlist, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemlist;

    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item,null);
        return new RecyclerAdapter.ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems(List<Producto> items){
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre,descripcion,precio;

        ViewHolder(View itemView){
            super(itemView);
            nombre = itemView.findViewById(R.id.text_nombre);
            descripcion = itemView.findViewById(R.id.text_descrip);
            precio = itemView.findViewById(R.id.text_precio);
        }


        void bindData(final Producto item){
            nombre.setText(item.getNombre());
            descripcion.setText(item.getDescripcion());
            precio.setText(item.getPrecio());

        }
    }
}
