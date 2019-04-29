package com.ligen.drillingfomula.fragment.basicdrilling;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;


/**
 * 环空流速计算
 * @author Ligen 
 * 创建于2015/8/11
 */
public class AnnularVelocityFragment extends CalculateFragment {
	
	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_annular_velocity, null);
	}

	@Override
	public void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_flowrate);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_outersize);
		etParameter3 = (EditText) getActivity().findViewById(R.id.et_innersize);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	public void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 && 
				etParameter3.getText().length()>0) {
			double flowrate = Double.parseDouble(etParameter1.getText().toString());
			double outerSize = Double.parseDouble(etParameter2.getText().toString());
			double innerSize = Double.parseDouble(etParameter3.getText().toString());
			
			double result = flowrate * 1029.4 / (outerSize*outerSize - innerSize*innerSize);
			etResult.setText("" + result);
		}
		
	}
}
