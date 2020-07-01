package com.nya.fgopedia.adapterSlider;

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
            R.drawable.utama,
            R.drawable.utama,
            R.drawable.utama
    };

    public String[] title_slide = {
            "Welcome", "Welcome", "Welcome"
    };

    public String[] desc_slide = {
            "Tambahkan teks disini agar terlihat lebih keren", "Tambahkan teks disini agar terlihat lebih keren",
            "Tambahkan teks disini agar terlihat lebih keren"
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
