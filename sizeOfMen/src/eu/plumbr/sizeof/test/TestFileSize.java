package eu.plumbr.sizeof.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import eu.plumbr.sizeof.MemoryCounterAgent;

public class TestFileSize {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"F:\\aceFTP\\casl\\haobai\\qingxi\\DG4_20130605.txt")); // 26006K
		
		List<String> strList = new ArrayList<String>();// 54612K
		List<String> strList2 = new ArrayList<String>(102807);// 54496K
		List<String[]> arrList = new ArrayList<String[]>(); // 155008K
		List<Record> objList = new ArrayList<Record>();// 56218K
		String[] arr = new String[102807];// 54496K
		String temp = null;
		int i=0;
		while ((temp = br.readLine()) != null) {
			strList.add(temp);
			strList2.add(temp);
			arrList.add(temp.split("\\|"));
			objList.add(new Record(temp));
			arr[i] = temp;
			i++;
		}
		
		measure(strList);
		measure(strList2);
		measure(arrList);
		measure(objList);
		measure(arr);
		br.close();

	}

	static void measure(Object obj) {
		System.out.println(obj.getClass().getName() + ": shallow size="
				+ MemoryCounterAgent.sizeOf(obj)
				+ " bytes, retained=" + MemoryCounterAgent.deepSizeOf(obj)
				/ 1024  + " K");
	}
}
