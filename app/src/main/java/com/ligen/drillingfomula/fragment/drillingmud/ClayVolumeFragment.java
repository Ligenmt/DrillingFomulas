package com.ligen.drillingfomula.fragment.drillingmud;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;


public class ClayVolumeFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_clay_volume, null);
	}

	@Override
	protected void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_mud_volume);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_den_clay);
		etParameter3 = (EditText) getActivity().findViewById(R.id.et_den_mud);
		etParameter4 = (EditText) getActivity().findViewById(R.id.et_den_water);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	protected void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 &&
			etParameter3.getText().length()>0 && etParameter4.getText().length()>0) {
			double mudVolume = Double.parseDouble(etParameter1.getText().toString());
			double denClay = Double.parseDouble(etParameter2.getText().toString());
			double denMud = Double.parseDouble(etParameter3.getText().toString());
			double denWater = Double.parseDouble(etParameter4.getText().toString());
			
			double result = mudVolume * denClay * (denMud - denWater) / (denClay - denWater);
			etResult.setText(result + "");
		}
	}

}
