package com.example.arraylistapplication;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListServise {

    private static final ArrayList<Element> arrayList = new ArrayList<>();

    public static ArrayList getArrayList() {
        return arrayList;
    }

    public void onAdd(Element elementAdd) {

        Boolean test = AddElementController.getTest();

        if (test) {
            arrayList.add(elementAdd);
        }

    }

    public void onRemove(int elementSearchDelete) {
        int size = arrayList.size();

        if (elementSearchDelete != size) {
            arrayList.remove(elementSearchDelete);
        }
    }

    public void onEdit(Element changeElements) {
        Boolean changeTest = EditElementController.getChangeTest();

        if (changeTest) {
            int inedexedit = EditElementController.getIndexGet();
            arrayList.set(inedexedit, changeElements);
        }
    }

    public void onClear(Boolean status) {

        if (status) {
            arrayList.clear();
        }

    }

    public void onSort(Boolean statusSort) {
        if(statusSort ==  null) {
        }
        else {
            if (statusSort) {
                arrayList.sort(Collections.reverseOrder());
            } else {
                Collections.sort(arrayList);
            }
        }
    }
}
