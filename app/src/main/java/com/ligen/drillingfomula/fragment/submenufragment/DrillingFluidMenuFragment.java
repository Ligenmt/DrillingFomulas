package com.ligen.drillingfomula.fragment.submenufragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ligen.drillingfomula.MainActivity;
import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.tool.FragmentFactory;

/**
 * 钻井液公式二级菜单
 * @author lenov0
 *
 */
public class DrillingFluidMenuFragment extends Fragment implements OnItemClickListener {

	
	private View rootView;
//	@ViewInject(R.id.btn_back)
	private Button btnBack;
//	@ViewInject(R.id.lv_sub_menu)
	private ListView lvMenu;
//	@ViewInject(R.id.tv_menu_title)
	private TextView tvMenuTitle;
	
	private List<String> nameList;
	private String[] itemNames;
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		tvMenuTitle.setText("钻井液计算公式");
		
		nameList = new ArrayList<String>();
		itemNames = getResources().getStringArray(R.array.drilling_mud_formula);
		for(int i=0; i<itemNames.length; i++) {
			nameList.add(itemNames[i]);
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, nameList);
		lvMenu.setAdapter(adapter);
		lvMenu.setOnItemClickListener(this);
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).goBack();
			}
		});
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_sub_menu, null);
//		ViewUtils.inject(this, rootView);
		btnBack = rootView.findViewById(R.id.btn_back);
		lvMenu = rootView.findViewById(R.id.lv_sub_menu);
		tvMenuTitle = rootView.findViewById(R.id.tv_menu_title);
		return rootView;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Fragment f = FragmentFactory.getInstance().createFragmentFromTxt("drillingmudfrag.txt", position);
		String titleName = itemNames[position];
		changeCalFragment(f, titleName);
		
		
	}
	private void changeCalFragment(Fragment f, String titleName) {
		if(getActivity() instanceof MainActivity) {
			((MainActivity)getActivity()).switchCalFragment(f, titleName);
		}
	}
}
