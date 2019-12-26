/**
 * 
 */
package com.wesley.gateway.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author jojo
 *
 */
@Data
@ToString
public class TokenInfo {

	private boolean active;
	
	private String client_id;
	
	private String[] scope;
	
	private String user_name;
	
	private String[] aud;
	
	private Date exp;
	
	private String[] authorities;
 	
}
