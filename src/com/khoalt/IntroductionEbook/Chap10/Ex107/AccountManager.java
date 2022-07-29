package com.khoalt.IntroductionEbook.Chap10.Ex107;

public class AccountManager {
    private Account[] accountList = new Account[10];

    public Account[] createAccounts() {
        for (int i = 0; i < 10; i++) {
            accountList[i].setId(i);
            accountList[i].setBalance(100);
        }
        return accountList;
    }

    public Account selectAccount(int id) {
        return accountList[id];
    }
}
