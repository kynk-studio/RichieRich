package studio.kynk.richierich;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>{
    private List<CardModel> cardList;

    //Provide a reference to the views for each data item
    //Complex data items may need more than one view per item, and
    //you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
        public TextView textView, subText;
        public ImageView ivImageCover, ivText;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView) ;
            subText = (TextView) v.findViewById(R.id.sub_text) ;
            ivImageCover = (ImageView) v.findViewById(R.id.iv_image_cover);
            ivText = (ImageView) v.findViewById(R.id.img_head);
        }
    }

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
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {
        CardModel mCard = cardList.get(position);
        holder.textView.setText(mCard.getText());
        holder.subText.setText(mCard.getText2());
        holder.ivImageCover.setImageResource(mCard.getPic());
        holder.ivText.setImageDrawable(mCard.getPic2(position));
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}

