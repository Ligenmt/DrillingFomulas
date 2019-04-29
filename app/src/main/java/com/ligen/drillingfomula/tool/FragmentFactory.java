package com.ligen.drillingfomula.tool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v4.app.Fragment;

/**
 * 加载Fragment工厂
 * @author Ligen 创建于2015/8/11
 *
 */
public class FragmentFactory {

	public static FragmentFactory instance = new FragmentFactory();

	private static Map<String, List<String>> propertyMap ;

	private FragmentFactory(){
			propertyMap = new HashMap<>();
			List<String> basicDrillingFrag = new ArrayList<>();
			basicDrillingFrag.add("com.ligen.drillingfomula.fragment.basicdrilling.CuttingsDrilledFragment");
			basicDrillingFrag.add("com.ligen.drillingfomula.fragment.basicdrilling.AnnularCapacityFragment");
			basicDrillingFrag.add("com.ligen.drillingfomula.fragment.basicdrilling.AnnularVelocityFragment");
			basicDrillingFrag.add("com.ligen.drillingfomula.fragment.basicdrilling.PressToMudweightFragment");
			basicDrillingFrag.add("com.ligen.drillingfomula.fragment.basicdrilling.FormationTempFragment");
			basicDrillingFrag.add("com.ligen.drillingfomula.fragment.basicdrilling.ECDFragment");
			basicDrillingFrag.add("com.ligen.drillingfomula.fragment.basicdrilling.DExponentFragment");
			List<String> directionalDrillingFrag = new ArrayList<>();
			directionalDrillingFrag.add("com.ligen.drillingfomula.fragment.direction.DoglegFragment");
			directionalDrillingFrag.add("com.ligen.drillingfomula.fragment.direction.HoleAngleFragment");
			List<String> drillingMudFrag = new ArrayList<>();
			drillingMudFrag.add("com.ligen.drillingfomula.fragment.drillingmud.ClayVolumeFragment");
			drillingMudFrag.add("com.ligen.drillingfomula.fragment.drillingmud.FlowIndexFragment");
			drillingMudFrag.add("com.ligen.drillingfomula.fragment.drillingmud.ReynoldsFragment");
			drillingMudFrag.add("com.ligen.drillingfomula.fragment.drillingmud.YieldPointFragment");
			propertyMap.put("basicdrillingfrag.txt", basicDrillingFrag);
			propertyMap.put("directionaldrillingfrag.txt", directionalDrillingFrag);
			propertyMap.put("drillingmudfrag.txt", drillingMudFrag);
			System.out.println("FragmentFactory inited");
	}
	
	public static FragmentFactory getInstance() {
		return instance;
	}

	public Fragment createFragmentFromClassName(String className) {
		try {
			System.out.println(className);
			Fragment fragment;
			fragment = (Fragment) Class.forName(className).newInstance();
			return fragment;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//通过配置文件加载Fragment
	public Fragment createFragmentFromTxt(String textName, int index) {
		try {
//			InputStream is = getClass().getResourceAsStream(textName);
//			String readFromStream = readFromStream(is);
//			String className[] = readFromStream.split("\n");
			List<String> list = propertyMap.get(textName);
			String className = list.get(index);
			Fragment fragment = createFragmentFromClassName(className.trim());
			return fragment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String readFromStream(InputStream is) throws IOException {
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		 byte[] buffer = new byte[1024];
		 int len = 0;
		 while((len = is.read(buffer)) != -1) {
		  baos.write(buffer, 0, len);
		 }
		 is.close();
		 String result = baos.toString();
		 baos.close();
		 return result;
		}
}
