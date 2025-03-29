package vn.iostar.tuan8.BT.RecyclerViewIndicator;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.iostar.tuan8.BT.RecyclerViewIndicator.Adapter.IconAdapter;
import vn.iostar.tuan8.BT.RecyclerViewIndicator.Decoration.LinePagerIndicatorDecoration;
import vn.iostar.tuan8.BT.RecyclerViewIndicator.Model.IconModel;
import vn.iostar.tuan8.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcIcon;
    private IconAdapter iconAdapter;
    private List<IconModel> arrayList1;
    private SearchView searchView;  // Đã khai báo đúng SearchView của AndroidX

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rcIcon = findViewById(R.id.rcIcon);
        searchView = findViewById(R.id.searchView);  // Sửa lỗi: Không khai báo lại SearchView

        if (searchView != null) {
            searchView.clearFocus();
        } else {
            Log.e("MainActivity", "SearchView is null");
        }

        arrayList1 = new ArrayList<>();
        arrayList1.add(new IconModel(R.drawable.icon2, "jdfdjdfj dfjdh"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon2, "sdfdf sfdsf"));
        arrayList1.add(new IconModel(R.drawable.icon2, "dfghgy sfdxf"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,
                GridLayoutManager.HORIZONTAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);

        iconAdapter = new IconAdapter(getApplicationContext(), arrayList1);
        rcIcon.setAdapter(iconAdapter);

        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });
    }

    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        for (IconModel iconModel : arrayList1) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                list.add(iconModel);
            }
        }

        if (list.isEmpty()) {
            Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListenerList(list);
        }
    }
}
