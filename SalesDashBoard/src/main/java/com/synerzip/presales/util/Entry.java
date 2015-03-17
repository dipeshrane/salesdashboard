package com.synerzip.presales.util;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.synerzip.presales.commons.model.Lookups;
import com.synerzip.presales.commons.vo.LookupVO;
import com.synerzip.presales.prospect.model.ProspectDetail;
import com.synerzip.presales.prospect.model.ProspectTeamMix;
import com.synerzip.presales.prospect.vo.ProspectDetailVO;
import com.synerzip.presales.prospect.vo.ProspectTeamMixVO;

public class Entry {

	public static void main(String[] args) {
		/*ProspectDetailVO detail  = new ProspectDetailVO();
		detail.setName("First Prospect");
		detail.setCompanyURL("www.google.com");
		detail.setDescription("This is test prospect Created for google");
		detail.setCreatedBy(1L);
		detail.setUpdatedBy(1L);
		detail.setCreatedDate(new Date().getTime());
		detail.setUpdatedDate(new Date().getTime());
		LookupVO lookup = new LookupVO();
		lookup.setLookupId(9L);
		detail.setLookupvo(lookup);
		
		Set<ProspectTeamMixVO> teamList = new HashSet<ProspectTeamMixVO>();
		ProspectTeamMixVO mix1 = new ProspectTeamMixVO();
	
		mix1.setQuantity(4L);
		LookupVO dev = new LookupVO();
		dev.setLookupId(3L);
		mix1.setLookupvo(dev);
		
		ProspectTeamMixVO mix2 = new ProspectTeamMixVO();
		mix2.setQuantity(2L);
		LookupVO qa = new LookupVO();
		qa.setLookupId(4L);
		mix2.setLookupvo(qa);
		teamList.add(mix2);
		teamList.add(mix1);
		
		detail.setTeamMixList(teamList);
		Gson gson = new Gson();
		
		String json = gson.toJson(detail);
		System.out.println(json);*/
		
		for(int i = 1;i<50000;i++){
			if(i%7 == 0){
				//System.out.println(i);
				if( 2*i+ 1 ==0   ){
					System.out.println(i);
			}
			}
		}
	}
}
