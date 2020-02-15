package registration.devalok.com.productapp.adapterclass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import registration.devalok.com.productapp.R;
import registration.devalok.com.productapp.modelclass.Product;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private ArrayList arrayList;
    private static final String TAG = "MyAdapter";
    public MyAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            Product product = (Product) arrayList.get(position);
            holder.id_tv_productName.setText("Product Name : " + product.getProductName());
            holder.id_tv_productPrice.setText("Price : " + product.getProductPrice() + "");
            holder.id_tv_pAvailaibility.setText("Availaibility : " + product.getAvailability() + "");
        }catch (Exception ex){
            Log.e(TAG," onBindViewHolder : "+ex.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
     public TextView id_tv_productName,id_tv_productPrice,id_tv_pAvailaibility;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            try {
                this.id_tv_productName = (TextView) itemView.findViewById(R.id.id_tv_productName);
                this.id_tv_productPrice = (TextView) itemView.findViewById(R.id.id_tv_productPrice);
                this.id_tv_pAvailaibility = (TextView) itemView.findViewById(R.id.id_tv_pAvailaibility);
            }catch (Exception ex){
                Log.e(TAG," ViewHolder : "+ex.getMessage());
            }
        }
    }
}