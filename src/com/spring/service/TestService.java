package com.spring.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entity.Doc;

@Service
public class TestService implements ITestService {

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "spring";
	}

	@Override
	public String getFold(String path) {
		// TODO Auto-generated method stub
		//System.out.println(path);
		try {
			File file = new File("C:\\Users\\vmwin7\\Documents\\eclipse-workspace\\SpringSecurity\\WebContent\\statics" + path);
			if (file.isDirectory()) {
				List<Doc> ls = new ArrayList<Doc>();
				ObjectMapper mapper = new ObjectMapper();
				File[] fileLists = file.listFiles(); // �����Ŀ¼����ȡ��Ŀ¼�µ����ݼ���
				for (int i = 0; i < fileLists.length; i++) { // ѭ�����������������
					Doc doc = new Doc();
					if (!fileLists[i].isDirectory()) { // �ж�Ԫ���ǲ���һ��Ŀ¼
						if (fileLists[i].getName().endsWith(".mp4")) {
							//System.out.println(fileLists[i].getName());
							doc.setName(fileLists[i].getName());
							doc.setType("mp4");
						}
					} else {
						//System.out.println(fileLists[i].getName());
						doc.setName(fileLists[i].getName());
						doc.setType("fold");
					}
					ls.add(doc);
				}
				return mapper.writeValueAsString(ls);
			} else {
				return "EORROR";
			}
		} catch (Exception e) {
			return "Exception";
		}
	}

}
