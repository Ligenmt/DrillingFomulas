package com.ligen.drillingfomula.fragment.basicdrilling;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;


/**
 * 钻屑体积计算
 * @author Ligen 创建于2015/8/11
 *
 */
public class CuttingsDrilledFragment extends CalculateFragment {
	
	
	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_cuttings_drilled, null);
	}

	@Override
	public void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_porosity);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_wellboresize);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	public void calculate() {
		
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 ) {
			double porosity = Double.parseDouble(etParameter1.getText().toString());
			double wellSize = Double.parseDouble(etParameter2.getText().toString());
			double result = wellSize * wellSize * 0.7854 * (1-porosity/100) / 144;
			etResult.setText("" + result);
		}
		
	}

}
