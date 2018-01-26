package com.abc.notification;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClientBuilder;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.GetSendQuotaResult;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;

@Service
public class SendEmailService {
	
	private String charset = "UTF-8";



	private String FROMNAME = "ABC Bill Payment Saving";
	

    
    // Replace smtp_username with your Amazon SES SMTP user name.
    static final String SMTP_USERNAME = "AKIAJYO34GXP7L2VY2VQ";
    
    // Replace smtp_password with your Amazon SES SMTP password.
    static final String SMTP_PASSWORD = "AkgQ7ffakXMcEwDXzdCLps6csa0Kwd5farJ/9fIdwK0k";
    
    static final String AWS_ACCESS_KEY = "AKIAISKDAWNFAD6Z6TXA";
    static final String AWS_SECRET_KEY = "DXcIoVl7WIEpgopPBg/FobwJhkdHaZ0J9w5DwZ/6";
    
    // Amazon SES SMTP host name. This example uses the US West (Oregon) Region.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    
    // The port you will connect to on the Amazon SES SMTP endpoint. 
    static final int PORT = 587;
    
    private AmazonSimpleEmailServiceAsync sesAsync = null;
    

    
    private AmazonSimpleEmailServiceAsync getSesAsync() {
    	if (this.sesAsync == null){
    		this.sesAsync = AmazonSimpleEmailServiceAsyncClientBuilder.standard()
	    			.withRegion(Regions.US_EAST_1)
	    			.withCredentials(new AWSStaticCredentialsProvider(this.getAwsCredentials()))
	    			.withExecutorFactory(() -> Executors.newFixedThreadPool(10))
	    			.build();
    	}
		return sesAsync;
	}

	public void setSesAsync(AmazonSimpleEmailServiceAsync sesAsync) {
		this.sesAsync = sesAsync;
	}

	public Future<SendEmailResult> sendEmailAsync(String fromAddress, String toAddress, String subject, String body) throws Exception{
    	
    	Future<SendEmailResult> futSER = null;
    	
    	try{
    	
	    	this.sesAsync = this.getSesAsync();
	    	
	    	SendEmailRequest request = generateSendEmailRequest(fromAddress,toAddress, subject, body);
	    	
	    	System.out.println("Sending... Subject["+subject+"]...");
	    	
	    	futSER = sesAsync.sendEmailAsync(request, new CustomAsyncHandler());
	    	
	    	
	    	
	    	System.out.println("Email sent! Subject["+subject+"]");
    	}catch(Exception e){
    		e.printStackTrace();
    		throw e;
    	}
    	return futSER;
    }
    
    public GetSendQuotaResult getSendQuotaResult(){
    	
    	GetSendQuotaResult result = null;
    	AWSCredentials awsCreds = getAwsCredentials();
    	
    	AmazonSimpleEmailService ses = null;
    	
    	try{
    		ses = AmazonSimpleEmailServiceClientBuilder.standard()
	    			.withRegion(Regions.US_EAST_1)
	    			.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    		
    		result = ses.getSendQuota();
    		
    	}catch(Exception e){
    		
    	}finally{
    		if(ses !=null)
    			ses.shutdown();
    	}
    	
    	return result;
    }

	private AWSCredentials getAwsCredentials() {
		AWSCredentials awsCreds = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY);
		return awsCreds;
	}

	private SendEmailRequest generateSendEmailRequest(String fromAddress, String toAddress, String subject, String body) {
		SendEmailRequest request = new SendEmailRequest()
		          .withDestination(
		              new Destination().withToAddresses(toAddress))
		          .withMessage(new com.amazonaws.services.simpleemail.model.Message()
		              .withBody(new Body()
		                  .withHtml(new Content()
		                      .withCharset(charset).withData(body)))
		              .withSubject(new Content()
		                  .withCharset(charset).withData(subject)))
		          .withSource(FROMNAME+"<"+fromAddress+">");
		return request;
	}
    
    
	public static void main(String[] args) throws Exception{
		SendEmailService ses = new SendEmailService();
		//ses.sendEmailAsync("rex.teerawat@gmail.com", "Test Main3", "Hello World3");
		GetSendQuotaResult result = ses.getSendQuotaResult();
		if (result != null){
			System.out.println("getMax24HourSend:"+result.getMax24HourSend());
			System.out.println("getMaxSendRate:"+result.getMaxSendRate());
			System.out.println("getSentLast24Hours:"+result.getSentLast24Hours());
		}
	}
	
	class CustomAsyncHandler implements AsyncHandler<SendEmailRequest, SendEmailResult>{
		

		@Override
		public void onSuccess(SendEmailRequest arg0, SendEmailResult arg1) {			
			
			System.out.println("Email sent! Subject["+arg0.getMessage().getSubject()+"] Success");
			
			
		}
		
		@Override
		public void onError(Exception arg0) {
			System.out.println("Email sent! Error:"+arg0.getMessage());
			arg0.printStackTrace();

		}
		
	}
	
}
