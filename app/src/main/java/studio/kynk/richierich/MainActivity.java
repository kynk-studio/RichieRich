package studio.kynk.richierich;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RVAdapter mAdapter;
    private List<CardModel> mCard;
    private RecyclerView.LayoutManager mLayoutManager;

    private int pics[] ={
            R.drawable.usd_2,
            R.drawable.usd_5,
            R.drawable.usd_10,
            R.drawable.usd_50,
            R.drawable.usd_10000
    };

    private String Text[] = {"$ 2", "$ 5", "$ 10", "$ 50", "$ 10k"};

    private String text[] = {"$ 2", "$ 5", "$ 10", "$ 50", "$ 10000"};

    private String text2[] = {"Get free USD 2", "Get free USD 5", "Get free USD 10",
    "Get free USD 50", "Get free USD 10000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        
        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }

        mCard = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            CardModel card = new CardModel(text[i], text2[i], pics[i]);
            mCard.add(card);
        }

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_money:

                        return true;
                    case R.id.navigation_balance:
                        return true;
                    case R.id.nav_settings:
                        return true;
                }
                return false;
            }
        });
        mAdapter = new RVAdapter(mCard);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
