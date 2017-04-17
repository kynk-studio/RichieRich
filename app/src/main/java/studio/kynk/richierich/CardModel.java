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

import android.graphics.drawable.Drawable;

import com.amulyakhare.textdrawable.TextDrawable;

/**
 * Created by Naveen Kumar (kynkstduio).
 */

public class CardModel {
    private int mPic, mPic2;
    private String mText, mText2;
    private int set[], color[] = {
            R.color.c1,
            R.color.c2,
            R.color.c3,
            R.color.c4,
            R.color.c5

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

    public void setText(String mText){
        this.mText = mText;
    }

    public String getText2() {
        return this.mText2;
    }

    public void setText2(String mText2){this.mText2 = mText2;}

    public int getPic(){return this.mPic;}

    public void setPic(int mPic){this.mPic = mPic;}

    public Drawable getPic2(int i) {
        return TextDrawable.builder().buildRound("$", getColor(i));
    }

    public void setPic2(int mPic2){this.mPic2 = mPic2;}

    public int getColor(int i) {
        return this.color[i];
    }
}
