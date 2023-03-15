package com.transaction.util;

import java.util.Arrays;
import java.util.List;

public class PromocodeValidator {

	public static void ValidatePromoCode(String promocode) {
		List<String> promoCodes = Arrays.asList("AA","BB","CC");
		if(!promoCodes.contains(promocode)) {
			throw new RuntimeException("Invalid Promocode !! Please verify before enter again");
		}
		
	}
}
