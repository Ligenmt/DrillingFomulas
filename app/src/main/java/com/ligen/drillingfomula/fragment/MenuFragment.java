package com.ligen.drillingfomula.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ligen.drillingfomula.MainActivity;
import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.submenufragment.BasicDrillingMenuFragment;
import com.ligen.drillingfomula.fragment.submenufragment.DirectionalDrillingMenuFragment;
import com.ligen.drillingfomula.fragment.submenufragment.DrillingFluidMenuFragment;
import com.ligen.drillingfomula.fragment.submenufragment.FavouriteMenuFragment;


public class MenuFragment extends Fragment implements OnItemClickListener {
	
	View rootView;
	String[] strFormula;

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ListView lvMenu = (ListView) rootView.findViewById(R.id.lv_menu);
		initStr();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, strFormula);
		lvMenu.setAdapter(adapter);
		
		lvMenu.setOnItemClickListener(this);
	}
	//读取资源文件中的字符串
	private void initStr() {
		strFormula = getResources().getStringArray(R.array.mainformula);
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		rootView = inflater.inflate(R.layout.fragment_menu, null);
		return rootView;
	}

	private BasicDrillingMenuFragment bdmFragment;
	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Fragment f = null;
		switch (position) {
			//基本钻井公式
		case 0:
			if(bdmFragment == null) {
				f = new BasicDrillingMenuFragment();
			} else {
				f = bdmFragment;
			}
			break;

		case 1:
			f = new DirectionalDrillingMenuFragment();
			break;
			
		case 2:
			f = new DrillingFluidMenuFragment();
			break;
			//收藏
		case 3:
			f = new FavouriteMenuFragment();
			break;
		case 4:
			f = new AboutFragment();
			((MainActivity)getActivity()).switchCalFragment(f, "关于");
			return;
			
		default:
			break;
		}
		
		switchFragment(f);
	}

	private void switchFragment(Fragment f) {
		
		if (getActivity() instanceof MainActivity) {
			MainActivity ma = (MainActivity) getActivity();
			ma.switchMenuFragment(f);
		}
		
	}

	
	
}
