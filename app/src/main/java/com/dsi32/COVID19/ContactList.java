package com.dsi32.COVID19;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactList extends ArrayAdapter<Contact> {
    private Activity context;
    List<Contact> contacts;

    public ContactList(Activity context, List<Contact> contacts) {
        super(context, R.layout.activity_listecontact, contacts);
        this.context = context;
        this.contacts = contacts;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_listecontact, null, true);


        Contact contact = contacts.get(position);
        return listViewItem;
    }

}
