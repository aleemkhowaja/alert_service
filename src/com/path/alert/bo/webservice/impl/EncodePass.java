package com.path.alert.bo.webservice.impl;

import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.SecurityUtils;

public class EncodePass {

	public static void main(String[] args) throws BaseException {
		
		String encodedPass = (String) SecurityUtils.encodeB64("321");
		System.out.println(encodedPass);

	}

}
