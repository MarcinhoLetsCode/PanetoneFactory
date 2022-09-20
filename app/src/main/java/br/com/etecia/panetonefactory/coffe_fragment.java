package br.com.etecia.panetonefactory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class coffe_fragment extends Fragment {
    RecyclerView recyclerView;
    List<Products> cafeLista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffe_bottom, container, false);

        recyclerView = view.findViewById(R.id.rvCoffe);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.hasFixedSize();

        cafeLista = new ArrayList<>();
        cafeLista.add(new Products("Café Preto"));
        cafeLista.add(new Products("Café Branco"));
        cafeLista.add(new Products("Café Verde"));
        cafeLista.add(new Products("Café Vermelho"));

        CoffeAdapter coffeAdapter = new CoffeAdapter(getContext(), cafeLista);
        recyclerView.setAdapter(coffeAdapter);

        return view;
    }

    public class CoffeAdapter extends RecyclerView.Adapter<CoffeAdapter.ViewHolder> {
        List<Products> cafeLista;
        Context context;

        public CoffeAdapter(Context context, List<Products> cafeLista) {
            this.context = context;
            this.cafeLista = cafeLista;
        }

        public CoffeAdapter() {}

        @NonNull
        @Override
        public CoffeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.modelo_teste, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CoffeAdapter.ViewHolder holder, int position) {
            holder.textView.setText(cafeLista.get(position).getCafe());
            holder.cardProducts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    intent.putExtra("Produto", cafeLista.get(holder.getAdapterPosition()).getCafe());
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    Toast.makeText(context, cafeLista.get(holder.getAdapterPosition()).getCafe(), Toast.LENGTH_SHORT).show();
                    coffe_fragment.this.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return cafeLista.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            LinearLayout cardProducts;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.txtNome);
                cardProducts = itemView.findViewById(R.id.llcardProducts);
            }
        }
    }
}