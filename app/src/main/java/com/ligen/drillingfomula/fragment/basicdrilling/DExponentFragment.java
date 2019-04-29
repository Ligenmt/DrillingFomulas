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
public class DExponentFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_d_exponent, null);
	}

	@Override
	public void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_speed);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_rpm);
		etParameter3 = (EditText) getActivity().findViewById(R.id.et_bitweight);
		etParameter4 = (EditText) getActivity().findViewById(R.id.et_bitdiameter);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	public void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 && 
				etParameter3.getText().length()>0 && etParameter4.getText().length()>0) {
			double rate = Double.parseDouble(etParameter1.getText().toString());
			double rpm = Double.parseDouble(etParameter2.getText().toString());
			double bitweight = Double.parseDouble(etParameter3.getText().toString());
			double bitdiameter = Double.parseDouble(etParameter4.getText().toString());
			
			double result = Math.log(rate / (60*rpm)) / Math.log(12*bitweight/1000/bitdiameter); 
			etResult.setText("" + result);
		}
		
	}
}
