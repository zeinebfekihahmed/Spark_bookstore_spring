package tn.esprit.bookStore.entities;

import javax.validation.constraints.Email;

import javax.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailTemplate {
@Email
	private String sendTo;
@Max (value=100)
	private String subject;
@Max(value=500)
private String body;

public String getSendTo(){
	return sendTo;
}
public void setSendTo(String sendTo){
	this.sendTo=sendTo;
}
	
	

}
