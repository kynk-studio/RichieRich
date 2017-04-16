package studio.kynk.richierich;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

/**
 * Created by Naveen Kumar (kynkstduio).
 */

public class CardModel {
    private int mPic, mPic2;
    private String mText, mText2;
    private int set[], color[] = {
            Color.RED,
            Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.GREEN

    };

    public CardModel(String mText,String mText2, int mPic){
        this.mPic = mPic;
        this.mPic2 = mPic2;
        this.mText = mText;
        this.mText2 = mText2;
    }

    public String getText(){
        return this.mText;
    }

    public String getText2(){return this.mText2;}

    public void setText(String mText){
        this.mText = mText;
    }

    public void setText2(String mText2){this.mText2 = mText2;}

    public int getPic(){return this.mPic;}
    public Drawable getPic2(int i){return TextDrawable.builder().buildRound("$",color[i]);}

    public void setPic(int mPic){this.mPic = mPic;}
    public void setPic2(int mPic2){this.mPic2 = mPic2;}
}
