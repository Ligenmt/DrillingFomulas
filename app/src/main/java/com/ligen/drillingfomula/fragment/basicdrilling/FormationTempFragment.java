package com.ligen.drillingfomula.fragment.basicdrilling;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;


/**
 * 地层温度计算
 * @author Ligen 创建于2015/8/11
 *
 */
public class FormationTempFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_formation_temperature, null);
	}

	@Override
	public void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_surface);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_temp_g);
		etParameter3 = (EditText) getActivity().findViewById(R.id.et_depth);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	public void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 && 
				etParameter3.getText().length()>0) {
			double surfaceT = Double.parseDouble(etParameter1.getText().toString());
			double g = Double.parseDouble(etParameter2.getText().toString());
			double depth = Double.parseDouble(etParameter3.getText().toString());
			
			double result = surfaceT + g * depth;
			etResult.setText("" + result);
		}
		
	}
}
