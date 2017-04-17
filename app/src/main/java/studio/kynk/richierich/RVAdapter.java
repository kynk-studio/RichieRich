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

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{
    private List<CardModel> cardList;
    private MaterialDialog.Builder build;
    //Provide a suitable constructor
    public RVAdapter(List<CardModel> cardList){
        this.cardList = cardList;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);

        //set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(final RVAdapter.ViewHolder holder, final int position) {
        final CardModel mCard = cardList.get(position);
        holder.textView.setText(mCard.getText());
        holder.subText.setText(mCard.getText2());
        holder.ivImageCover.setImageResource(mCard.getPic());
        holder.ivText.setImageDrawable(mCard.getPic2(position));
        holder.acb.setBackgroundColor(mCard.getColor(position));
        holder.acb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(v.getContext())
                        .title(mCard.getText())
                        .content(R.string.get_free)
                        .positiveColorRes(mCard.getColor(holder.getAdapterPosition()))
                        .positiveFocus(true)
                        .positiveText("EXIT")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView textView, subText;
        public ImageView ivImageCover, ivText;
        public AppCompatButton acb;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
            subText = (TextView) v.findViewById(R.id.sub_text);
            ivImageCover = (ImageView) v.findViewById(R.id.iv_image_cover);
            ivText = (ImageView) v.findViewById(R.id.img_head);
            acb = (AppCompatButton) v.findViewById(R.id.get_it);
        }
    }
}

