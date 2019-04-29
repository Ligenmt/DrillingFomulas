package com.ligen.drillingfomula.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * 计算Fragment的父类
 * 最多支持4个输入参数
 * @author Ligen
 *
 */
public abstract class CalculateFragment extends Fragment implements OnFocusChangeListener{

	
	protected View rootView;
	
	protected EditText etParameter1;
	protected EditText etParameter2;
	protected EditText etParameter3;
	protected EditText etParameter4;
	protected EditText etResult;
	
//	private String layoutId;

	public CalculateFragment() {
		super();
	}
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		initLayout(inflater);
		return rootView;
	}
	/**
	 * 初始化布局rootView
	 * @param inflater
	 */
	public abstract void initLayout(LayoutInflater inflater);
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initView();
		setListener();
	}
	

	/**
	 * 设置各个View
	 */
	protected abstract void initView();
	
	private void setListener() {
		if(etParameter1 != null) {etParameter1.setOnFocusChangeListener(this);}
		if(etParameter2 != null) {etParameter2.setOnFocusChangeListener(this);}
		if(etParameter3 != null) {etParameter3.setOnFocusChangeListener(this);}
		if(etParameter4 != null) {etParameter4.setOnFocusChangeListener(this);}
		if(etResult != null) {etResult.setOnFocusChangeListener(this);}
		
	}
	
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		if(!hasFocus) {
			calculate();
		}
	}
	/**
	 * 计算结果
	 */
	protected abstract void calculate();
}
