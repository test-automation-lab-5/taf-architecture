package com.epam.fivethreads.businessobjects;

import org.apache.log4j.Logger;

import com.epam.fivethreads.page.DraftsPage;
import com.epam.fivethreads.page.SentPage;

public class SentMailBO extends BasicBO{
	private static final Logger LOG = Logger.getLogger(SentMailBO.class);
	
	public void openSentMail() {
		LOG.info(" ---- SentMailBO.openSentMail() ---- ");
		SentPage sentPage = new SentPage();
		sentPage.openPage();
	}

	public boolean isMessageInSent(String messageText) {
		LOG.info(" ---- SentMailBO.isMessageInSent() ---- ");
		SentPage sentPage = new SentPage();
		return sentPage.isMasageFound(messageText);
	}
	public void sendMessageFromDrafts(String messageText) {
		LOG.info(" ---- SentMailBO.sendMessageFromDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage();
		draftsPage.openPage();
		draftsPage.sendMasageFound(messageText);
	}

}
