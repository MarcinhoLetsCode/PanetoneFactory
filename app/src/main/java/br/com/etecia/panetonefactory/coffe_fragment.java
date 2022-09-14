package br.com.etecia.panetonefactory;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        cafeLista = new ArrayList<>();
        cafeLista.add(new Coffe("Café Preto"));

        CoffeAdapter coffeAdapter = new CoffeAdapter( getContext(), cafeLista);
        recyclerView.setAdapter(coffeAdapter);

        return view;
    }

    private class CoffeAdapter extends RecyclerView.Adapter<CoffeAdapter.ViewHolder> {
        public CoffeAdapter(Context context, List<Coffe> cafeLista) {
        }

        @NonNull
        @Override
        public CoffeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull CoffeAdapter.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}