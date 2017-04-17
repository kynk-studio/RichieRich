/*
 * Copyright © 2017 Naveen Kumar
 *
 * This file is part of Richie Rich.
 *
 *     Richie Rich is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Richie Rich is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Richie Rich.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package studio.kynk.richierich;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.menu_share:
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_SUBJECT, "Richie Rich");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "I bought Richie Rich app from play store, this app is cool! " +
                        "Link : https://play.google.com/store/apps/details?id=studio.kynk.richierich");
                startActivity(Intent.createChooser(i, "Share via"));
        }
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        mAdapter = new RVAdapter(mCard);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
