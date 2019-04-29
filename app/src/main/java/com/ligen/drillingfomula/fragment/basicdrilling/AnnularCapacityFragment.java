package com.ligen.drillingfomula.fragment.basicdrilling;

import android.view.LayoutInflater;
import android.widget.EditText;

import com.ligen.drillingfomula.R;
import com.ligen.drillingfomula.fragment.CalculateFragment;

/**
 * 计算配浆粘土体积
 * @author Ligen 创建于2015/8/24
 *
 */
public class AnnularCapacityFragment extends CalculateFragment {

	@Override
	public void initLayout(LayoutInflater inflater) {
		rootView = inflater.inflate(R.layout.fragment_annular_capacity, null);
	}

	@Override
	public void initView() {
		etParameter1 = (EditText) getActivity().findViewById(R.id.et_wellboresize);
		etParameter2 = (EditText) getActivity().findViewById(R.id.et_drillpipesize);
		etResult = (EditText) getActivity().findViewById(R.id.et_result);
	}

	@Override
	public void calculate() {
		if(etParameter1.getText().length()>0 && etParameter2.getText().length()>0 ) {
			double outerSize = Double.parseDouble(etParameter1.getText().toString());
			double innerSize = Double.parseDouble(etParameter2.getText().toString());
			double result = (outerSize*outerSize - innerSize*innerSize) / 1029.4;
			etResult.setText("" + result);
		}
		
	}
}
