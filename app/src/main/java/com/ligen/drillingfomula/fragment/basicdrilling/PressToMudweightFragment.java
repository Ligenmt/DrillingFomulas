package com.ligen.drillingfomula.fragment.basicdrilling;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;

/**
 * 压力与泥浆密度的转换
 * @author Ligen
 * 创建于2015/8/11
 *
 */
public class PressToMudweightFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_press_to_mudweight, null);
	}

	@Override
	public void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_press);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_depth);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	public void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 ) {
			double press = Double.parseDouble(etParameter1.getText().toString());
			double depth = Double.parseDouble(etParameter2.getText().toString());
			
			double result = press / 0.052 / depth;
			etResult.setText("" + result);
		}
		
	}
}
