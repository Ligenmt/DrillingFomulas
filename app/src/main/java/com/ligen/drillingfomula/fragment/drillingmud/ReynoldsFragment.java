package com.ligen.drillingfomula.fragment.drillingmud;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;


public class ReynoldsFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_reynolds, null);
	}

	@Override
	protected void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_speed);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_density);
		etParameter3 = (EditText) getActivity().findViewById(R.id.et_viscosity);
		etParameter4 = (EditText) getActivity().findViewById(R.id.et_diameter);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	protected void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 &&
				etParameter3.getText().length()>0 && etParameter4.getText().length()>0) {
			double velocity = Double.parseDouble(etParameter1.getText().toString());
			double density = Double.parseDouble(etParameter2.getText().toString());
			double viscosity = Double.parseDouble(etParameter3.getText().toString());
			double diameter = Double.parseDouble(etParameter4.getText().toString());
			
			double result = density * velocity * diameter / viscosity;
			etResult.setText(result + "");
		}
	}

}
