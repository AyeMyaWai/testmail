package co.jp.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Importing required classes

// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor

// Class
public class Emaildetails {
	 
	    // Class data members
	    private String recipient;
	    private String msgBody;
	    private String subject;
		private String attachment;

}
