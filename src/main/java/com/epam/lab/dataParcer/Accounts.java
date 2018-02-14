package com.epam.lab.dataParcer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class Accounts {


        @XmlElement(name = "accounts", type = Account.class)
        private List <Account> accountList = null;

        public Accounts() {
        }

        public Accounts(List <Account> accountList) {
            this.accountList = accountList;
        }


        public List <Account> getAccountList() {
            return accountList;
        }

        public void setAccountList (List <Account> accountList) {
            this.accountList = accountList;
        }
}
