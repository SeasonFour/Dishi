package com.apps.dishi.userside.menu.menufilter;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by victor on 12/17/15.
 */
@ParseClassName("Meal")
public class Pets extends ParseObject {

//    public Pets() {
//        // A default constructor is required.
//    }

    public String getName(){
        return getString("Name");
    }

    public void setName(String name){
        put("Name", name);
    }

    public String getType(){
        return getString("MealType");
    }

    public void setMealType(String Type){
        put("MealType", Type);
    }

    public String getBreed(){
        return getString("Breed");
    }

    public ParseFile getPhoto(){
        return getParseFile("photo");
    }

    public void setBreed(String breed){
        put("Breed", breed);
    }

    public String getObjectID(){
        return getObjectId();
    }

    public void setObjectID(String objectID){
        put("objectId", objectID);
    }

    public static ParseQuery<Pets> getQuery(){
        return ParseQuery.getQuery(Pets.class);
    }

    @Override
    public String toString(){
        return getString("Name") + "\n" + getString("Type");
    }
}

