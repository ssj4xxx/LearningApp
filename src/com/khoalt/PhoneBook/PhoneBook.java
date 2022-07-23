package com.khoalt.PhoneBook;

import java.sql.Array;

class PhoneBook {
    private String phoneBookName;
    PhoneEntry[] phoneEntries = new PhoneEntry[2];
    int numberOfEntries = 0;

    public int getNumberOfEntries() {
        return this.numberOfEntries;
    }

    public boolean addEntry(PhoneEntry entry) {
        int capacity = phoneEntries.length;
        if (this.numberOfEntries == capacity) {
            PhoneEntry[] newPhoneEntries = new PhoneEntry[capacity * 2];
            System.arraycopy(phoneEntries, 0, newPhoneEntries, 0, capacity);
            this.phoneEntries = newPhoneEntries;
        }
        if (isDuplicateName(entry.getContactName()) || isDuplicateNumber(entry.getPhoneNumber())) return false;
        this.phoneEntries[this.numberOfEntries] = entry;
        this.numberOfEntries = this.numberOfEntries + 1;
        return true;
    }

    public boolean modifyEntryName(String oldName, String newName) {
        if (isDuplicateName(newName)) {
            return false;
        }
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.phoneEntries[i].getContactName().equals(oldName)) {
                this.phoneEntries[i].setContactName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean modifyEntryNumber(String oldNumber, String newNumber) {
        if (isDuplicateNumber(newNumber)) {
            return false;
        }
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.phoneEntries[i].getPhoneNumber().equals(oldNumber)) {
                this.phoneEntries[i].setContactName(newNumber);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEntryByName(String contactName) {
        PhoneEntry selectedEntry = findEntryByName(contactName);
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.phoneEntries[i].equals(selectedEntry)) {
                removeElement(this.phoneEntries, i);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEntryByNumber(String phoneNumber) {
        PhoneEntry selectedEntry = findEntryByNumber(phoneNumber);
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (this.phoneEntries[i].equals(selectedEntry)) {
                removeElement(this.phoneEntries, i);
                --this.numberOfEntries;
                return true;
            }
        }
        return false;
    }

    public void removeElement(Object[] array, int index) {
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
    }


    public PhoneEntry findEntryByName(String contactName) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (!this.phoneEntries[i].getContactName().equals(contactName)) continue;
            return this.phoneEntries[i];
        }
        return null;
    }

    public PhoneEntry findEntryByNumber(String phoneNumber) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (!this.phoneEntries[i].getPhoneNumber().equals(phoneNumber)) continue;
            return this.phoneEntries[i];
        }
        return null;
    }

    public boolean isDuplicateName(String contactName) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (!this.phoneEntries[i].getContactName().equals(contactName)) continue;
            return true;
        }
        return false;
    }

    public boolean isDuplicateNumber(String phoneNumber) {
        for (int i = 0; i < this.numberOfEntries; i++) {
            if (!this.phoneEntries[i].getPhoneNumber().equals(phoneNumber)) continue;
            return true;
        }
        return false;
    }

    public String toString() {
        String result = "So lien lac hien co: " + this.numberOfEntries + "\n";
        for (int i = 0; i < this.numberOfEntries; i++) {
            result = result + this.phoneEntries[i].toString() + "\n";
        }
        return result;
    }
}