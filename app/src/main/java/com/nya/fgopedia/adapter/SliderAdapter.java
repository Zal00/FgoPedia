package com.nya.fgopedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.nya.fgopedia.R;


public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] image_slide = {
            R.drawable.saasd,
            R.drawable.pngfind,
            R.drawable.servant_slider
    };

    public String[] title_slide = {
            "Selamat Datang di FGO Pedia", "News", "Servant List"
    };

    public String[] desc_slide = {
            "Ada beberapa Fitur yang tersedia disini, swipe untuk melihatnya", "Menampilkan Berita Update terbaru fate grand order",
            "Menampilkan list servant, mencari servant dan detail dari servant tersebut"
    };

    public int getCount() { return image_slide.length;}

    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ((TextView) view.findViewById(R.id.judul_slide)).setText(title_slide[position]);
        ((TextView) view.findViewById(R.id.isi_slide)).setText(desc_slide[position]);
        ((ImageView) view.findViewById(R.id.slide_image)).setImageResource(image_slide[position]);
        container.addView(view);

        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
