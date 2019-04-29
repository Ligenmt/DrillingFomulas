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
import com.ligen.drillingfomula.dao.Favourite;
import com.ligen.drillingfomula.dao.FavouriteDao;
import com.ligen.drillingfomula.tool.FragmentFactory;

/**
 * 定向井公式二级菜单
 * @author lenov0
 *
 */
public class FavouriteMenuFragment extends Fragment implements OnItemClickListener{

	
	private View rootView;
//	@ViewInject(R.id.btn_back)
	private Button btnBack;
//	@ViewInject(R.id.lv_sub_menu)
	private ListView lvMenu;
//	@ViewInject(R.id.tv_menu_title)
	private TextView tvMenuTitle;
	//数据库获取的数据
	private List<Favourite> favourites;
	//用于ListView的数据
	private List<String> titleList;
	
	private ArrayAdapter<String> adapter;
	private FavouriteDao dao;
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		tvMenuTitle.setText("我的收藏");
		dao = new FavouriteDao(getActivity());
		favourites = dao.findAll();
		
		initListView();
		
		btnBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				((MainActivity)getActivity()).goBack();
			}
		});
	}

	private void initListView() {
		titleList = new ArrayList<String>();
		for(Favourite f : favourites) {
			titleList.add(f.getTitleName());
		}
		adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, titleList);
		lvMenu.setAdapter(adapter);
		lvMenu.setOnItemClickListener(this);
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
		System.out.println(position);
		Fragment f = null;
		String className = favourites.get(position).getClassName();
		f = FragmentFactory.getInstance().createFragmentFromClassName(className);
		String titleName = favourites.get(position).getTitleName();
		
		changeCalFragment(f, titleName);
	}

	private void changeCalFragment(Fragment f, String titleName) {
		if(getActivity() instanceof MainActivity) {
			((MainActivity)getActivity()).switchCalFragment(f, titleName);
		}
		
	}
	/**
	 * 删除收藏时更新菜单，得重新读一遍数据库
	 * @author Ligen
	 * @version 2015-8-12
	 */
	public void updateList() {
		favourites = dao.findAll();
		titleList.clear();
		for(Favourite f : favourites) {
			titleList.add(f.getTitleName());
		}
		adapter.notifyDataSetChanged();
	}
}
