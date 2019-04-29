package com.ligen.drillingfomula.fragment.drillingmud;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;

/**
 * 计算动切力
 * @author Ligen 
 * @version 2015-8-31
 *
 */
public class YieldPointFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_flow_index, null);
	}

	@Override
	protected void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_phi600);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_phi300);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	protected void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 ) {
			double phi600 = Double.parseDouble(etParameter1.getText().toString());
			double phi300 = Double.parseDouble(etParameter2.getText().toString());
			double miu = phi600 - phi300; //塑性粘度
			double result = 0.511 * (phi300 - miu);
			etResult.setText("" + result);
		}
	}

}
