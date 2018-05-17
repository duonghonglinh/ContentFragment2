package com.example.admin.contentprovidercontact2;

import android.app.Fragment;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContactFragment extends Fragment {

    ListView listView;
    ArrayList<Contact> dataArrayList;

    List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View view;
        view = inflater.inflate(R.layout.activity_fragmentcontact, container , false);

        listView = view.findViewById(R.id.lv);

        dataArrayList = new ArrayList<>();

        list = new LinkedList<>();

        ContentResolver contentResolver = getActivity().getContentResolver();

        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null);

        //vi khong bk co bao nhieu phan tu co trong mang, duyet tung dong cursor
        while (cursor.moveToNext()) {

            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String numb = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));


            // luu tru du lieu vao doi tuong contact
            Contact contact = new Contact(name, numb);

            dataArrayList.add(contact);

            list.add(name);

        }
        cursor.close();

        ArrayAdapter<Contact> adapter = new ArrayAdapter<Contact>(getActivity(), android.R.layout.simple_list_item_1 , dataArrayList);
        listView.setAdapter(adapter);

        return view;
    }
}
