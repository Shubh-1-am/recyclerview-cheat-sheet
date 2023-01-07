package com.example.recyclerviewcheatsheet.Modal;

import java.util.List;

public class ParentBook {

    String category;
    List<ChildBook> childBookList;

    public ParentBook(String category, List<ChildBook> childBookList) {
        this.category = category;
        this.childBookList = childBookList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ChildBook> getChildBookList() {
        return childBookList;
    }

    public void setChildBookList(List<ChildBook> childBookList) {
        this.childBookList = childBookList;
    }
}
