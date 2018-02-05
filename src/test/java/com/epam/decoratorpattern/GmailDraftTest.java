package com.epam.decoratorpattern;


import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.decoratorpattern.businessobjects.BasicBO;
import com.epam.decoratorpattern.businessobjects.DraftsBO;
import com.epam.decoratorpattern.businessobjects.GmailLogInBO;
import com.epam.decoratorpattern.businessobjects.SentMailBO;
import com.epam.decoratorpattern.driverfactory.DriverType;
import com.epam.decoratorpattern.propmodel.GmailData;

import junit.framework.TestCase;


public class GmailDraftTest extends TestCase {
	private BasicBO steps;
	private  GmailLogInBO gmailLogInBO;
	private  DraftsBO draftsBO;
	private SentMailBO sentMailBO;
	private GmailData gmailData;
	// Business objects
		//private final GmailLoginBO loginBO = new GmailLoginBO();
		//private final GmailSearchBO gmailSearchBO = new GmailSearchBO();

	
	@BeforeClass(description = "init browser")
	public void setUp() {
		steps = new BasicBO();
		gmailLogInBO = new GmailLogInBO();
		draftsBO=new DraftsBO();
		sentMailBO=new SentMailBO();
		steps.initBrowser(DriverType.CHROME);
		gmailData=new GmailData();
	}

	@Test
	public void draftSentLetterTest() {
		gmailLogInBO.login(gmailData.getUserLogin(), gmailData.getUserPassword());
		assertTrue(gmailLogInBO.isUserLoggedIn());
		draftsBO.createDraft(gmailData.getMessageSentTo(), gmailData.getMessageSubject(), gmailData.getMessageText());
		assertTrue(draftsBO.isMessageInDrafts(gmailData.getMessageText()));
		sentMailBO.sendMessageFromDrafts(gmailData.getMessageText()); 
		assertTrue(sentMailBO.isMessageInSent(gmailData.getMessageText()));
	}

	@AfterClass(description = "close browser")
	public void tearDownUserCanLogin() {
		steps.closeBrowser();
	}

}
