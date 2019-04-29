package com.ligen.drillingfomula.fragment.basicdrilling;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;

/**
 * ECD计算
 * @author Ligen 创建于2015/8/11
 *
 */
public class ECDFragment extends CalculateFragment {
	
	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_ecd, null);
	}

	@Override
	public void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_pressure);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_mudweight);
		etParameter3 = (EditText) getActivity().findViewById(R.id.et_depth);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	public void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 && 
				etParameter3.getText().length()>0) {
			double pressure = Double.parseDouble(etParameter1.getText().toString());
			double mudweight = Double.parseDouble(etParameter2.getText().toString());
			double depth = Double.parseDouble(etParameter3.getText().toString());
			
			double result = pressure / 0.052 / depth / mudweight + mudweight; 
			etResult.setText("" + result);
		}
		
	}
}
