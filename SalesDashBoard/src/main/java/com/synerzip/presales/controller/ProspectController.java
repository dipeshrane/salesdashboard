package com.synerzip.presales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.synerzip.presales.prospect.service.ProspectService;
import com.synerzip.presales.prospect.vo.ProspectDetailVO;

@Controller
public class ProspectController {


	@Autowired
	private ProspectService prospectService;

	@Autowired
	private View jsonView_i;
	
	private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping(value = { "/prospect/create" }, method = { RequestMethod.POST }, consumes = "application/json")
	public ModelAndView createUser(@RequestBody ProspectDetailVO detail) {

		boolean result;
		try {
			
		result = prospectService.saveOrUpdateProspect(detail);
		} catch (Exception e) {
			String sMessage = "Error creating new User. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		/**
		 * Return the view
		 */
		return new ModelAndView(jsonView_i, DATA_FIELD, result);
	}
	
	@RequestMapping(value = { "/prospect/fetchProspects/{userId}" }, method = { RequestMethod.POST }, consumes = "application/json")
	public ModelAndView fetchAllProspectsForSalesPerson(@PathVariable("userId") Long userId) {

		List<ProspectDetailVO> prospectList = null;
		try {
			prospectList = prospectService.fetchProspectsForSalesPerson(userId);
		} catch (Exception e) {
			String sMessage = "Error creating new User. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		/**
		 * Return the view
		 */
		return new ModelAndView(jsonView_i, DATA_FIELD, prospectList);
	}
	public ProspectService getProspectService() {
		return prospectService;
	}
	public void setProspectService(ProspectService prospectService) {
		this.prospectService = prospectService;
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
