package registration.devalok.com.productapp.activities;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import registration.devalok.com.productapp.adapterclass.MyAdapter;
import registration.devalok.com.productapp.modelclass.Product;
import registration.devalok.com.productapp.R;

public class MainActivity extends BaseActivity {
private RecyclerView recyclerView;
private MyAdapter myAdapter;
private ArrayList arrayList;
private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
        try {
            arrayList = new ArrayList();
            for (int i = 1; i <= 20; i++) {
                Product p = new Product();
                p.setProductName("Product " + i);
                p.setProductPrice(1234 + i);
                p.setAvailability(1023 + i);
                arrayList.add(p);
            }
            myAdapter = new MyAdapter(this, arrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(myAdapter);
        } catch (Exception ex){
            Log.e(TAG," onCreate : "+ex.getMessage());
        }
    }
}
