package com.ligen.drillingfomula.fragment.direction;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;


public class DoglegFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_dogleg, null);

	}

	@Override
	protected void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_deviation);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_azimuth);
		etParameter3 = (EditText) getActivity().findViewById(R.id.et_length);
		etParameter4 = (EditText) getActivity().findViewById(R.id.et_hole_angle);
		etResult = (EditText) getActivity().findViewById(R.id.et_result); 
	}

	@Override
	protected void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 && 
			etParameter3.getText().length()>0 && etParameter4.getText().length()>0) {
			double deviation = Double.parseDouble(etParameter1.getText().toString());
			double azimuth = Double.parseDouble(etParameter2.getText().toString());
			double length = Double.parseDouble(etParameter3.getText().toString());
			double avgAngle = Double.parseDouble(etParameter4.getText().toString());
			double result = Math.sqrt(Math.pow((deviation/length), 2) 
					+ Math.pow((azimuth/length), 2)*Math.pow(Math.sin(avgAngle), 2));
			
			etResult.setText(result + "");
		}

	}

}
