package com.synerzip.presales.controller.masterdata;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.synerzip.presales.masterdata.service.MasterDataService;
import com.synerzip.presales.masterdata.vo.LookupVO;
import com.synerzip.presales.prospect.vo.ProspectDetailVO;

@Controller
public class MasterDataController {
	
	@Autowired
	private MasterDataService masterDataService;
	
	@Autowired
	private View jsonView_i;
	
	private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping(value = { "/masterData/fetchLookupsByName/{lookupName}" }, method = { RequestMethod.POST }, consumes = "application/json")
	public ModelAndView fetchAllLookupsByName(@PathVariable("lookupName") String lookupName,final HttpServletResponse response) {

		List<LookupVO> lookupList = null;
		response.setHeader("Access-Control-Allow-Origin", "*");

		try {
			lookupList = masterDataService.fetchLookupsByName(lookupName);
		} catch (Exception e) {
			String sMessage = "Error Fetching lookups. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		/**
		 * Return the view
		 */
		
		return new ModelAndView(jsonView_i, DATA_FIELD, lookupList);
		
	}

	
	
	@RequestMapping(value = { "//masterData/fetchLookupsByType/{lookupType}" }, method = {RequestMethod.POST}, consumes = "application/json")
	public ModelAndView fetchAllLookupsByType(@PathVariable("lookupType") String lookupType, final HttpServletResponse response){
		
		List<LookupVO> lookupList = null;
		response.setHeader("Access-Control-Allow-Origin", "*");

		try {
			lookupList = masterDataService.fetchLookupsByType(lookupType);
		} catch (Exception e) {
			String sMessage = "Error Fetching lookups. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		/**
		 * Return the view
		 */

		return new ModelAndView(jsonView_i, DATA_FIELD, lookupList);
	}
	
	public MasterDataService getMasterDataService() {
		return masterDataService;
	}

	public void setMasterDataService(MasterDataService masterDataService) {
		this.masterDataService = masterDataService;
	}

	public View getJsonView_i() {
		return jsonView_i;
	}

	public void setJsonView_i(View jsonView_i) {
		this.jsonView_i = jsonView_i;
	}
	
	
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
	
	
	
}
