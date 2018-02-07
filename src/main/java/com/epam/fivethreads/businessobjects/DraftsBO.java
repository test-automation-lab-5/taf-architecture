package com.epam.fivethreads.businessobjects;

import org.apache.log4j.Logger;

import com.epam.fivethreads.page.DraftsPage;
import com.epam.fivethreads.page.StartPage;

public class DraftsBO extends BasicBO{
	private static final Logger LOG = Logger.getLogger(DraftsBO.class);
	
	public void openDrafts() {
		LOG.info(" ---- DraftsBO.openDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage();
		draftsPage.openPage();
	}

	public void createDraft(String messageSentTo, String messageSubject, String messageText) {
		LOG.info(" ---- DraftsBO.createDraft() ---- ");
		StartPage startPage = new StartPage();
		//startPage.openPage();
		startPage.craeteMessage(messageSentTo, messageSubject, messageText);

	}

	public boolean isMessageInDrafts(String messageText) {
		LOG.info(" ---- DraftsBO.isMessageInDrafts() ---- ");
		DraftsPage draftsPage = new DraftsPage();
		return draftsPage.isMasageFound(messageText);

	}

	

}
