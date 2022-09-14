package br.com.etecia.panetonefactory;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class coffe_fragment extends Fragment {
    RecyclerView recyclerView;
    List<Coffe> cafeLista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffe_bottom, container, false);

        recyclerView = view.findViewById(R.id.rvCoffe);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.hasFixedSize();

        cafeLista = new ArrayList<>();
        cafeLista.add(new Coffe("Café Preto"));
        cafeLista.add(new Coffe("Café Branco"));
        cafeLista.add(new Coffe("Café Verde"));
        cafeLista.add(new Coffe("Café Vermelho"));

        CoffeAdapter coffeAdapter = new CoffeAdapter(getContext(), cafeLista);
        recyclerView.setAdapter(coffeAdapter);

        return view;
    }

    public class CoffeAdapter extends RecyclerView.Adapter<CoffeAdapter.ViewHolder> {
        List<Coffe> cafeLista;
        Context context;

        public CoffeAdapter(Context context, List<Coffe> cafeLista) {
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
        }

        @Override
        public int getItemCount() {
            return cafeLista.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.txtNome);
            }
        }
    }
}