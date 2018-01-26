package com.abc.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.abc.notification.SendEmailService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.regions.Region;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.services.simpleemail.waiters.AmazonSimpleEmailServiceWaiters;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSendEmailService {

	@Autowired
	private SendEmailService sendEmailService;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String datetime = sdf.format(new Date());
	
	private ProxyAmazonSimpleEmailServiceAsync proxy = null;
	
	
	@Test
	public void testSendEmailAsyncShouldBeCalledwithSendEmailRequest() throws Exception{
		this.proxy = new ProxyAmazonSimpleEmailServiceAsync();
		
		this.sendEmailService.setSesAsync(this.proxy);
		
		this.sendEmailService.sendEmailAsync("yyy.yy@yyy.com", "xx.x@xx.com", "Test Subject", "Test Body");
		
		Assert.assertTrue(this.proxy.isSendEmailAsyncShouldBeCalledWithSendEmailRequest());
		
	}
	
	
	class ProxyAmazonSimpleEmailServiceAsync implements AmazonSimpleEmailServiceAsync{

		@Override
		public CloneReceiptRuleSetResult cloneReceiptRuleSet(CloneReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateConfigurationSetResult createConfigurationSet(CreateConfigurationSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateConfigurationSetEventDestinationResult createConfigurationSetEventDestination(
				CreateConfigurationSetEventDestinationRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateConfigurationSetTrackingOptionsResult createConfigurationSetTrackingOptions(
				CreateConfigurationSetTrackingOptionsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateCustomVerificationEmailTemplateResult createCustomVerificationEmailTemplate(
				CreateCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateReceiptFilterResult createReceiptFilter(CreateReceiptFilterRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateReceiptRuleResult createReceiptRule(CreateReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateReceiptRuleSetResult createReceiptRuleSet(CreateReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CreateTemplateResult createTemplate(CreateTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteConfigurationSetResult deleteConfigurationSet(DeleteConfigurationSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteConfigurationSetEventDestinationResult deleteConfigurationSetEventDestination(
				DeleteConfigurationSetEventDestinationRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteConfigurationSetTrackingOptionsResult deleteConfigurationSetTrackingOptions(
				DeleteConfigurationSetTrackingOptionsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteCustomVerificationEmailTemplateResult deleteCustomVerificationEmailTemplate(
				DeleteCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteIdentityResult deleteIdentity(DeleteIdentityRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteIdentityPolicyResult deleteIdentityPolicy(DeleteIdentityPolicyRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteReceiptFilterResult deleteReceiptFilter(DeleteReceiptFilterRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteReceiptRuleResult deleteReceiptRule(DeleteReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteReceiptRuleSetResult deleteReceiptRuleSet(DeleteReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteTemplateResult deleteTemplate(DeleteTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeleteVerifiedEmailAddressResult deleteVerifiedEmailAddress(DeleteVerifiedEmailAddressRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DescribeActiveReceiptRuleSetResult describeActiveReceiptRuleSet(
				DescribeActiveReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DescribeConfigurationSetResult describeConfigurationSet(DescribeConfigurationSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DescribeReceiptRuleResult describeReceiptRule(DescribeReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DescribeReceiptRuleSetResult describeReceiptRuleSet(DescribeReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetAccountSendingEnabledResult getAccountSendingEnabled(GetAccountSendingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetCustomVerificationEmailTemplateResult getCustomVerificationEmailTemplate(
				GetCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetIdentityDkimAttributesResult getIdentityDkimAttributes(GetIdentityDkimAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetIdentityMailFromDomainAttributesResult getIdentityMailFromDomainAttributes(
				GetIdentityMailFromDomainAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetIdentityNotificationAttributesResult getIdentityNotificationAttributes(
				GetIdentityNotificationAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetIdentityPoliciesResult getIdentityPolicies(GetIdentityPoliciesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetIdentityVerificationAttributesResult getIdentityVerificationAttributes(
				GetIdentityVerificationAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetSendQuotaResult getSendQuota() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetSendQuotaResult getSendQuota(GetSendQuotaRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetSendStatisticsResult getSendStatistics() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetSendStatisticsResult getSendStatistics(GetSendStatisticsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public GetTemplateResult getTemplate(GetTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListConfigurationSetsResult listConfigurationSets(ListConfigurationSetsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListCustomVerificationEmailTemplatesResult listCustomVerificationEmailTemplates(
				ListCustomVerificationEmailTemplatesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIdentitiesResult listIdentities() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIdentitiesResult listIdentities(ListIdentitiesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIdentityPoliciesResult listIdentityPolicies(ListIdentityPoliciesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListReceiptFiltersResult listReceiptFilters(ListReceiptFiltersRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListReceiptRuleSetsResult listReceiptRuleSets(ListReceiptRuleSetsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListTemplatesResult listTemplates(ListTemplatesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListVerifiedEmailAddressesResult listVerifiedEmailAddresses() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListVerifiedEmailAddressesResult listVerifiedEmailAddresses(ListVerifiedEmailAddressesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PutIdentityPolicyResult putIdentityPolicy(PutIdentityPolicyRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ReorderReceiptRuleSetResult reorderReceiptRuleSet(ReorderReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SendBounceResult sendBounce(SendBounceRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SendBulkTemplatedEmailResult sendBulkTemplatedEmail(SendBulkTemplatedEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SendCustomVerificationEmailResult sendCustomVerificationEmail(SendCustomVerificationEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SendEmailResult sendEmail(SendEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SendRawEmailResult sendRawEmail(SendRawEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SendTemplatedEmailResult sendTemplatedEmail(SendTemplatedEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SetActiveReceiptRuleSetResult setActiveReceiptRuleSet(SetActiveReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setEndpoint(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SetIdentityDkimEnabledResult setIdentityDkimEnabled(SetIdentityDkimEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SetIdentityFeedbackForwardingEnabledResult setIdentityFeedbackForwardingEnabled(
				SetIdentityFeedbackForwardingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SetIdentityHeadersInNotificationsEnabledResult setIdentityHeadersInNotificationsEnabled(
				SetIdentityHeadersInNotificationsEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SetIdentityMailFromDomainResult setIdentityMailFromDomain(SetIdentityMailFromDomainRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SetIdentityNotificationTopicResult setIdentityNotificationTopic(
				SetIdentityNotificationTopicRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SetReceiptRulePositionResult setReceiptRulePosition(SetReceiptRulePositionRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setRegion(Region arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void shutdown() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public TestRenderTemplateResult testRenderTemplate(TestRenderTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateAccountSendingEnabledResult updateAccountSendingEnabled(UpdateAccountSendingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateConfigurationSetEventDestinationResult updateConfigurationSetEventDestination(
				UpdateConfigurationSetEventDestinationRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateConfigurationSetReputationMetricsEnabledResult updateConfigurationSetReputationMetricsEnabled(
				UpdateConfigurationSetReputationMetricsEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateConfigurationSetSendingEnabledResult updateConfigurationSetSendingEnabled(
				UpdateConfigurationSetSendingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateConfigurationSetTrackingOptionsResult updateConfigurationSetTrackingOptions(
				UpdateConfigurationSetTrackingOptionsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateCustomVerificationEmailTemplateResult updateCustomVerificationEmailTemplate(
				UpdateCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateReceiptRuleResult updateReceiptRule(UpdateReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public UpdateTemplateResult updateTemplate(UpdateTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VerifyDomainDkimResult verifyDomainDkim(VerifyDomainDkimRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VerifyDomainIdentityResult verifyDomainIdentity(VerifyDomainIdentityRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VerifyEmailAddressResult verifyEmailAddress(VerifyEmailAddressRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VerifyEmailIdentityResult verifyEmailIdentity(VerifyEmailIdentityRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public AmazonSimpleEmailServiceWaiters waiters() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CloneReceiptRuleSetResult> cloneReceiptRuleSetAsync(CloneReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CloneReceiptRuleSetResult> cloneReceiptRuleSetAsync(CloneReceiptRuleSetRequest arg0,
				AsyncHandler<CloneReceiptRuleSetRequest, CloneReceiptRuleSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateConfigurationSetResult> createConfigurationSetAsync(CreateConfigurationSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateConfigurationSetResult> createConfigurationSetAsync(CreateConfigurationSetRequest arg0,
				AsyncHandler<CreateConfigurationSetRequest, CreateConfigurationSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateConfigurationSetEventDestinationResult> createConfigurationSetEventDestinationAsync(
				CreateConfigurationSetEventDestinationRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateConfigurationSetEventDestinationResult> createConfigurationSetEventDestinationAsync(
				CreateConfigurationSetEventDestinationRequest arg0,
				AsyncHandler<CreateConfigurationSetEventDestinationRequest, CreateConfigurationSetEventDestinationResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateConfigurationSetTrackingOptionsResult> createConfigurationSetTrackingOptionsAsync(
				CreateConfigurationSetTrackingOptionsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateConfigurationSetTrackingOptionsResult> createConfigurationSetTrackingOptionsAsync(
				CreateConfigurationSetTrackingOptionsRequest arg0,
				AsyncHandler<CreateConfigurationSetTrackingOptionsRequest, CreateConfigurationSetTrackingOptionsResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateCustomVerificationEmailTemplateResult> createCustomVerificationEmailTemplateAsync(
				CreateCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateCustomVerificationEmailTemplateResult> createCustomVerificationEmailTemplateAsync(
				CreateCustomVerificationEmailTemplateRequest arg0,
				AsyncHandler<CreateCustomVerificationEmailTemplateRequest, CreateCustomVerificationEmailTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateReceiptFilterResult> createReceiptFilterAsync(CreateReceiptFilterRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateReceiptFilterResult> createReceiptFilterAsync(CreateReceiptFilterRequest arg0,
				AsyncHandler<CreateReceiptFilterRequest, CreateReceiptFilterResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateReceiptRuleResult> createReceiptRuleAsync(CreateReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateReceiptRuleResult> createReceiptRuleAsync(CreateReceiptRuleRequest arg0,
				AsyncHandler<CreateReceiptRuleRequest, CreateReceiptRuleResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateReceiptRuleSetResult> createReceiptRuleSetAsync(CreateReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateReceiptRuleSetResult> createReceiptRuleSetAsync(CreateReceiptRuleSetRequest arg0,
				AsyncHandler<CreateReceiptRuleSetRequest, CreateReceiptRuleSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateTemplateResult> createTemplateAsync(CreateTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<CreateTemplateResult> createTemplateAsync(CreateTemplateRequest arg0,
				AsyncHandler<CreateTemplateRequest, CreateTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteConfigurationSetResult> deleteConfigurationSetAsync(DeleteConfigurationSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteConfigurationSetResult> deleteConfigurationSetAsync(DeleteConfigurationSetRequest arg0,
				AsyncHandler<DeleteConfigurationSetRequest, DeleteConfigurationSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteConfigurationSetEventDestinationResult> deleteConfigurationSetEventDestinationAsync(
				DeleteConfigurationSetEventDestinationRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteConfigurationSetEventDestinationResult> deleteConfigurationSetEventDestinationAsync(
				DeleteConfigurationSetEventDestinationRequest arg0,
				AsyncHandler<DeleteConfigurationSetEventDestinationRequest, DeleteConfigurationSetEventDestinationResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteConfigurationSetTrackingOptionsResult> deleteConfigurationSetTrackingOptionsAsync(
				DeleteConfigurationSetTrackingOptionsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteConfigurationSetTrackingOptionsResult> deleteConfigurationSetTrackingOptionsAsync(
				DeleteConfigurationSetTrackingOptionsRequest arg0,
				AsyncHandler<DeleteConfigurationSetTrackingOptionsRequest, DeleteConfigurationSetTrackingOptionsResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteCustomVerificationEmailTemplateResult> deleteCustomVerificationEmailTemplateAsync(
				DeleteCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteCustomVerificationEmailTemplateResult> deleteCustomVerificationEmailTemplateAsync(
				DeleteCustomVerificationEmailTemplateRequest arg0,
				AsyncHandler<DeleteCustomVerificationEmailTemplateRequest, DeleteCustomVerificationEmailTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteIdentityResult> deleteIdentityAsync(DeleteIdentityRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteIdentityResult> deleteIdentityAsync(DeleteIdentityRequest arg0,
				AsyncHandler<DeleteIdentityRequest, DeleteIdentityResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteIdentityPolicyResult> deleteIdentityPolicyAsync(DeleteIdentityPolicyRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteIdentityPolicyResult> deleteIdentityPolicyAsync(DeleteIdentityPolicyRequest arg0,
				AsyncHandler<DeleteIdentityPolicyRequest, DeleteIdentityPolicyResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteReceiptFilterResult> deleteReceiptFilterAsync(DeleteReceiptFilterRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteReceiptFilterResult> deleteReceiptFilterAsync(DeleteReceiptFilterRequest arg0,
				AsyncHandler<DeleteReceiptFilterRequest, DeleteReceiptFilterResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteReceiptRuleResult> deleteReceiptRuleAsync(DeleteReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteReceiptRuleResult> deleteReceiptRuleAsync(DeleteReceiptRuleRequest arg0,
				AsyncHandler<DeleteReceiptRuleRequest, DeleteReceiptRuleResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteReceiptRuleSetResult> deleteReceiptRuleSetAsync(DeleteReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteReceiptRuleSetResult> deleteReceiptRuleSetAsync(DeleteReceiptRuleSetRequest arg0,
				AsyncHandler<DeleteReceiptRuleSetRequest, DeleteReceiptRuleSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteTemplateResult> deleteTemplateAsync(DeleteTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteTemplateResult> deleteTemplateAsync(DeleteTemplateRequest arg0,
				AsyncHandler<DeleteTemplateRequest, DeleteTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteVerifiedEmailAddressResult> deleteVerifiedEmailAddressAsync(
				DeleteVerifiedEmailAddressRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DeleteVerifiedEmailAddressResult> deleteVerifiedEmailAddressAsync(
				DeleteVerifiedEmailAddressRequest arg0,
				AsyncHandler<DeleteVerifiedEmailAddressRequest, DeleteVerifiedEmailAddressResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeActiveReceiptRuleSetResult> describeActiveReceiptRuleSetAsync(
				DescribeActiveReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeActiveReceiptRuleSetResult> describeActiveReceiptRuleSetAsync(
				DescribeActiveReceiptRuleSetRequest arg0,
				AsyncHandler<DescribeActiveReceiptRuleSetRequest, DescribeActiveReceiptRuleSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeConfigurationSetResult> describeConfigurationSetAsync(
				DescribeConfigurationSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeConfigurationSetResult> describeConfigurationSetAsync(
				DescribeConfigurationSetRequest arg0,
				AsyncHandler<DescribeConfigurationSetRequest, DescribeConfigurationSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeReceiptRuleResult> describeReceiptRuleAsync(DescribeReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeReceiptRuleResult> describeReceiptRuleAsync(DescribeReceiptRuleRequest arg0,
				AsyncHandler<DescribeReceiptRuleRequest, DescribeReceiptRuleResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeReceiptRuleSetResult> describeReceiptRuleSetAsync(DescribeReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<DescribeReceiptRuleSetResult> describeReceiptRuleSetAsync(DescribeReceiptRuleSetRequest arg0,
				AsyncHandler<DescribeReceiptRuleSetRequest, DescribeReceiptRuleSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetAccountSendingEnabledResult> getAccountSendingEnabledAsync(
				GetAccountSendingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetAccountSendingEnabledResult> getAccountSendingEnabledAsync(
				GetAccountSendingEnabledRequest arg0,
				AsyncHandler<GetAccountSendingEnabledRequest, GetAccountSendingEnabledResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetCustomVerificationEmailTemplateResult> getCustomVerificationEmailTemplateAsync(
				GetCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetCustomVerificationEmailTemplateResult> getCustomVerificationEmailTemplateAsync(
				GetCustomVerificationEmailTemplateRequest arg0,
				AsyncHandler<GetCustomVerificationEmailTemplateRequest, GetCustomVerificationEmailTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityDkimAttributesResult> getIdentityDkimAttributesAsync(
				GetIdentityDkimAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityDkimAttributesResult> getIdentityDkimAttributesAsync(
				GetIdentityDkimAttributesRequest arg0,
				AsyncHandler<GetIdentityDkimAttributesRequest, GetIdentityDkimAttributesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityMailFromDomainAttributesResult> getIdentityMailFromDomainAttributesAsync(
				GetIdentityMailFromDomainAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityMailFromDomainAttributesResult> getIdentityMailFromDomainAttributesAsync(
				GetIdentityMailFromDomainAttributesRequest arg0,
				AsyncHandler<GetIdentityMailFromDomainAttributesRequest, GetIdentityMailFromDomainAttributesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityNotificationAttributesResult> getIdentityNotificationAttributesAsync(
				GetIdentityNotificationAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityNotificationAttributesResult> getIdentityNotificationAttributesAsync(
				GetIdentityNotificationAttributesRequest arg0,
				AsyncHandler<GetIdentityNotificationAttributesRequest, GetIdentityNotificationAttributesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityPoliciesResult> getIdentityPoliciesAsync(GetIdentityPoliciesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityPoliciesResult> getIdentityPoliciesAsync(GetIdentityPoliciesRequest arg0,
				AsyncHandler<GetIdentityPoliciesRequest, GetIdentityPoliciesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityVerificationAttributesResult> getIdentityVerificationAttributesAsync(
				GetIdentityVerificationAttributesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetIdentityVerificationAttributesResult> getIdentityVerificationAttributesAsync(
				GetIdentityVerificationAttributesRequest arg0,
				AsyncHandler<GetIdentityVerificationAttributesRequest, GetIdentityVerificationAttributesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendQuotaResult> getSendQuotaAsync() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendQuotaResult> getSendQuotaAsync(GetSendQuotaRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendQuotaResult> getSendQuotaAsync(
				AsyncHandler<GetSendQuotaRequest, GetSendQuotaResult> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendQuotaResult> getSendQuotaAsync(GetSendQuotaRequest arg0,
				AsyncHandler<GetSendQuotaRequest, GetSendQuotaResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendStatisticsResult> getSendStatisticsAsync() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendStatisticsResult> getSendStatisticsAsync(GetSendStatisticsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendStatisticsResult> getSendStatisticsAsync(
				AsyncHandler<GetSendStatisticsRequest, GetSendStatisticsResult> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetSendStatisticsResult> getSendStatisticsAsync(GetSendStatisticsRequest arg0,
				AsyncHandler<GetSendStatisticsRequest, GetSendStatisticsResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetTemplateResult> getTemplateAsync(GetTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<GetTemplateResult> getTemplateAsync(GetTemplateRequest arg0,
				AsyncHandler<GetTemplateRequest, GetTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListConfigurationSetsResult> listConfigurationSetsAsync(ListConfigurationSetsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListConfigurationSetsResult> listConfigurationSetsAsync(ListConfigurationSetsRequest arg0,
				AsyncHandler<ListConfigurationSetsRequest, ListConfigurationSetsResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListCustomVerificationEmailTemplatesResult> listCustomVerificationEmailTemplatesAsync(
				ListCustomVerificationEmailTemplatesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListCustomVerificationEmailTemplatesResult> listCustomVerificationEmailTemplatesAsync(
				ListCustomVerificationEmailTemplatesRequest arg0,
				AsyncHandler<ListCustomVerificationEmailTemplatesRequest, ListCustomVerificationEmailTemplatesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListIdentitiesResult> listIdentitiesAsync() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListIdentitiesResult> listIdentitiesAsync(ListIdentitiesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListIdentitiesResult> listIdentitiesAsync(
				AsyncHandler<ListIdentitiesRequest, ListIdentitiesResult> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListIdentitiesResult> listIdentitiesAsync(ListIdentitiesRequest arg0,
				AsyncHandler<ListIdentitiesRequest, ListIdentitiesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListIdentityPoliciesResult> listIdentityPoliciesAsync(ListIdentityPoliciesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListIdentityPoliciesResult> listIdentityPoliciesAsync(ListIdentityPoliciesRequest arg0,
				AsyncHandler<ListIdentityPoliciesRequest, ListIdentityPoliciesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListReceiptFiltersResult> listReceiptFiltersAsync(ListReceiptFiltersRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListReceiptFiltersResult> listReceiptFiltersAsync(ListReceiptFiltersRequest arg0,
				AsyncHandler<ListReceiptFiltersRequest, ListReceiptFiltersResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListReceiptRuleSetsResult> listReceiptRuleSetsAsync(ListReceiptRuleSetsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListReceiptRuleSetsResult> listReceiptRuleSetsAsync(ListReceiptRuleSetsRequest arg0,
				AsyncHandler<ListReceiptRuleSetsRequest, ListReceiptRuleSetsResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListTemplatesResult> listTemplatesAsync(ListTemplatesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListTemplatesResult> listTemplatesAsync(ListTemplatesRequest arg0,
				AsyncHandler<ListTemplatesRequest, ListTemplatesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListVerifiedEmailAddressesResult> listVerifiedEmailAddressesAsync() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListVerifiedEmailAddressesResult> listVerifiedEmailAddressesAsync(
				ListVerifiedEmailAddressesRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListVerifiedEmailAddressesResult> listVerifiedEmailAddressesAsync(
				AsyncHandler<ListVerifiedEmailAddressesRequest, ListVerifiedEmailAddressesResult> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ListVerifiedEmailAddressesResult> listVerifiedEmailAddressesAsync(
				ListVerifiedEmailAddressesRequest arg0,
				AsyncHandler<ListVerifiedEmailAddressesRequest, ListVerifiedEmailAddressesResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<PutIdentityPolicyResult> putIdentityPolicyAsync(PutIdentityPolicyRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<PutIdentityPolicyResult> putIdentityPolicyAsync(PutIdentityPolicyRequest arg0,
				AsyncHandler<PutIdentityPolicyRequest, PutIdentityPolicyResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ReorderReceiptRuleSetResult> reorderReceiptRuleSetAsync(ReorderReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<ReorderReceiptRuleSetResult> reorderReceiptRuleSetAsync(ReorderReceiptRuleSetRequest arg0,
				AsyncHandler<ReorderReceiptRuleSetRequest, ReorderReceiptRuleSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendBounceResult> sendBounceAsync(SendBounceRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendBounceResult> sendBounceAsync(SendBounceRequest arg0,
				AsyncHandler<SendBounceRequest, SendBounceResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendBulkTemplatedEmailResult> sendBulkTemplatedEmailAsync(SendBulkTemplatedEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendBulkTemplatedEmailResult> sendBulkTemplatedEmailAsync(SendBulkTemplatedEmailRequest arg0,
				AsyncHandler<SendBulkTemplatedEmailRequest, SendBulkTemplatedEmailResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendCustomVerificationEmailResult> sendCustomVerificationEmailAsync(
				SendCustomVerificationEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendCustomVerificationEmailResult> sendCustomVerificationEmailAsync(
				SendCustomVerificationEmailRequest arg0,
				AsyncHandler<SendCustomVerificationEmailRequest, SendCustomVerificationEmailResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendEmailResult> sendEmailAsync(SendEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendEmailResult> sendEmailAsync(SendEmailRequest ser,
				AsyncHandler<SendEmailRequest, SendEmailResult> ah) {
			
			if (ser != null){
				
				this.sendEmailAsyncShouldBeCalledWithSendEmailRequest = true;
				
			}
			
			return new Future<SendEmailResult>(){

				@Override
				public boolean cancel(boolean mayInterruptIfRunning) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isCancelled() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isDone() {
					// TODO Auto-generated method stub
					return true;
				}

				@Override
				public SendEmailResult get() throws InterruptedException, ExecutionException {
					// TODO Auto-generated method stub
					return new SendEmailResult();
				}

				@Override
				public SendEmailResult get(long timeout, TimeUnit unit)
						throws InterruptedException, ExecutionException, TimeoutException {
					// TODO Auto-generated method stub
					return null;
				}
				
			};
		}
		
		private boolean sendEmailAsyncShouldBeCalledWithSendEmailRequest = false;
		
		public boolean isSendEmailAsyncShouldBeCalledWithSendEmailRequest(){
			return this.sendEmailAsyncShouldBeCalledWithSendEmailRequest;
		}

		@Override
		public Future<SendRawEmailResult> sendRawEmailAsync(SendRawEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendRawEmailResult> sendRawEmailAsync(SendRawEmailRequest arg0,
				AsyncHandler<SendRawEmailRequest, SendRawEmailResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendTemplatedEmailResult> sendTemplatedEmailAsync(SendTemplatedEmailRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SendTemplatedEmailResult> sendTemplatedEmailAsync(SendTemplatedEmailRequest arg0,
				AsyncHandler<SendTemplatedEmailRequest, SendTemplatedEmailResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetActiveReceiptRuleSetResult> setActiveReceiptRuleSetAsync(SetActiveReceiptRuleSetRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetActiveReceiptRuleSetResult> setActiveReceiptRuleSetAsync(SetActiveReceiptRuleSetRequest arg0,
				AsyncHandler<SetActiveReceiptRuleSetRequest, SetActiveReceiptRuleSetResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityDkimEnabledResult> setIdentityDkimEnabledAsync(SetIdentityDkimEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityDkimEnabledResult> setIdentityDkimEnabledAsync(SetIdentityDkimEnabledRequest arg0,
				AsyncHandler<SetIdentityDkimEnabledRequest, SetIdentityDkimEnabledResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityFeedbackForwardingEnabledResult> setIdentityFeedbackForwardingEnabledAsync(
				SetIdentityFeedbackForwardingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityFeedbackForwardingEnabledResult> setIdentityFeedbackForwardingEnabledAsync(
				SetIdentityFeedbackForwardingEnabledRequest arg0,
				AsyncHandler<SetIdentityFeedbackForwardingEnabledRequest, SetIdentityFeedbackForwardingEnabledResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityHeadersInNotificationsEnabledResult> setIdentityHeadersInNotificationsEnabledAsync(
				SetIdentityHeadersInNotificationsEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityHeadersInNotificationsEnabledResult> setIdentityHeadersInNotificationsEnabledAsync(
				SetIdentityHeadersInNotificationsEnabledRequest arg0,
				AsyncHandler<SetIdentityHeadersInNotificationsEnabledRequest, SetIdentityHeadersInNotificationsEnabledResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityMailFromDomainResult> setIdentityMailFromDomainAsync(
				SetIdentityMailFromDomainRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityMailFromDomainResult> setIdentityMailFromDomainAsync(
				SetIdentityMailFromDomainRequest arg0,
				AsyncHandler<SetIdentityMailFromDomainRequest, SetIdentityMailFromDomainResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityNotificationTopicResult> setIdentityNotificationTopicAsync(
				SetIdentityNotificationTopicRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetIdentityNotificationTopicResult> setIdentityNotificationTopicAsync(
				SetIdentityNotificationTopicRequest arg0,
				AsyncHandler<SetIdentityNotificationTopicRequest, SetIdentityNotificationTopicResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetReceiptRulePositionResult> setReceiptRulePositionAsync(SetReceiptRulePositionRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<SetReceiptRulePositionResult> setReceiptRulePositionAsync(SetReceiptRulePositionRequest arg0,
				AsyncHandler<SetReceiptRulePositionRequest, SetReceiptRulePositionResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<TestRenderTemplateResult> testRenderTemplateAsync(TestRenderTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<TestRenderTemplateResult> testRenderTemplateAsync(TestRenderTemplateRequest arg0,
				AsyncHandler<TestRenderTemplateRequest, TestRenderTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateAccountSendingEnabledResult> updateAccountSendingEnabledAsync(
				UpdateAccountSendingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateAccountSendingEnabledResult> updateAccountSendingEnabledAsync(
				UpdateAccountSendingEnabledRequest arg0,
				AsyncHandler<UpdateAccountSendingEnabledRequest, UpdateAccountSendingEnabledResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetEventDestinationResult> updateConfigurationSetEventDestinationAsync(
				UpdateConfigurationSetEventDestinationRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetEventDestinationResult> updateConfigurationSetEventDestinationAsync(
				UpdateConfigurationSetEventDestinationRequest arg0,
				AsyncHandler<UpdateConfigurationSetEventDestinationRequest, UpdateConfigurationSetEventDestinationResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetReputationMetricsEnabledResult> updateConfigurationSetReputationMetricsEnabledAsync(
				UpdateConfigurationSetReputationMetricsEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetReputationMetricsEnabledResult> updateConfigurationSetReputationMetricsEnabledAsync(
				UpdateConfigurationSetReputationMetricsEnabledRequest arg0,
				AsyncHandler<UpdateConfigurationSetReputationMetricsEnabledRequest, UpdateConfigurationSetReputationMetricsEnabledResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetSendingEnabledResult> updateConfigurationSetSendingEnabledAsync(
				UpdateConfigurationSetSendingEnabledRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetSendingEnabledResult> updateConfigurationSetSendingEnabledAsync(
				UpdateConfigurationSetSendingEnabledRequest arg0,
				AsyncHandler<UpdateConfigurationSetSendingEnabledRequest, UpdateConfigurationSetSendingEnabledResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetTrackingOptionsResult> updateConfigurationSetTrackingOptionsAsync(
				UpdateConfigurationSetTrackingOptionsRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateConfigurationSetTrackingOptionsResult> updateConfigurationSetTrackingOptionsAsync(
				UpdateConfigurationSetTrackingOptionsRequest arg0,
				AsyncHandler<UpdateConfigurationSetTrackingOptionsRequest, UpdateConfigurationSetTrackingOptionsResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateCustomVerificationEmailTemplateResult> updateCustomVerificationEmailTemplateAsync(
				UpdateCustomVerificationEmailTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateCustomVerificationEmailTemplateResult> updateCustomVerificationEmailTemplateAsync(
				UpdateCustomVerificationEmailTemplateRequest arg0,
				AsyncHandler<UpdateCustomVerificationEmailTemplateRequest, UpdateCustomVerificationEmailTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateReceiptRuleResult> updateReceiptRuleAsync(UpdateReceiptRuleRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateReceiptRuleResult> updateReceiptRuleAsync(UpdateReceiptRuleRequest arg0,
				AsyncHandler<UpdateReceiptRuleRequest, UpdateReceiptRuleResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateTemplateResult> updateTemplateAsync(UpdateTemplateRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<UpdateTemplateResult> updateTemplateAsync(UpdateTemplateRequest arg0,
				AsyncHandler<UpdateTemplateRequest, UpdateTemplateResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyDomainDkimResult> verifyDomainDkimAsync(VerifyDomainDkimRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyDomainDkimResult> verifyDomainDkimAsync(VerifyDomainDkimRequest arg0,
				AsyncHandler<VerifyDomainDkimRequest, VerifyDomainDkimResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyDomainIdentityResult> verifyDomainIdentityAsync(VerifyDomainIdentityRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyDomainIdentityResult> verifyDomainIdentityAsync(VerifyDomainIdentityRequest arg0,
				AsyncHandler<VerifyDomainIdentityRequest, VerifyDomainIdentityResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyEmailAddressResult> verifyEmailAddressAsync(VerifyEmailAddressRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyEmailAddressResult> verifyEmailAddressAsync(VerifyEmailAddressRequest arg0,
				AsyncHandler<VerifyEmailAddressRequest, VerifyEmailAddressResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyEmailIdentityResult> verifyEmailIdentityAsync(VerifyEmailIdentityRequest arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Future<VerifyEmailIdentityResult> verifyEmailIdentityAsync(VerifyEmailIdentityRequest arg0,
				AsyncHandler<VerifyEmailIdentityRequest, VerifyEmailIdentityResult> arg1) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
