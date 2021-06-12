package com.example.seccion_02;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;
    private int img;

    public MyAdapter(Context context , int layout, List<String> names, int img) {
        this.context = context;
        this.layout = layout;
        this.names = names;
        this.img = img;
    }

    @Override
    public int getCount() {
        // Retornas los elementos del List
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        // Retorna el item que este en la posicion
        return this.names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        // View holder Pattern
        ViewHolder holder;

        if (convertView == null) {
            // Inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            // Referenciamos el elemento a modificar y lo rellenamos
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Traemos el valor actual dependiente de la posicion
        String currentName = names.get(position);

        // Referiamos el elemento a modificar y lo rellenamos
        holder.nameTextView.setText(currentName);
        holder.imageView.setImageResource(img);

        // Devolvemos la vista inflada y modificada con nuestros datos
        return convertView;

        // --- Forma no recomendada ---

        // Copiamos la vista
//        View v = convertView;

        // Inflamos la vista que nos ha llegado con nuestro layout personalizado
//        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
//        v = layoutInflater.inflate(this.layout, null);

        // Nos traemos el valor actual dependiente de la posicion.
//        String currentName = names.get(position);
        // currentName = (String) getItem(position);

        // Referenciamos el elemento a modificar y lo rellenamos
//        TextView textView = (TextView) v.findViewById(R.id.textView);
//        textView.setText(currentName);
//        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
//        imageView.setImageResource(this.img);

        // Devolvemos inflada y modificada con nuestros datos
//        return v;
    }

    static class ViewHolder {
        private TextView nameTextView;
        private ImageView imageView;
    }
}
