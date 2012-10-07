package com.povilas.sid.ktu.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.povilas.sid.ktu.tvarkarastis.R;
import com.povilas.sid.ktu.tvarkarastis.objects.SheduleColumn;

public class LectureListAdapter extends BaseAdapter{

    private Activity activity;
	private SheduleColumn ll = null;
	private static LayoutInflater inflater = null;
	
	public LectureListAdapter(Activity a, SheduleColumn ll) {
		activity = a;
		this.ll = ll;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
    public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if (convertView == null) {
		    v = inflater.inflate(R.layout.list_item, null);
		
		    String time = ll.getTime(position);
		    String subject = ll.getSubject(position);
		    String place = ll.getLocation(position);
		    TextView tt = (TextView) v.findViewById(R.id.toptext);
		    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
		    TextView rt = (TextView) v.findViewById(R.id.righttext);
		    tt.setText(subject);                            
		    bt.setText(time);
		    rt.setText(place);
		    tt.setTextColor(Color.parseColor("#" + ll.getColor(position)));
		}
		
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				View test = v.findViewById(R.id.expandtext);
				
				// TODO Use DP instead of PX
				if (test.getHeight() == 1) {
					Animation anim = new DropDownAnimation(test, 1, 40, true);
					anim.setDuration(250);
					test.startAnimation(anim);
				} else if (test.getHeight() == 40) {
					Animation anim = new DropDownAnimation(test, 40, 1, true);
					anim.setDuration(250);
					test.startAnimation(anim);
				}
			}
		});
            
        return v;
    }

	public int getCount() {
		return ll.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}
}
