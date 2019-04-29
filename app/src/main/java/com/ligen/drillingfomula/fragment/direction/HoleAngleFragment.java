package com.ligen.drillingfomula.fragment.direction;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;


public class HoleAngleFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_hole_angle, null);

	}

	@Override
	protected void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_dip_angle);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_included_angle);
		etResult = (EditText) getActivity().findViewById(R.id.et_result); 
	}

	@Override
	protected void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0) {
			double dipAngle = Double.parseDouble(etParameter1.getText().toString());
			double includedAngle = Double.parseDouble(etParameter2.getText().toString());
			double result = 90 - Math.atan(Math.tan(dipAngle) * Math.cos(includedAngle));
			etResult.setText(result + "");
		}

	}

}
