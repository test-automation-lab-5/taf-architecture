package com.epam.fivethreads.data.handlers;

import com.epam.fivethreads.constant.Constant;
import com.epam.fivethreads.data.model.Users;
import com.epam.fivethreads.data.utils.JAXBContextProcessor;
import com.epam.fivethreads.data.utils.Object2Xml;
import org.apache.log4j.Logger;

import java.io.File;

public class UsersDataReader {
    private static final Logger LOG = Logger.getLogger(UsersDataReader.class);
    private Users users;

    public Users getUsers() {
        JAXBContextProcessor jAXBContextProcessor = new JAXBContextProcessor(new Class[]{Users.class});
        Object2Xml xmlAdapter = new Object2Xml(jAXBContextProcessor);
        users = new Users();
        users = xmlAdapter.load(new File(Constant.USERS_XML_FILE_PATH));
        LOG.info("\n"+users.toString());
        return users;
    }
}
